package test.modify.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectDto {

    private String title;
    private String writer;

    public ProjectDto(String title, String writer) {
        this.title = title;
        this.writer = writer;
    }
}
