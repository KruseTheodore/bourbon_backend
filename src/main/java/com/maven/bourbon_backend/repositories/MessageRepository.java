package com.maven.bourbon_backend.repositories;

import com.maven.bourbon_backend.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MongoMessage")
public interface MessageRepository extends MongoRepository<Message, String> {

    @Query(value = "{'userNameTo':'?0'}")
    List<Message> findByuserNameTo(String userNameTo);

    @Query(value = "{'userNameFrom':'?0'}")
    List<Message> findByuserNameFrom(String userNameFrom);


}
