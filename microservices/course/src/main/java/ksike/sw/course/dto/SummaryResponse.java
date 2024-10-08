package ksike.sw.course.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SummaryResponse {
    private String name;
    private String teacher;
    private List<StudentDTO> students;
}
