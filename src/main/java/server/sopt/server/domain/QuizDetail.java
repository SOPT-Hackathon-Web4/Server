package server.sopt.server.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizDetail {

//   id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QuizDetailId;
//    Quiz 감쌀 객체
    @ManyToOne
    private Quiz quiz;


    @Column(nullable = false)
    private String questionMessage;

    @Column(nullable = false)
    private QuestionType questionType;

    @Column(nullable = false)
    private boolean answer;

}
