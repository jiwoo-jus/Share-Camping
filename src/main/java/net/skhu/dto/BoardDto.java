package net.skhu.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.skhu.domain.entity.Board;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String picture;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .picture(picture)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String author, String title, String content, String picture, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.picture = picture;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}