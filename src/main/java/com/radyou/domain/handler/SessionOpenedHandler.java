package com.radyou.domain.handler;

import com.radyou.domain.handler.common.FromMemberHandler;
import com.radyou.service.SessionOpenedService;
import org.nextrtc.signalingserver.api.annotation.NextRTCEventListener;
import org.nextrtc.signalingserver.api.dto.NextRTCEvent;
import org.nextrtc.signalingserver.api.dto.NextRTCMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.nextrtc.signalingserver.api.NextRTCEvents.SESSION_OPENED;

@Service
@NextRTCEventListener(SESSION_OPENED)
public class SessionOpenedHandler extends FromMemberHandler {

    @Autowired
    private SessionOpenedService service;

    @Override
    protected void handleEvent(NextRTCMember from, NextRTCEvent event) {
        service.execute(from);
    }
}
