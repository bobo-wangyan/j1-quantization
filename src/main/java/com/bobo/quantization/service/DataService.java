package com.bobo.quantization.service;

import com.bobo.quantization.dto.*;
import com.github.houbb.csv.bs.CsvReadBs;
import com.github.houbb.heaven.util.lang.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zgy
 * @Date 2021/1/14
 */
@Service
public class DataService {

    @Value("${root.path}")
   private  String rootPath = "G:\\workspace\\data";
    /**
     * 交易指标--df00
     * @param fileName
     * @return
     */
    public List<QuotaDto> getQuotaDtoList(String fileName){
        if(StringUtil.isBlank(fileName)){
            return null;
        }
        List<QuotaDto> list = CsvReadBs.newInstance(rootPath+"/" + fileName)
                .read(QuotaDto.class);
        return list;
    }





    /**
     * 获取账户价值--df0
     * @param fileName
     * @return
     */
    public List<AccountWorthDto> getAccountWorthDtoList(String fileName){
        if(StringUtil.isBlank(fileName)){
            return null;
        }
        List<AccountWorthDto> list = CsvReadBs.newInstance(rootPath+"/" + fileName)
                .read(AccountWorthDto.class);
        return list;
    }

    /**
     * df1
     * @param fileName
     * @return
     */
    public List<GrossLeverageDto> getGrossLeverageDtoList(String fileName){
        if(StringUtil.isBlank(fileName)){
            return null;
        }
        List<GrossLeverageDto> list = CsvReadBs.newInstance(rootPath+"/" + fileName)
                .read(GrossLeverageDto.class);
        return list;
    }

    /**
     * df2
     * @param fileName
     * @return
     */
    public List<LogReturnDto> getLogReturnDtoList(String fileName){
        if(StringUtil.isBlank(fileName)){
            return null;
        }
        List<LogReturnDto> list = CsvReadBs.newInstance(rootPath+"/" + fileName)
                .read(LogReturnDto.class);
        return list;
    }

    /**
     * 获取年化收益--df3
     * @param fileName
     * @return
     */
    public List<YearRateDto> getYearRateDtoList(String fileName){
        if(StringUtil.isBlank(fileName)){
            return null;
        }
        List<YearRateDto> list = CsvReadBs.newInstance(rootPath+"/" + fileName)
                .read(YearRateDto.class);
        return list;
    }

    /**
     * df4
     * @param fileName
     * @return
     */
    public List<HoldWarehouseWorthDto> getHoldWarehouseWorthDtoList(String fileName){
        if(StringUtil.isBlank(fileName)){
            return null;
        }
        List<HoldWarehouseWorthDto> list = CsvReadBs.newInstance(rootPath+"/" + fileName)
                .read(HoldWarehouseWorthDto.class);
        return list;
    }

    /**
     * 获取预测的结果
     * @param fileName
     * @return
     */
    public List<PredictResultDto> getPredictResultDtoList(String fileName){
        if(StringUtil.isBlank(fileName)){
            return null;
        }
        List<PredictResultDto> list = CsvReadBs.newInstance(rootPath+"/" + fileName)
                .read(PredictResultDto.class);
        return list;
    }




}
