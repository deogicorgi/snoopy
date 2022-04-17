package com.github.deogicorgi.snoopy.web.domain.member.controller;

import com.github.deogicorgi.snoopy.web.domain.member.model.Member;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
public class MemberController {

    @PostMapping
    public Member create(Member member) {
        return member;
    }

    @GetMapping("/{memberId}")
    public Member read(@PathVariable Long memberId) {
        return null;
    }
}
