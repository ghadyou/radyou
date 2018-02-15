package com.radyou.repo;

import com.radyou.domain.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {

    @Query("select c from Conversation c where c.destroyed is null and c.conversationName = :conversationName")
    Conversation getByConversationName(@Param("conversationName") String conversationName);
}
