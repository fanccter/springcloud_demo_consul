package com.fanciter.data.db.domain.second;

import java.math.BigDecimal;

public class EsGjjInfo {
    private String xingming;

    private String zjhm;

    private String grzhzt;

    private String qjny;

    private String jzny;

    private BigDecimal yjce;

    private BigDecimal grzhye;

    private String dwmc;

    private String zzjgdm;

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm == null ? null : zjhm.trim();
    }

    public String getGrzhzt() {
        return grzhzt;
    }

    public void setGrzhzt(String grzhzt) {
        this.grzhzt = grzhzt == null ? null : grzhzt.trim();
    }

    public String getQjny() {
        return qjny;
    }

    public void setQjny(String qjny) {
        this.qjny = qjny == null ? null : qjny.trim();
    }

    public String getJzny() {
        return jzny;
    }

    public void setJzny(String jzny) {
        this.jzny = jzny == null ? null : jzny.trim();
    }

    public BigDecimal getYjce() {
        return yjce;
    }

    public void setYjce(BigDecimal yjce) {
        this.yjce = yjce;
    }

    public BigDecimal getGrzhye() {
        return grzhye;
    }

    public void setGrzhye(BigDecimal grzhye) {
        this.grzhye = grzhye;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc == null ? null : dwmc.trim();
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm == null ? null : zzjgdm.trim();
    }
}