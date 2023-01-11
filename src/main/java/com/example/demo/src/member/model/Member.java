package com.example.demo.src.member.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    private int member_id;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String profile_img_url;
    private String password;
    private String phone_num;
}
