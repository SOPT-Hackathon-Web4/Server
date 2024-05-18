package server.sopt.server.service.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import server.sopt.server.domain.Connect;
import server.sopt.server.domain.Member;
import server.sopt.server.domain.Quiz;
import server.sopt.server.domain.QuizDetail;
import server.sopt.server.repository.ConnectRepository;
import server.sopt.server.repository.MemberRepository;
import server.sopt.server.repository.QuizDetailRepositoy;
import server.sopt.server.repository.QuizRepository;
import server.sopt.server.service.QuizService;
import server.sopt.server.service.dto.request.GetAccountValidDto;
import server.sopt.server.service.dto.request.GetInstaIdValidDto;
import server.sopt.server.service.dto.request.GetMemberDetailDto;
import server.sopt.server.service.dto.response.ForDetailMemberResponse;
import server.sopt.server.service.dto.response.GetAccountCheckDto;
import server.sopt.server.service.dto.response.GetInstaIdCheckDto;
import server.sopt.server.service.dto.response.MemberDto;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final ConnectRepository connectRepository;
    private final QuizRepository quizRepository;
    private final QuizDetailRepositoy quizDetailRepositoy;

    public GetAccountCheckDto getAccountCheck(GetAccountValidDto getAccountValidDto) {
        return GetAccountCheckDto.of(
                memberRepository.findMemberByInstaId(
                                getAccountValidDto.instaId())
                        .getPassword()
                        .equals(getAccountValidDto.password()));
    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findMemberById(memberId);
    }
    public Member findMemberByInstaId (String instaId){
        return memberRepository.findMemberByInstaId(instaId);
    }
    public GetInstaIdCheckDto getInstaIdCheck(GetInstaIdValidDto getInstaIdValidDto) {
        return GetInstaIdCheckDto.of(
                memberRepository.findMemberByInstaId(getInstaIdValidDto.instaId())
                        .getInstaId().
                        equals(getInstaIdValidDto.instaId()));

    }

    @Transactional
    public ForDetailMemberResponse getMemberDetail(GetMemberDetailDto getMemberDetailDto) {
        Member member = memberRepository.findMemberById(getMemberDetailDto.memberId());
        List<Connect> connects = connectRepository.findByMemberId(member.getId());
        List<Member> members = new java.util.ArrayList<>(List.of());
        for (Connect connect : connects) {
            members.add(memberRepository.findMemberById(connect.getTargetMemberId()));
        }

        return ForDetailMemberResponse.of(member, MemberDto.convertForYouProductsToResponses(members));
    }
    public void deleteMemberById(Long memberId){
        memberRepository.deleteById(memberId);
    }
}
