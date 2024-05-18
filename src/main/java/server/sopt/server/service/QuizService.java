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
            List<CreatQuizDetailRequest> requests
    ) {
        Member member = memberService.getMemberById(memberId);
        Quiz Quiz = quizRepository.findByMemberId(member);
        List<QuizDetail> quizDetails = new ArrayList<>(List.of());
        for (CreatQuizDetailRequest request : requests) {
            QuizDetail quizDetail = QuizDetail.builder()
                    .questionMessage(request.question())
                    .answer(request.answer())
                    .build();
            quizDetails.add(quizDetail);
            quizDetailRepositoy.save(quizDetail);
        }
        Quiz quiz = server.sopt.server.domain.Quiz.builder()
                .member(member)
                .quizDetails(quizDetails)
                .build();

        quizRepository.save(quiz);
    }

    @Transactional
    public QuizScoreDto checkAnswer(QuizResultDto quizResultDto){
        Member challengeMember = memberService.findMemberByInstaId(quizResultDto.instaId());
        List<QuizDetail> quizDetails = memberService.getMemberById(quizResultDto.targetId())
                .getQuiz().getQuizDetails();

//        targetMember.getQuiz().getQuizDetails()
//                .stream().forEach();
        int count =0;
        for (int i = 0; i < quizDetails.size(); i++) {
            if(quizDetails.get(i) == quizResultDto.quizDetails().get(i)){
                ++count;
            }
        }
        if (count==0){
            connectService.saveConnect(challengeMember.getId(),quizResultDto.targetId());
        }
        return QuizScoreDto.of(count);
    }

}
