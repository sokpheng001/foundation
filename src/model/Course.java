package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer courseId;
    private String courseTitle;
    private String courseStartedDate;
    private String courseEndedDate;
    private Boolean isAvailable;
}
