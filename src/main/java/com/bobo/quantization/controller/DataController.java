package com.bobo.quantization.controller;

import com.bobo.quantization.common.ResponseResult;
import com.bobo.quantization.dto.AccountWorthDto;
import com.bobo.quantization.dto.HoldWarehouseWorthDto;
import com.bobo.quantization.dto.QuotaDto;
import com.bobo.quantization.dto.YearRateDto;
import com.bobo.quantization.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zgy
 * @Date 2021/1/14
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/quotaList")
    public ResponseResult quotaList(){
        List<QuotaDto> quotaDtoList = dataService.getQuotaDtoList("df00.csv");
        return ResponseResult.success(quotaDtoList);
    }

    @GetMapping("/accountWorthList")
    public ResponseResult AccountWorthDtoList(){
        List<AccountWorthDto> quotaDtoList = dataService.getAccountWorthDtoList("df0.csv");
        List<String> categories = quotaDtoList.stream().map(AccountWorthDto::getDateStr).sorted(Comparator.reverseOrder()).limit(20).collect(Collectors.toList());
        List<String> data = quotaDtoList.stream().map(AccountWorthDto::getValue).sorted(Comparator.reverseOrder()).limit(20).collect(Collectors.toList());
        List<Map> series = new ArrayList<>();
        Map map1 =new HashMap();
        map1.put("name","账户价值");
        map1.put("data",data);
        series.add(map1);
        Map map = new HashMap<>();
        map.put("categories",categories);
        map.put("series",series);
        return ResponseResult.success(map);
    }

    @GetMapping("/grossLeverageList")
    public ResponseResult getGrossLeverageDtoList(){
        return ResponseResult.success(dataService.getGrossLeverageDtoList("df1.csv"));
    }

    @GetMapping("/logReturnList")
    public ResponseResult getLogReturnDtoList(){
        return ResponseResult.success(dataService.getLogReturnDtoList("df2.csv"));
    }

    @GetMapping("/yearRateList")
    public ResponseResult getYearRateDtoList(){

        List<YearRateDto> yearRateDtoList = dataService.getYearRateDtoList("df3.csv");
        List<String> categories = yearRateDtoList.stream().map(YearRateDto::getDateStr).collect(Collectors.toList());
        List<BigDecimal> data = yearRateDtoList.stream().map(item->{
            String value = item.getValue();
            BigDecimal bg = new BigDecimal(value);
            BigDecimal multiply = bg.multiply(new BigDecimal("100"));

            BigDecimal bigDecimal = multiply.setScale(2, BigDecimal.ROUND_HALF_UP);
            return bigDecimal;

        }).collect(Collectors.toList());
        List<Map> series = new ArrayList<>();
        Map map1 =new HashMap();
        map1.put("name","年化收益率");
        map1.put("data",data);
        series.add(map1);
        Map map = new HashMap<>();
        map.put("label",categories);
        map.put("value",series);
        return ResponseResult.success(map);
    }

    @GetMapping("/holdWarehouseWorthList")
    public ResponseResult getHoldWarehouseWorthList(){
        List<HoldWarehouseWorthDto> holdWarehouseWorthDtoList = dataService.getHoldWarehouseWorthDtoList("df4.csv");
        List<String> categories = holdWarehouseWorthDtoList.stream().map(HoldWarehouseWorthDto::getDataStr).sorted(Comparator.reverseOrder()).limit(20).collect(Collectors.toList());
        List<String> data1 = holdWarehouseWorthDtoList.stream().map(HoldWarehouseWorthDto::getTotalPositionValue).sorted(Comparator.reverseOrder()).limit(20).collect(Collectors.toList());
        List<BigDecimal> data = data1.stream().map(BigDecimal::new).collect(Collectors.toList());
        List<Map> series = new ArrayList<>();
        Map map1 =new HashMap();
        map1.put("name","持仓市值");
        map1.put("data",data);
        series.add(map1);
        Map map = new HashMap<>();
        map.put("label",categories);
        map.put("value",series);
        return ResponseResult.success(map);
    }

    @GetMapping("/predictResultDtoList")
    public ResponseResult getPredictResultDtoList(){
        return ResponseResult.success(dataService.getPredictResultDtoList("df00.csv"));
    }
}
