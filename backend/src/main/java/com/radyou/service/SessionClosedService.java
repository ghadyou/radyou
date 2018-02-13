package com.radyou.service;

import com.radyou.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SessionClosedService {

    @Autowired
    private MemberRepository memberRepository;

    public void execute(String memberId, Optional<String> reasonOfClose) {
        memberRepository.getByRtcId(memberId).disconnectWithReason(reasonOfClose);
    }
}
