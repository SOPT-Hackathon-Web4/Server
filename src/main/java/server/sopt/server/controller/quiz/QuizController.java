package server.sopt.server.controller.quiz;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.sopt.server.common.CommonResponse;
import server.sopt.server.exception.SuccessMessage;
import server.sopt.server.service.Member.MemberService;
import server.sopt.server.service.QuizService;
import server.sopt.server.service.dto.CreatQuizDetailRequest;
import server.sopt.server.service.dto.CreateQuizRequest;
import server.sopt.server.service.dto.request.QuizResultDto;
import server.sopt.server.service.dto.response.DeleteSuccessDto;
import server.sopt.server.service.dto.response.QuizScoreDto;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;
    private final MemberService memberService;

    @PostMapping
    public CommonResponse<Null> createQuiz(
            @RequestHeader Long memberId,
            @RequestBody CreatQuizDetailRequest requests
    ) {
        quizService.createQuiz(
                memberId, requests
        );
        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,null);
    }
    @PostMapping("/{targetmemberid}")
    public CommonResponse<QuizScoreDto> checkAnswer(
            @PathVariable Long targetmemberid,
            @RequestBody QuizResultDto quizResultDto
    ){

        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,quizService.checkAnswer(targetmemberid,quizResultDto));
    }
    @DeleteMapping("/delete")
    public CommonResponse<DeleteSuccessDto> deleteQuiz(
        @RequestHeader Long memberId
    ){
        memberService.deleteMemberById(memberId);
        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,DeleteSuccessDto.of(true));
    }
}
