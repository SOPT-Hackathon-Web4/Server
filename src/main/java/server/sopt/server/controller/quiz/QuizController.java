package server.sopt.server.controller.quiz;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.sopt.server.common.CommonResponse;
import server.sopt.server.exception.SuccessMessage;
import server.sopt.server.service.QuizService;
import server.sopt.server.service.dto.CreatQuizDetailRequest;
import server.sopt.server.service.dto.CreateQuizRequest;
import server.sopt.server.service.dto.request.QuizResultDto;
import server.sopt.server.service.dto.response.QuizScoreDto;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    @PostMapping
    public CommonResponse<Null> createQuiz(
            @RequestHeader Long memberId,
            @RequestBody List<CreatQuizDetailRequest> requests
    ) {
        quizService.createQuiz(
                memberId, requests
        );
        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,null);
    }
    @PostMapping("/{target-member-id}")
    public CommonResponse<QuizScoreDto> checkAnswer(
            @RequestBody QuizResultDto quizResultDto
    ){

        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,quizService.checkAnswer(quizResultDto));
    }
}
