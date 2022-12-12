package com.slip.Entitiy;

import com.slip.editor.PostEditor;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String title;

    @Lob
    public String content;

    public int hits;

    private String category;

    private String writer;

    private Long notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userIdx;

    @Builder
    public Post(User userIdx,String title, String content, String category,String writer, Long notice){
        this.userIdx = userIdx;
        this.title = title;
        this.content = content;
        this.category = category;
        this.writer = writer;
        this.notice = notice;
    }

    public void update(PostEditor postEditor) {
        title = postEditor.getTitle();
        content = postEditor.getContent();
    }

    public PostEditor.PostEditorBuilder toEditor() {
        return PostEditor.builder()
                .title(title)
                .content(content);
    }
}
