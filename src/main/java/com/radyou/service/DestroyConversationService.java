package com.radyou.service;

import com.radyou.repo.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DestroyConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    public void execute(String roomName) {
        conversationRepository.getByConversationName(roomName).destroy();
    }
}
