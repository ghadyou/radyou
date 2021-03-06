package com.radyou.service;

import com.radyou.auth.AuthUtils;
import com.radyou.domain.Member;
import com.radyou.domain.User;
import com.radyou.repo.MemberRepository;
import org.apache.log4j.Logger;
import org.nextrtc.signalingserver.api.dto.NextRTCMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SessionOpenedService {

    private static final Logger log = Logger.getLogger(SessionOpenedService.class);
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AuthUtils authUtils;

    public void execute(NextRTCMember member) {
        //User user = authUtils.getAuthenticatedUser(member.getSession().getUserPrincipal());

        createConversationMemberFor(member.getId(), null);
    }

    private void createConversationMemberFor(String memberId, User user) {
        log.info("Created member: " + memberRepository.save(new Member(memberId, user)));
    }

}
