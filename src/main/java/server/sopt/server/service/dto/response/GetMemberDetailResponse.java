package server.sopt.server.service.dto.response;

import server.sopt.server.domain.Connect;
import server.sopt.server.domain.Quiz;
import server.sopt.server.domain.QuizDetail;

import java.util.List;

public record GetMemberDetailResponse(
        String instaid,
        List<QuizDetail> quizDetails,
        List<Connect> connects

) {
    public static GetMemberDetailResponse of(
            String instaid,
            List<QuizDetail> quizDetails,
            List<Connect> connects
    ) {
        return new GetMemberDetailResponse(instaid,quizDetails,connects);
    }
}
