package com.university.MySlice.repository;

import com.university.MySlice.models.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends MongoRepository<Program, String> {
    @Query("{'name' : ?0}")
    Program findByName(String programName);

    @Query("{ '_id' : ?0 }")
    Program findById(Long programID);

    @Query("{'advisor' : ?0 }")
    Program findByAdvisorName(String advisor);


}
