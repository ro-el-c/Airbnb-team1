package com.example.demo.src.accommodation;


import com.example.demo.src.accommodation.model.*;
import com.example.demo.src.member.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AccomDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetAccomRes> selectAccoms() {
        String selectAccomsQuery = "select accom_id,\n" +
                "       accom_name,\n" +
                "       accom_address,\n" +
                "       price\n" +
                "from Accommodation\n" +
                "where status = 'active';";

        String selectAccomImgsQuery = "select accomImg_id,\n" +
                "       accomImg_url\n" +
                "from AccomImg\n" +
                "where status = 'active' and\n" +
                "      accom_id = ?;";

        return this.jdbcTemplate.query(selectAccomsQuery,
                (rs, rowNum) -> new GetAccomRes(
                        rs.getInt("accom_id"),
                        rs.getString("accom_name"),
                        rs.getString("accom_address"),
                        rs.getInt("price"),
                        jdbcTemplate.query(selectAccomImgsQuery,
                                (rk, rowNum_k) -> new GetAccomImgUrlRes(
                                        rk.getInt("accomImg_id"),
                                        rk.getString("accomImg_url")
                                ), rs.getInt("accom_id"))
                ));
    }

    public GetAccomDetailRes selectAccomDetails(int accom_id){
        int getAccomDetailParams = accom_id;

        String getAccomDetailQuery = "select ac.accom_id as accom_id, ac.accom_name as accom_name,\n" +
                "       ac.accom_address as accom_address, ac.price as price,\n" +
                "       ac.host as host, ac.user_num_max as user_num_max,\n" +
                "       count(r.room_id) as room_num\n" +
                "from Accommodation as ac, Room as r\n" +
                "where ac.accom_id = r.accom_id\n" +
                "  and ac.status = 'active' and r.status = 'active'" +
                "  and ac.accom_id=?;";

        String getRoomDetailQuery = "select r.room_id as room_id, r.room_name as room_name, r.room_detail as room_detail\n" +
                "from Accommodation as ac, Room as r\n" +
                "where ac.accom_id = r.accom_id\n" +
                "  and ac.status = 'active' and r.status = 'active'" +
                "  and ac.accom_id=?;";

        String getFacilityQuery = "select f.facility_id as facility_id, f.facility_name as facility_name, f.facility_icon_url as facility_icon_url\n" +
                "from Accommodation as ac, Facility as f\n" +
                "where ac.accom_id = f.accom_id\n" +
                "  and ac.status = 'active' and f.status = 'active'\n" +
                "  and ac.accom_id=?;";

        return this.jdbcTemplate.queryForObject(getAccomDetailQuery,
                (rs, rowNum) -> new GetAccomDetailRes(
                        rs.getInt("accom_id"),
                        rs.getString("accom_name"),
                        rs.getString("accom_address"),
                        rs.getInt("price"),
                        rs.getString("host"),
                        rs.getInt("user_num_max"),
                        rs.getInt("room_num"),
                        jdbcTemplate.query(getRoomDetailQuery,
                                (rk, rowNum_k) -> new GetRoomDetailRes(
                                        rk.getInt("room_id"),
                                        rk.getString("room_name"),
                                        rk.getString("room_detail")
                                ), getAccomDetailParams),
                        jdbcTemplate.query(getFacilityQuery,
                                (rk, rowNum_k) -> new GetFacilityRes(
                                        rk.getInt("facility_id"),
                                        rk.getString("facility_name"),
                                        rk.getString("facility_icon_url")
                                ), getAccomDetailParams)
                ), getAccomDetailParams);
    }
}



