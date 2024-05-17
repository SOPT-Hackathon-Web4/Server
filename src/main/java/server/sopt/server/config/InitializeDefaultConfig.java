//package server.sopt.server.config;
//package com.app.kream.config;
//
//
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.FileReader;
//import java.io.Reader;
//
//
///**
// * 초기 상태 등록 Config
// */
//@Component
//@RequiredArgsConstructor
////@Profile(value = "!test") // test 에서는 제외
//public class InitializeDefaultConfig implements ApplicationRunner {
//
//    public void saveProduct(){
//        try (Reader reader = new FileReader("build/resources/main/db.csv")) {
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
//                    .withFirstRecordAsHeader()
//                    .withIgnoreHeaderCase()
//                    .withTrim());
//
//            for (CSVRecord record : csvParser) {
////                Product product = Product.builder()
////                        .thumbnailUrl(record.get("thumbnailUrl"))
////                        .price(record.get("price"))
////                        .engTitle(record.get("engTitle"))
////                        .title(record.get("title"))
////                        .recentPrice(record.get("recentPrice"))
////                        .variablePrice(record.get("variablePrice"))
////                        .variablePercent(record.get("variablePercent"))
////                        .releasePrice(record.get("releasePrice"))
////                        .modelNumber(record.get("modelName")) // CSV에서의 'modelName'을 'modelNumber'로 매핑
////                        .releaseDate(record.get("releaseDate")) // releaseDate가 CSV에 없으므로 이 부분은 처리가 필요
////                        .styleCount(record.get("styleCount"))
////                        .status(ProductStatus.valueOf(record.get("status"))) // status 처리 필요
////                        .transactionCount(record.get("transaction")) // transactionCount 처리 필요
////                        .brandTitle(record.get("brand")) // brandTitle 처리 필요
////                        .isFast(Boolean.parseBoolean(record.get("isFast")))
////                        .colorBest(record.get("bestColor"))
////                        .recentPrice(record.get("recentPrice"))
////                        .scrapCount(record.get("scrapCount"))
////                        .build();
////                productRepository.save(product);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
////    @Bean
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        //더미데이터 save 작성
//
//    }
//}
