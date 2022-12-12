package com.slip.vo;

import com.slip.Entitiy.User;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostCreate {

    String title;
    String content;
    User userIdx;
    String category;
    String writer;
    Long notice;
}
