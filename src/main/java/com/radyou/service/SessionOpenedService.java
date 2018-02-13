package com.radyou.service;

import com.radyou.domain.Member;
import org.apache.log4j.Logger;
import com.radyou.auth.AuthUtils;
import com.radyou.domain.User;
import com.radyou.repo.MemberRepository;
import org.nextrtc.signalingserver.api.dto.NextRTCMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@PreAuthorize(value = "USER")
public class SessionOpenedService {

    private static final Logger log = Logger.getLogger(SessionOpenedService.class);
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AuthUtils authUtils;

    public void execute(NextRTCMember member) {
        User user = authUtils.getAuthenticatedUser(member.getSession().getUserPrincipal());

        createConversationMemberFor(member.getId(), user);
    }

    private void createConversationMemberFor(String memberId, User user) {
        log.info("Created member: " + memberRepository.save(new Member(memberId, user)));
    }

}
