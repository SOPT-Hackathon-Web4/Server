package server.sopt.server.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class QuizDetail {
//    id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    Quiz 감쌀 객체
    @ManyToOne
    private Quiz quiz;


    @Column(nullable = false)
    private boolean answer;

}
