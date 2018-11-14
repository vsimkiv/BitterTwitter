package com.edu.springboot.bittertwitter.repository;

import com.edu.springboot.bittertwitter.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
