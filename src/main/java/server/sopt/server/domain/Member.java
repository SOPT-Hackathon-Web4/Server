package server.sopt.server.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String instaId;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String password;


    @OneToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

}
