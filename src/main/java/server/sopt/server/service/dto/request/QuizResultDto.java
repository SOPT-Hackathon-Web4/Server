package server.sopt.server.service.dto.request;

import server.sopt.server.domain.QuizDetail;

import java.util.List;

public record QuizResultDto(
        String instaId,
        Long targetId,
        List<QuizDetail> quizDetails
) {
}
