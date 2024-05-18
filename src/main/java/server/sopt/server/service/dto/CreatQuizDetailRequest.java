package server.sopt.server.service.dto;

import lombok.Getter;
import lombok.Setter;
import server.sopt.server.domain.QuestionType;

public record CreatQuizDetailRequest(
        QuestionType questionType,
        String question,
        Boolean answer
) {
}
