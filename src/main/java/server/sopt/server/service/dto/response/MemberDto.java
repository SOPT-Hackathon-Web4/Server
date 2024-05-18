package server.sopt.server.service.dto.response;

import server.sopt.server.domain.Member;

import java.util.List;
import java.util.stream.Collectors;

public record MemberDto(
        String name,
        String instaId
) {
    public static MemberDto of(
            Member member
    ){
        return new MemberDto(member.getName(), member.getInstaId());
    }

    public static List<MemberDto> convertForYouProductsToResponses(
            List<Member> members
    ) {
        return members.stream()
                .map(MemberDto::of)
                .collect(Collectors.toList());
    }
}
