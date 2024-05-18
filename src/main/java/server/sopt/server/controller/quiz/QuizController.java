package server.sopt.server.controller.quiz;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.sopt.server.common.CommonResponse;
import server.sopt.server.service.QuizService;
import server.sopt.server.service.dto.CreatQuizDetailRequest;
import server.sopt.server.service.dto.CreateQuizRequest;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    @PostMapping
    public CommonResponse createQuiz(
            @RequestHeader Long memberId,
            @RequestBody List<CreatQuizDetailRequest> requests
    ) {
        return quizService.createQuiz(
                memberId, requests
        );
    }
}
