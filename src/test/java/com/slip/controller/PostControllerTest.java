/* package com.slip.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.slip.Entitiy.Post;
import com.slip.repository.PostRepository;
import com.slip.vo.PostCreate;
import com.slip.vo.PostEdit;
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
                .andExpect(jsonPath("$.[0].id").value(30))
                .andExpect(jsonPath("$.[0].title").value("빈코 제목 = 30"))
                .andExpect(jsonPath("$.[0].content").value("빈코 내용 = 30"))
                .andDo(print());
    }

    @Test
    @DisplayName("글 제목 수정")
    void 글수정() throws Exception{
        //give
        Post post = Post.builder()
                .title("빈코 제목")
                .content("빈코 내용")
                .build();
        // DB에 들어갈 기존 게시글 하나 생성 이전과 마찬가지로 Build패턴을 이용하여 save 메서드로 저장


        postRepository.save(post);

        PostEdit postEdit = PostEdit.builder()
                .title("빈코 제목 수정")
                .content("빈코 내용 수정")
                .build();

        //expected

        mockMvc.perform(MockMvcRequestBuilders.patch("/posts/{postId}", post.getId())
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postEdit))
        )
                .andExpect(status().isOk())
                .andDo(print());

        // mock Mvc를 이용하여 url 매핑 후 controller 에 DB에 저장한 기존 게시글의 아이디와 수정할 내용을 담은 postEdit을 넘겨준다
    }

    @Test
    @DisplayName("글 삭제")
    void 글삭제() throws Exception{
        //give
        Post post = Post.builder()
                .title("빈코 제목")
                .content("빈코 내용")
                .build();

        postRepository.save(post);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.delete("/posts/{postId}", post.getId())
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("존재하지 않는 글 삭제")
    void 글삭제예외처리() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/posts/{postsId}", 1L)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

}
*/