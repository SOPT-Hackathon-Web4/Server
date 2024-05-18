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
//import server.sopt.server.domain.Member;
//import server.sopt.server.domain.QuizDetail;
//import server.sopt.server.repository.MemberRepository;
//import server.sopt.server.repository.QuizRepository;
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
//    private final QuizRepository quizRepository;
//    private final MemberRepository memberRepository;
//    public void saveProduct(){
//        try (Reader reader = new FileReader("build/resources/main/user_dummy.csv")) {
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
//                    .withFirstRecordAsHeader()
//                    .withIgnoreHeaderCase()
//                    .withTrim());
//            try (Reader reader2 = new FileReader("build/resources/main/quiz_dummy.csv")) {
//                CSVParser csvParser2 = new CSVParser(reader2, CSVFormat.DEFAULT
//                        .withFirstRecordAsHeader()
//                        .withIgnoreHeaderCase()
//                        .withTrim());
//            }
//            catch(Exception e) {
//                e.printStackTrace();
//            }
//
//            for (CSVRecord record : csvParser) {
//                Member member = Member.builder()
//                        .name(record.get("name"))
//                        .instaId(record.get("InstaId"))
//                        .password(record.get("password"))
//                        .build();
//                for (CSVRecord record2 : csvParser) {
//                    QuizDetail quizDetail = QuizDetail.builder()
//                            .quiz(record.get("name"))
//                            .instaId(record.get("InstaId"))
//                            .password(record.get("password"))
//                            .build();
//
//                        .build();
//
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
