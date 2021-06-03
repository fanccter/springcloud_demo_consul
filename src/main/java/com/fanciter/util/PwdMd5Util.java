package com.fanciter.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class PwdMd5Util {

    /**
     * 明文和密文是否相等
     *
     * @param minWen 明文
     * @param miWen  密文
     * @return 比较结果
     */
    public static boolean isSame(String minWen, String miWen) {
        if (StringUtils.isBlank(minWen) || StringUtils.isBlank(miWen)) {
            return false;
        }
        return miWen.equals(md5Password(minWen));
    }

    /**
     * 根据数据获取加密之后的密码
     *
     * @param inputPwd 输入的密码
     * @return result[0]: 原密码， result[1]: 加密之后的密码
     */
    public static String[] obtainPwdByInput(String inputPwd) {
        return new String[]{inputPwd, md5Password(inputPwd)};
    }

    /**
     * 获取随机密码
     *
     * @return
     */
    public static String[] obtainRandomPwd() {

        Random r = new Random();
        int[] mode = modes[r.nextInt(5)];
        int digitNumber = mode[0];
        int upperNumber = mode[1];
        int dipperNumber = mode[2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B_8; i++) {
            int type = r.nextInt(3) + 1;
            while (true) {
                boolean isDone = false;
                switch (type) {
                    case 1:
                        if (digitNumber-- > 0) {
                            sb.append(getDigit(r));
                            isDone = true;
                        }
                        break;
                    case 2:
                        if (upperNumber-- > 0) {
                            sb.append(getUpper(r));
                            isDone = true;
                        }
                        break;
                    case 3:
                        if (dipperNumber-- > 0) {
                            sb.append(getDown(r));
                            isDone = true;
                        }
                        break;
                }

                if (isDone) {
                    break;
                }

                //如果没有成果获取到值
                type = nextType(type);
            }

        }

        String pwd = sb.toString();

        return new String[]{pwd, md5Password(pwd)};
    }

    public static final int B_8 = 8;

    private static final int[][] modes = {{1, 1, 6}, {1, 2, 5}, {1, 3, 4}, {2, 2, 4}, {2, 3, 3}};

    private static int getDigit(Random random) {
        int digit = random.nextInt(10);
        return digit;
    }

    private static char getUpper(Random random) {
        int digit = random.nextInt(26);
        return (char) (digit + 65);
    }

    private static char getDown(Random random) {
        int digit = random.nextInt(26);
        return (char) (digit + 97);
    }


    private static int nextType(int type) {
        return type < 3 ? type + 1 : 1;
    }


    /**
     * 生成32位md5码
     *
     * @param password
     * @return
     */
    public static String md5Password(String password) {
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }

            // 标准的md5加密后的结果
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            // Assert.fail(MerchantErrorCode.PWD_GENERATOR_FAIL);
            return "";
        }

    }
}
