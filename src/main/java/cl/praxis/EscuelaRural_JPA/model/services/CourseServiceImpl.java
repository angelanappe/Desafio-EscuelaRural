package cl.praxis.EscuelaRural_JPA.model.services;

import cl.praxis.EscuelaRural_JPA.model.entities.Course;
import cl.praxis.EscuelaRural_JPA.model.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findOne(int id) {
        return repository.findById(id).orElse(null);
    }

}
