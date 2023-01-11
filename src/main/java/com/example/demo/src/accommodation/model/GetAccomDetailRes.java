package com.example.demo.src.accommodation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetAccomDetailRes {
    private int accom_id;
    private String accom_name;
    private String accom_address;
    private int price;
    private String host;
    private int user_num_max;
    private int room_num;
    private List<GetRoomDetailRes> roomDetails;
    private List<GetFacilityRes> facilities;

}
