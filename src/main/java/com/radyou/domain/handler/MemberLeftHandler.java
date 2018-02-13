package com.radyou.domain.handler;

import com.radyou.service.MemberLeftService;
import com.radyou.domain.handler.common.ConversationHandler;
import org.nextrtc.signalingserver.api.annotation.NextRTCEventListener;
import org.nextrtc.signalingserver.api.dto.NextRTCConversation;
import org.nextrtc.signalingserver.api.dto.NextRTCEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.nextrtc.signalingserver.api.NextRTCEvents.MEMBER_LEFT;

@Component
@NextRTCEventListener(MEMBER_LEFT)
public class MemberLeftHandler extends ConversationHandler {

    @Autowired
    private MemberLeftService service;

    @Override
    protected void handleEvent(NextRTCConversation conversation, NextRTCEvent event) {
        event.from().ifPresent(member ->
                service.execute(member.getId(), conversation.getId())
        );
    }
}
