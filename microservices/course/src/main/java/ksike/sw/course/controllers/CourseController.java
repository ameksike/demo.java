package ksike.sw.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ksike.sw.course.entities.Course;
import ksike.sw.course.services.ICourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    
    @Autowired
    private ICourseService courseService;

    
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Course entity) {
        this.courseService.save(entity);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.courseService.findById(id));
    }

    @GetMapping("/summary/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(this.courseService.getSummary(id));
    }
    
}
