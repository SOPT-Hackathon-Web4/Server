package server.sopt.server.service.dto.response;

public record GetInstaIdCheckDto(
         boolean success
) {
    public static GetInstaIdCheckDto of(Boolean success){
        return new GetInstaIdCheckDto(success);
    }
}
