package test.modify.controller;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardDto {

    public Long boardNo;
    public String title;
    public String content;

    @QueryProjection
    public BoardDto(Long boardNo, String title, String content) {
        this.boardNo = boardNo;
        this.title = title;
        this.content = content;
    }
}
