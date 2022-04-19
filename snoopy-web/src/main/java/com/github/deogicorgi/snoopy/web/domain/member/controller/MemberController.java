package com.github.deogicorgi.snoopy.web.domain.member.controller;

import com.github.deogicorgi.snoopy.core.domain.model.Member;
import com.github.deogicorgi.snoopy.core.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Member create(Member member) {
        memberService.create();
        return member;
    }

    @GetMapping("/{memberId}")
    public Member read(@PathVariable Long memberId) {
        return null;
    }
}
