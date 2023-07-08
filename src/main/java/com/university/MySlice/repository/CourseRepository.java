package com.university.MySlice.repository;

import com.university.MySlice.models.Course;
import com.university.MySlice.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

    @Query("{ '_id' : ?0 }")
    Course findByID(Long courseID);

}
