package server.sopt.server.service.dto.request;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

public record GetInstaIdValidDto(
        String instaId
) {
}
