package com.example.demo.src.member.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMemberPostsRes {
    // 포스트 객체
    private int postIdx;
    private String postImgUrl;
}
