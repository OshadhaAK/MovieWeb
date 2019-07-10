package com.movie.server.repositories;

import com.movie.server.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Movie findBy_id(ObjectId _id);
}
