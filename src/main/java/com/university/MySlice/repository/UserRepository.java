package com.university.MySlice.repository;
import com.university.MySlice.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ '_id' : ?0 }")
    User findByID(long id);

    @Query("{'name': {'$regex': ?0 } }")
    List<User> findByName(String name);

    @Query("{'name' : ?0}")
    User getByName(String name);
}
