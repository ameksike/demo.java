package ksike.sw.course.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ksike.sw.course.dto.StudentDTO;

@FeignClient(name = "msvc-student", url = "localhost:9091/api/student")
public interface IStudentClient {

    @GetMapping("/couse/{id}")
    List<StudentDTO> findAllByCourse(@PathVariable Long id);

}
