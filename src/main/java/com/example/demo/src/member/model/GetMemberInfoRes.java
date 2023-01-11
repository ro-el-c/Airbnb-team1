package com.example.demo.src.member.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMemberInfoRes {
    // 유저 정보 객체
    private String nickName;
    private String name;
    private String profileImgUrl;
    private String website;
    private String introduction;
    private int followerCount;
    private int followingCount;
    private int postCount;
}
