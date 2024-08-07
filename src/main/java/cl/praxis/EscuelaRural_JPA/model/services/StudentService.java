package cl.praxis.EscuelaRural_JPA.model.services;

import cl.praxis.EscuelaRural_JPA.model.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findOne(int id);
    void save(Student student);
    void delete(int id);
}