package server.sopt.server.config;


import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import server.sopt.server.domain.Member;
import server.sopt.server.domain.Quiz;
import server.sopt.server.domain.QuizDetail;
import server.sopt.server.repository.MemberRepository;
import server.sopt.server.repository.QuizDetailRepositoy;
import server.sopt.server.repository.QuizRepository;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;


/**
 * 초기 상태 등록 Config
 */
@Component
@RequiredArgsConstructor
//@Profile(value = "!test") // test 에서는 제외
public class InitializeDefaultConfig implements ApplicationRunner {

    private final QuizRepository quizRepository;
    private final MemberRepository memberRepository;
    private final QuizDetailRepositoy quizDetailRepositoy;

    @Bean

    public void saveProduct() {
        try (Reader reader = new FileReader("build/resources/main/quiz_dummy.csv")) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

            Member member = Member.builder()
                    .name("kiru")
                    .instaId("kiru_day")
                    .password("12345678")
                    .build();
//                    .quiz()
            memberRepository.save(member);

            List<QuizDetail> quizDetails = new java.util.ArrayList<>(List.of());
            for (CSVRecord record : csvParser) {
                QuizDetail quizDetail = QuizDetail.builder()
                        .answer(Boolean.parseBoolean(record.get("answer")))
                        .build();
                quizDetails.add(quizDetail);
                quizDetailRepositoy.save(quizDetail);
            }
            Quiz quiz = Quiz.builder()
                    .quizDetails(quizDetails)
                    .member(member)
                    .build();
            quizRepository.save(quiz);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Bean
    public void saveUser() {
        Quiz quiz = quizRepository.findById(1L).orElseThrow(
                () -> new EntityNotFoundException()
        );

        try (Reader reader = new FileReader("./build/resources/main/user_dummy.csv")) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

//
            for (CSVRecord record : csvParser) {
                Member member = Member.builder()
                        .instaId(record.get("InstaId"))
                        .name(record.get("answer"))
                        .password(record.get("password"))
                        .quiz(quiz)
                        .build();
                memberRepository.save(member);
            }
//          memberRepository.save(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //더미데이터 save 작성
        saveProduct();
        saveUser();
    }
}
