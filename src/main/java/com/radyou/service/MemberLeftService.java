package com.radyou.service;

import com.radyou.domain.Conversation;
import com.radyou.domain.Member;
import com.radyou.repo.ConversationRepository;
import com.radyou.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberLeftService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public void execute(String memberId, String conversationId) {
        Member member = memberRepository.getByRtcId(memberId);
        Conversation conversation = conversationRepository.getByConversationName(conversationId);

        member.leaves(conversation);
    }
}
