package com.victor.webservice.web;

import com.victor.webservice.domain.posts.PostsRepository;
import com.victor.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;


    @GetMapping("/hello")
    public String hello()
    {
        return "Hello world";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto)
    {
        postsRepository.save(dto.toEntity());
    }
    /*
    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto)
    {
        return postsService.save(dto);
    }
    */
}
