package com.university.MySlice.repository;

import com.university.MySlice.models.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {

    @Query("{ 'suid' : ?0, 'course.courseID' : ?1 }")
    public List<Enrollment> findBySUIDCourseID(Long SUID, Long CourseID);

    @Query("{ 'suid' : ?0}")
    List<Enrollment> findBySUID(Long studentId);

    @Query("{ '_id' : ?0}")
    Enrollment findByEnrollmentId(Long enrollmentId);
}
