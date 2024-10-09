package com.wap.cano_be.member.controller;

import com.wap.cano_be.common.authority.TokenInfo;
import com.wap.cano_be.common.dto.CustomUser;
import com.wap.cano_be.member.dto.LoginDto;
import com.wap.cano_be.member.dto.MemberRequestDto;
import com.wap.cano_be.member.dto.MemberResponseDto;
import com.wap.cano_be.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid MemberRequestDto memberRequestDto){
        String resultMessage = memberService.signUp(memberRequestDto);
        return ResponseEntity.ok(resultMessage);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<TokenInfo> login(@RequestBody @Valid LoginDto loginDto){
        TokenInfo tokenInfo = memberService.login(loginDto);
        return ResponseEntity.ok(tokenInfo);
    }

    // 내 정보 조회
    @GetMapping("/info")
    public ResponseEntity<MemberResponseDto> searchMyInfo(){
        long userId = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        MemberResponseDto response = memberService.searchMyInfo(userId);
        return ResponseEntity.ok(response);
    }
}
