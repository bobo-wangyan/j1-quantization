package com.bobo.quantization.dto;

import lombok.Data;

/**
 * @author zgy
 * @Date 2021/1/14
 * predict_result
 */
@Data
public class PredictResultDto {

    private String fundCode;
    private String fundName;
    private String PredictIncrease;
    private String Predictprobability;
}
