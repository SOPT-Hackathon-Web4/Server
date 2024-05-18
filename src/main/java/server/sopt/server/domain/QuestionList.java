package server.sopt.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionList {
    QUESTION1("문제1",1),
    QUESTION2("문제1",1),
    QUESTION3("문제1",1),
    ;
    private final String question;
    private final int questionCode;
}
