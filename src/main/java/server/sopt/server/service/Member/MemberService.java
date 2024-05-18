package server.sopt.server.service.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.sopt.server.domain.Member;
import server.sopt.server.repository.MemberRepository;
import server.sopt.server.service.dto.request.GetAccountValidDto;
import server.sopt.server.service.dto.response.GetAccountCheckDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public GetAccountCheckDto getAccountCheck(GetAccountValidDto getAccountValidDto){
        return GetAccountCheckDto.of(findMemberByInstaId(
                        getAccountValidDto.instaId())
                .getPassword()
                .equals(getAccountValidDto.pass()));
    }
    public Member getMemberById(Long memberId){
        return memberRepository.findMemberById(memberId);
    }
    public Member findMemberByInstaId(String instaId){
        return memberRepository.findMemberByInstaId(instaId);
    }
}
