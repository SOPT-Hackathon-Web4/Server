package server.sopt.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    private Member member;

    @OneToMany(mappedBy = "quiz")
    private List<QuizDetail> quizDetails;

    public void setQuizDetails(List<QuizDetail> quizDetails) {
        this.quizDetails = quizDetails;
    }

    @Builder
    public Quiz(Member member, List<QuizDetail> quizDetails) {
        this.member = member;
        this.quizDetails = quizDetails;
    }

}
