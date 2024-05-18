package server.sopt.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import server.sopt.server.domain.Member;
import server.sopt.server.domain.Quiz;
import server.sopt.server.domain.QuizDetail;
import server.sopt.server.repository.QuizDetailRepositoy;
import server.sopt.server.repository.QuizRepository;

import server.sopt.server.service.Connect.ConnectService;
import server.sopt.server.service.Member.MemberService;
import server.sopt.server.service.dto.CreatQuizDetailRequest;
import server.sopt.server.service.dto.request.QuizResultDto;
import server.sopt.server.service.dto.response.QuizScoreDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizDetailRepositoy quizDetailRepositoy;
    private final MemberService memberService;
    private final ConnectService connectService;


    @Transactional
    public void createQuiz(
            Long memberId,
            CreatQuizDetailRequest requests
    ) {
       List<Boolean> requestLit=  List.of(requests.answer1(), requests.answer2(), requests.answer3(), requests.answer4(),requests.answer5(),requests.answer6(),requests.answer7(),requests.answer8());

        Member member = memberService.getMemberById(memberId);

        Quiz quiz = server.sopt.server.domain.Quiz.builder()
                .member(member)
                .build();

        List<QuizDetail> quizDetails = new ArrayList<>(List.of());
        for (Boolean request : requestLit) {
            QuizDetail quizDetail = QuizDetail.builder()
                    .answer(request)
                    .build();
            quizDetails.add(quizDetail);
            quizDetailRepositoy.save(quizDetail);
        }

        quiz.setQuizDetails(quizDetails);
        quizRepository.save(quiz);
    }

    @Transactional
    public QuizScoreDto checkAnswer(Long targetId,QuizResultDto quizResultDto){
        Optional<Member> challengeMember = memberService.findMemberByInstaId(quizResultDto.instaId());
        List<QuizDetail> quizDetails = memberService.getMemberById(targetId)
                .getQuiz().getQuizDetails();

//        targetMember.getQuiz().getQuizDetails()
//                .stream().forEach();
        int count =0;
        for (int i = 0; i < quizDetails.size(); i++) {
            if(quizDetails.get(i).isAnswer() == quizResultDto.quizAnswer().get(i)){
                ++count;
            }
        }
        if (count==0){
            connectService.saveConnect(challengeMember.get().getId(),targetId);
        }
        return QuizScoreDto.of(count);
    }

}
