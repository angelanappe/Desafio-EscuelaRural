package cl.praxis.EscuelaRural_JPA.model.services;

import cl.praxis.EscuelaRural_JPA.model.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findOne(int id);
}
