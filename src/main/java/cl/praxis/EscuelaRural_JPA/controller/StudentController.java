package cl.praxis.EscuelaRural_JPA.controller;

import cl.praxis.EscuelaRural_JPA.model.entities.Course;
import cl.praxis.EscuelaRural_JPA.model.entities.Student;
import cl.praxis.EscuelaRural_JPA.model.services.CourseService;
import cl.praxis.EscuelaRural_JPA.model.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseService.findAll());
        return "newStudent";
    }

    @PostMapping("/new")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String showEditStudentForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.findOne(id);
        if (student != null) {
            model.addAttribute("student", student);
            model.addAttribute("courses", courseService.findAll());
            return "editStudent";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
