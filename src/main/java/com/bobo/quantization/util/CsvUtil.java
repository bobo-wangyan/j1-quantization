//package com.bobo.quantization.util;
//
//import com.bobo.quantization.dto.QuotaDto;
//import com.csvreader.CsvReader;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.*;
//
///**
// * @author zgy
// * @Date 2021/1/14
// */
//public class CsvUtil {
//
////
////    public static   void readCsvFile(String filePath){
////        CsvReader csvReader = null;
////        FileInputStream fin = null;
////        Map<String ,List<String>> map  = new HashMap<>();
////        try {
////
////            fin = new FileInputStream(filePath);
////            Charset charset = Charset.forName("utf-8");
////
////            csvReader = new CsvReader(fin, charset);
////            // 读表头
////            csvReader.readHeaders();
////            List header = Arrays.asList(csvReader.getHeaders());
////            map.put("header",header);
////            List<String> list1 = Arrays.asList(csvReader.getHeaders());
////            // 读内容
////            while (csvReader.readRecord()) {
////                // 读该行的某一列
////
////                System.out.println( csvReader.getRawRecord());
////
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
////
////    public static void main(String[] args) {
////        readCsvFile("G:\\workspace\\data\\df00.csv");
////    }
//}
