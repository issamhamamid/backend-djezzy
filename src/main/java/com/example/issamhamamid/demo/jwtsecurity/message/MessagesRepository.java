package com.example.issamhamamid.demo.jwtsecurity.message;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Integer> {
}
