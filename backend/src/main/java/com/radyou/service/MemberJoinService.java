package com.radyou.service;

import com.radyou.domain.Conversation;
import com.radyou.domain.Member;
import com.radyou.repo.ConversationRepository;
import com.radyou.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberJoinService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public void execute(String memberId, String conversationId) {
        Conversation conversation = conversationRepository.getByConversationName(conversationId);
        Member member = memberRepository.getByRtcId(memberId);

        conversation.join(member);
    }
}
