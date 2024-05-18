package server.sopt.server.service.dto.response;

public record DeleteSuccessDto(
        Boolean success
) {
    public static DeleteSuccessDto of(Boolean success){
        return new DeleteSuccessDto(success);
    }
}
