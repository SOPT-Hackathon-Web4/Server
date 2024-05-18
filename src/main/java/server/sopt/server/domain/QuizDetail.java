package server.sopt.server.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizDetail {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QuizDetailId;

    @ManyToOne
    private Quiz quiz;

    private String questionMessage;

    private boolean answer;

}
