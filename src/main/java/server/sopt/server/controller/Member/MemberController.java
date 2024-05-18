package server.sopt.server.controller.Member;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import server.sopt.server.common.CommonResponse;
import server.sopt.server.exception.SuccessMessage;
import server.sopt.server.service.Member.MemberService;
import server.sopt.server.service.dto.request.GetAccountValidDto;
import server.sopt.server.service.dto.response.GetAccountCheckDto;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/password-check")
    public CommonResponse<GetAccountCheckDto> getAccountCheck (
            @RequestHeader final GetAccountValidDto getAccountValidDto
    ){
        return CommonResponse.success(SuccessMessage.PROCESS_SUCCESS,memberService.getAccountCheck(getAccountValidDto));
    }
}
