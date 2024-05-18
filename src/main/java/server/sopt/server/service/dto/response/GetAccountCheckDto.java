package server.sopt.server.service.dto.response;

public record GetAccountCheckDto(
         boolean success
) {
    public static GetAccountCheckDto of(Boolean success){
        return new GetAccountCheckDto(success);
    }
}
