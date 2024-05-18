package server.sopt.server.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springdoc.ui.SpringDocUIException;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Connect extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long targetMemberId;

    public static Connect create(Long memberId,Long targetMemberId){
        Connect connect = new Connect();
        connect.memberId = memberId;
        connect.targetMemberId = targetMemberId;
        return connect;
    }


}
