package server.sopt.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.sopt.server.common.CommonResponse;
import server.sopt.server.domain.Member;
import server.sopt.server.domain.Quiz;
import server.sopt.server.domain.QuizDetail;
import server.sopt.server.exception.SuccessMessage;
import server.sopt.server.repository.QuizDetailRepositoy;
import server.sopt.server.repository.QuizRepository;
import server.sopt.server.service.Member.MemberService;
import server.sopt.server.service.dto.CreatQuizDetailRequest;
import server.sopt.server.service.dto.CreateQuizRequest;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizDetailRepositoy quizDetailRepositoy;
    private final MemberService memberService;

    @Transactional
    public CommonResponse createQuiz(
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
                    .questionType(request.questionType())
                    .build();
            quizDetails.add(quizDetail);
            quizDetailRepositoy.save(quizDetail);
        }
        Quiz quiz = server.sopt.server.domain.Quiz.builder()
                .member(member)
                .quizDetails(quizDetails)
                .build();

        quizRepository.save(quiz);
        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS);
    }
}
