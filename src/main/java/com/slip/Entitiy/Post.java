package com.slip.Entitiy;

import com.slip.editor.PostEditor;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public String postUserId;

    public int hits;

    @Builder
    public Post(String title, String content, String postUserId){
        this.title = title;
        this.content = content;
        this.postUserId = postUserId;
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
