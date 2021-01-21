package com.bobo.quantization.util;

import com.bobo.quantization.dto.QuotaDto;
import com.github.houbb.csv.bs.CsvReadBs;

import java.util.List;

/**
 * @author zgy
 * @Date 2021/1/14
 */
public class CsvUtil1 {


    public static void test(){
        final String path = "G:\\\\workspace\\\\data\\\\df00.csv";
        List<QuotaDto> userList = CsvReadBs.newInstance(path).startIndex(0)
                .read(QuotaDto.class);
        System.out.println(userList);
    }

    public static void main(String[] args) {
        test();
    }
}
