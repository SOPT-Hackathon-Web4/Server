package server.sopt.server.service.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.sopt.server.repository.MemberRepository;
import server.sopt.server.service.dto.request.GetAccountValidDto;
import server.sopt.server.service.dto.response.GetAccountCheckDto;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public GetAccountCheckDto getAccountCheck(GetAccountValidDto getAccountValidDto){
        return GetAccountCheckDto.of(memberRepository.findMemberByInstagram(
                        getAccountValidDto.instaId())
                .getPassword()
                .equals(getAccountValidDto.pass()));
    }
}
