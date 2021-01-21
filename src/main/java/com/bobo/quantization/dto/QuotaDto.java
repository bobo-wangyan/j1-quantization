package com.bobo.quantization.dto;

import com.github.houbb.csv.annotation.Csv;
import lombok.Data;

/**
 * @author zgy
 * @Date 2021/1/14
 * df00-指标
 */
@Data
public class QuotaDto {
    private Integer index;

    private String performance;

    private String performanceValue;

    private String ordinaryTrade;

    private String ordinaryTradeValue;

    private String oversoldTrade;

    private String oversoldTradeValue;
}
