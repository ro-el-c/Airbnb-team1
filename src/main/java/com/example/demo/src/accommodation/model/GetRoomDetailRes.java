package com.example.demo.src.accommodation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetRoomDetailRes {
    private int room_id;
    private String room_name;
    private String room_detail;
}
