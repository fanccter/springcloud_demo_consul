package com.fanciter.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.dozer.DozerBeanMapper;

public class BeanCopyUtil {
    private static DozerBeanMapper dozer = new DozerBeanMapper();

    public BeanCopyUtil() {
    }

    public static <T> T objConvert(Object obj, Class<T> toObj) {
        return null == obj ? null : dozer.map(obj, toObj);
    }

    public static void copy(Object source, Object toObj) {
        if (null != source) {
            dozer.map(source, toObj);

        }
    }

    public static void copyDealNull(Object source, Object toObj) {
        if (null != source) {
            dozer.map(source, toObj);
            nullDeal(toObj);
        }
    }

    public static <T> List<T> convertList(Collection<?> collection, Class<T> toObj) {
        if (collection == null) {
            return null;
        } else if (toObj == null) {
            return null;
        } else {
            List<T> result = new ArrayList<>();
            for (Object o: collection) {
                result.add(dozer.map(o, toObj));
            }

            return result;
        }
    }

    /**
     * 对象空值处理
     * @param model
     */
    private static void nullDeal(Object model){
        Field[] field = model.getClass().getDeclaredFields();
        try {
            for (int j = 0; j < field.length; j++) {

                String name = field[j].getName();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                String type = field[j].getGenericType().toString();
                if (type.equals("class java.lang.String")) {
                    Method m = model.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(model);
                    if (value == null) {
                        m = model.getClass().getMethod("set"+name,String.class);
                        m.invoke(model, "");
                    }
                }
				if (type.equals("class java.lang.Integer")) {
					Method m = model.getClass().getMethod("get" + name);
					Integer value = (Integer) m.invoke(model);
					if (value == null) {
						m = model.getClass().getMethod("set"+name,Integer.class);
						m.invoke(model, 0);
					}
				}
                if (type.equals("class java.lang.Double")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Double value = (Double) m.invoke(model);
                    if (value == null) {
                        m = model.getClass().getMethod("set"+name,Double.class);
                        m.invoke(model, 0D);
                    }
                }

//				if (type.equals("class java.lang.Boolean")) {
//					Method m = model.getClass().getMethod("get" + name);
//					Boolean value = (Boolean) m.invoke(model);
//					if (value == null) {
//						m = model.getClass().getMethod("set"+name,Boolean.class);
//						m.invoke(model, false);
//					}
//				}
//				if (type.equals("class java.util.Date")) {
//					Method m = model.getClass().getMethod("get" + name);
//					Date value = (Date) m.invoke(model);
//					if (value == null) {
//						m = model.getClass().getMethod("set"+name,Date.class);
//						m.invoke(model, new Date());
//					}
//				}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static <T> List<T> convertPage(Page page, Class<T> toObj) {
//        if (page == null) {
//            return null;
//        } else if (toObj == null) {
//            return null;
//        } else {
//            Page<T> newPage = new Page<>();
//            newPage.setPageNum(page.getPageNum());
//            newPage.setPageSize(page.getPageSize());
//            newPage.setOrderBy(page.getOrderBy());
//            newPage.setPages(page.getPages());
//            newPage.setTotal(page.getTotal());
//
//            for (Object o: page) {
//                newPage.add(dozer.map(o, toObj));
//            }
//
//            return newPage;
//        }
//    }
}

