package com.quan.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface CourseRepoService extends CrudRepository<Course, String>{

}
