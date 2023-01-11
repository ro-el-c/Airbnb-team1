package com.example.demo.src.accommodation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetAccomRes {
    private int accom_id;
    private String accom_name;
    private String accom_address;
    private int price;
    private List<GetAccomImgUrlRes> accomImgs;
}
