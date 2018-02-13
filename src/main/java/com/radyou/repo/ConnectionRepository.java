package com.radyou.repo;

import com.radyou.domain.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ConnectionRepository extends JpaRepository<Connection, Integer> {

}
