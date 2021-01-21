package com.bobo.quantization.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zgy
 * @Date 2021/1/14
 * df3--年化收益率
 */

public class YearRateDto {

    private String dateStr;
    private String value;

    public void setValue(String value) {
        BigDecimal bg = new BigDecimal(value);
        double f1 =bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.value = String.valueOf(f1*100)+'%';
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getValue() {
        return value;
    }
}
