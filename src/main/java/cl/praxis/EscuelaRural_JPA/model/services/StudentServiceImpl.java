package cl.praxis.EscuelaRural_JPA.model.services;

import cl.praxis.EscuelaRural_JPA.model.entities.Student;
import cl.praxis.EscuelaRural_JPA.model.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
