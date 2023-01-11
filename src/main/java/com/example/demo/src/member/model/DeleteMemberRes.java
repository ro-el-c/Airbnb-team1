package com.example.demo.src.member.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteMemberRes {
    private String name;
    private String nickName;
   // private String phone;
    private String gender;
    private String email;
    private String password;
}
