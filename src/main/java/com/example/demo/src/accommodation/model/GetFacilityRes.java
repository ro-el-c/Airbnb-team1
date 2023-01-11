package com.example.demo.src.accommodation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetFacilityRes {
    private int facility_id;
    private String facility_name;
    private String facility_icon_url;
}
