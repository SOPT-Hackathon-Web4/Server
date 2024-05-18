package server.sopt.server.service.dto.response;

public record QuizScoreDto(
        int score
) {
    public static QuizScoreDto of(int score){
        return new QuizScoreDto(score);
    }
}
