package server.sopt.server.controller.Member;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import server.sopt.server.common.CommonResponse;
import server.sopt.server.exception.SuccessMessage;
import server.sopt.server.service.Member.MemberService;
import server.sopt.server.service.dto.request.GetAccountValidDto;
import server.sopt.server.service.dto.request.GetInstaIdValidDto;
import server.sopt.server.service.dto.request.GetMemberDetailDto;
import server.sopt.server.service.dto.response.ForDetailMemberResponse;
import server.sopt.server.service.dto.response.GetAccountCheckDto;
import server.sopt.server.service.dto.response.GetInstaIdCheckDto;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/password-check")
    public CommonResponse<GetAccountCheckDto> getAccountCheck (
            @RequestHeader final  String instaId,
            @RequestHeader final String  pass
    ){
        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,memberService.getAccountCheck(instaId,pass));
    }

    @GetMapping("/member")
    public CommonResponse<GetInstaIdCheckDto>getInstaIdCheck (
            @RequestHeader final String instaId
    ){


        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,memberService.getInstaIdCheck(instaId));
    }

    @GetMapping("/member/{memberId}")
    public CommonResponse<ForDetailMemberResponse>getMemberDetail (
            @PathVariable final Long memberId
    ){
        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,memberService.getMemberDetail(memberId));
    }
}
