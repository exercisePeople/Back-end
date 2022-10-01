package com.slip.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.slip.Entitiy.Post;
import com.slip.repository.PostRepository;
import com.slip.vo.PostCreate;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void clean(){
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("/post요청시 db갑이 저장")
    void insertPost() throws Exception{
        //give
        PostCreate request = PostCreate.builder()
                .title("제목")
                .content("내용")
                .build();

        String json = objectMapper.writeValueAsString(request);

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/posts")
                .contentType(APPLICATION_JSON)
                .content(json)
        )
                .andExpect(status().isOk())
                .andDo(print());

        //then
        assertEquals(1L, postRepository.count());

        Post post = postRepository.findAll().get(0);
        assertEquals("제목",post.getTitle());
        assertEquals("내용",post.getContent());
    }

    @Test
    @DisplayName("글 한개만 조회")
    void 글조회() throws Exception{
        //give
        Post post = Post.builder()
                .title("글 제목 1 입니다")
                .content("글 내용이 적혀 있습니다")
                .build();
        postRepository.save(post);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/{postId}", post.getId())
                .contentType(APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(post.getId()))
                .andExpect(jsonPath("$.title").value("글 제목 1 입니다"))
                .andExpect(jsonPath("$.content").value("글 내용이 적혀 있습니다"))
                .andDo(print());
    }

    @Test
    @DisplayName("글 1페이지 조회")
    void 글페이지조회() throws Exception{
        //give
        List<Post> requestPosts = IntStream.range(1,31)
                .mapToObj(i ->
                        Post.builder()
                                .title("빈코 제목 = " + i)
                                .content("빈코 내용 = " + i)
                                .build()
                )
                .collect(Collectors.toList());

        postRepository.saveAll(requestPosts);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.get("/posts?page=1&sort=id,desc")
                .contentType(APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Matchers.is(5)))
                .andExpect(jsonPath("$[0].id").value(25))
                .andExpect(jsonPath("$.[0].title").value("빈코 제목 = 25"))
                .andExpect(jsonPath("$.[0].content").value("빈코 내용 = 25"))
                .andDo(print());
    }
}
