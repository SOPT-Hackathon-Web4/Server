package server.sopt.server.service.dto;

import java.util.List;


public record CreateQuizRequest(
        List<CreatQuizDetailRequest> requests
) {
}
