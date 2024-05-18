package server.sopt.server.service.dto;

import lombok.Getter;
import lombok.Setter;
import server.sopt.server.domain.QuestionType;


public record CreatQuizDetailRequest(
//        QuestionType questionType,
//        String question,
        boolean answer1,
        boolean answer2,
        boolean answer3,
        boolean answer4,
        boolean answer5,
        boolean answer6,
        boolean answer7,
        boolean answer8
) {
}
