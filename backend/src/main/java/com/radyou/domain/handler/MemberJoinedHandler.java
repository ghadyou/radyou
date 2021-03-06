package com.radyou.domain.handler;

import com.radyou.domain.handler.common.FromMemberHandler;
import com.radyou.service.MemberJoinService;
import org.nextrtc.signalingserver.api.annotation.NextRTCEventListener;
import org.nextrtc.signalingserver.api.dto.NextRTCEvent;
import org.nextrtc.signalingserver.api.dto.NextRTCMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.nextrtc.signalingserver.api.NextRTCEvents.MEMBER_JOINED;

@Component
@NextRTCEventListener(MEMBER_JOINED)
public class MemberJoinedHandler extends FromMemberHandler {

    @Autowired
    private MemberJoinService service;

    @Override
    protected void handleEvent(NextRTCMember from, NextRTCEvent event) {
        event.conversation().ifPresent(conversation -> service.execute(from.getId(), conversation.getId()));
    }
}
