package com.radyou.domain.handler;

import com.radyou.domain.Conversation;
import com.radyou.domain.handler.common.ConversationHandler;
import com.radyou.repo.ConversationRepository;
import org.apache.log4j.Logger;
import org.nextrtc.signalingserver.api.annotation.NextRTCEventListener;
import org.nextrtc.signalingserver.api.dto.NextRTCConversation;
import org.nextrtc.signalingserver.api.dto.NextRTCEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.nextrtc.signalingserver.api.NextRTCEvents.CONVERSATION_CREATED;

@Component
@NextRTCEventListener(CONVERSATION_CREATED)
public class ConversationCreatedHandler extends ConversationHandler {

    private static final Logger log = Logger.getLogger(ConversationCreatedHandler.class);
    @Autowired
    private ConversationRepository repo;

    @Override
    protected void handleEvent(NextRTCConversation rtcConversation, NextRTCEvent event) {
        Conversation conversation = repo.getByConversationName(rtcConversation.getId());
        if (conversation == null) {
            log.info("Created conversation: " + repo.save(new Conversation(rtcConversation.getId())));
        }
    }
}
