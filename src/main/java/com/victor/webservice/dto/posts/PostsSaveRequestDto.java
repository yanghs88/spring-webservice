package com.victor.webservice.dto.posts;

import com.victor.webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/**
 * Entity class 를 request/reponse 클래스와 혼용해서 사용하면 안된다.
 */
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity()
    {
        return Posts.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
    }

    @Builder
    public PostsSaveRequestDto(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
