package com.movie.server.repositories;

import com.movie.server.models.Actor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActorRepository extends MongoRepository<Actor, String> {
     Actor findBy_id(ObjectId _id);


}
