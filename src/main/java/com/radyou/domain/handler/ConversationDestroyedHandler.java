package com.radyou.domain.handler;

import com.radyou.domain.handler.common.ConversationHandler;
import com.radyou.service.DestroyConversationService;
import org.apache.log4j.Logger;
import org.nextrtc.signalingserver.api.annotation.NextRTCEventListener;
import org.nextrtc.signalingserver.api.dto.NextRTCConversation;
import org.nextrtc.signalingserver.api.dto.NextRTCEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.nextrtc.signalingserver.api.NextRTCEvents.CONVERSATION_DESTROYED;

@Component
@NextRTCEventListener(CONVERSATION_DESTROYED)
public class ConversationDestroyedHandler extends ConversationHandler {

    private static final Logger log = Logger.getLogger(ConversationDestroyedHandler.class);
    @Autowired
    private DestroyConversationService service;

    @Override
    protected void handleEvent(NextRTCConversation rtcConversation, NextRTCEvent event) {
        service.execute(rtcConversation.getId());
    }
}
