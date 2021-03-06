package com.victor.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }

    @Test
    public void addPost() {
        //given
        //테스트 기반 환경을 구축하는 단
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("victor@within.co.kr")
                .build());
        //when
        //테스트 하고자 하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();

        //then
        //테스트 결과 검증
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }
}
