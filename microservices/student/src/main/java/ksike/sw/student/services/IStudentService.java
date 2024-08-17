package ksike.sw.student.services;

import java.util.List;

import ksike.sw.student.entities.Student;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findByIdCoure(Long idCourse);
}
