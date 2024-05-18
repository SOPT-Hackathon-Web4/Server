package server.sopt.server.service.dto.response;

import server.sopt.server.domain.Member;
import server.sopt.server.domain.QuizDetail;

import java.util.List;
import java.util.stream.Collectors;

public record ForDetailMemberResponse(
        String name,
        String instaId,
        List<MemberDto> memberDtos
) {
    public static ForDetailMemberResponse of(
            final Member member,
             List<MemberDto> memberDtos
    ) {
        return new ForDetailMemberResponse(
                member.getName(), member.getInstaId(),
                memberDtos
        );
    }
}
