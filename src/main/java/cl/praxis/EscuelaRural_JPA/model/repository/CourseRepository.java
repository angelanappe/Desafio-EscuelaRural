package cl.praxis.EscuelaRural_JPA.model.repository;

import cl.praxis.EscuelaRural_JPA.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
