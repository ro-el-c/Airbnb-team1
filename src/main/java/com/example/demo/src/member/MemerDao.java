package com.example.demo.src.member;


import com.example.demo.src.member.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    public List<GetMemberRes> getMembers(){
//        String getMembersQuery = "select member_id,email,firstName,lastName,gender,profile_img_url,password,phone_num from Member";
//        return this.jdbcTemplate.query(getMembersQuery,
//                (rs,rowNum) -> new GetMemberRes(
//                        rs.getInt("member_id"),
//                        rs.getString("email"),
//                        rs.getString("firstName"),
//                        rs.getString("lastName"),
//                        rs.getString("gender"),
//                        rs.getString("profile_img_url"),
//                        rs.getString("password"),
//                        rs.getString("phone_num")
//                ));
//    }

//    public GetMemberRes getUsersByEmail(String email){
//        String getUsersByEmailQuery = "select userIdx,name,nickName,email from User where email=?";
//        String getUsersByEmailParams = email;
//        return this.jdbcTemplate.queryForObject(getUsersByEmailQuery,
//                (rs, rowNum) -> new GetMemberRes(
//                        rs.getInt("userIdx"),
//                        rs.getString("name"),
//                        rs.getString("nickName"),
//                        rs.getString("email")),
//                getUsersByEmailParams);
//    }


    public GetMemberRes getMemberById(int member_id){
        String getMemberByIdQuery = "select member_id,email,firstName,lastName,gender,profile_img_url,password,phone_num from Member where member_id=?";
        int getMemberByIdParams = member_id;
        return this.jdbcTemplate.queryForObject(getMemberByIdQuery,
                (rs, rowNum) -> new GetMemberRes(
                        rs.getInt("member_id"),
                        rs.getString("email"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("gender"),
                        rs.getString("profile_img_url"),
                        rs.getString("password"),
                        rs.getString("phone_num")),
                getMemberByIdParams);
    }

//    public int createMember(PostMemberReq postMemberReq){
//        String createMemberQuery = "insert into Member (email,firstName,lastName,gender,profile_img_url,password,phone_num) VALUES (?,?,?,?,?,?,?)";
//        Object[] createMemberParams = new Object[]{postMemberReq.getName(), postMemberReq.getNickName(), postMemberReq.getPhone(), postMemberReq.getEmail(), postMemberReq.getPassword()};
//        this.jdbcTemplate.update(createMemberQuery, createMemberParams);
//
//        String lastInserIdQuery = "select last_insert_id()";
//        return this.jdbcTemplate.queryForObject(lastInserIdQuery, int.class);
//    }
//
//    public int checkEmail(String email){
//        String checkEmailQuery = "select exists(select email from Member where email = ?)";
//        String checkEmailParams = email;
//        return this.jdbcTemplate.queryForObject(checkEmailQuery,
//                int.class,
//                checkEmailParams);
//
//    }

//    public int modifyMemberFirstName(PatchMemberReq patchMemberReq){
//        String modifyMemberfirstNameQuery = "update Member set firstName = ? where member_id = ? ";
//        Object[] modifyUserNameParams = new Object[]{patchMemberReq.getNickName(), patchMemberReq.getUserIdx()};
//
//        return this.jdbcTemplate.update(modifyMemberfirstNameQuery,modifyUserNameParams);
//    }



//    // Member 삭제
//    public DeleteMemberRes deleteMemberByIdx(DeleteMemberReq deleteMemberReq) {
//        String getMemberByIdQueryForShow = "select member_id,email,firstName,lastName,gender,profile_img_url,password,phone_num from Member where member_id = ?";
//        int getMemberByIdQueryForShowParams = deleteMemberReq.getMemberId();
//
//        DeleteMemberRes deleteMemberRes = this.jdbcTemplate.queryForObject(getMemberByIdQueryForShow,
//                (rs, rowNum) -> new DeleteMemberRes(
//                        rs.getInt("member_id"),
//                        rs.getString("email"),
//                        rs.getString("firstName"),
//                        rs.getString("lastName"),
//                        rs.getString("gender"),
//                        rs.getString("profile_img_url"),
//                        rs.getString("password"),
//                        rs.getString("phone_num"),
//                getMemberByIdQueryForShowParams);
//
//        String deleteMemberByIdQuery = "delete from Member where member_id = ?";
//        this.jdbcTemplate.update(deleteMemberByIdQuery, deleteMemberReq.getMemberId());
//
//        return deleteMemberRes;
//    }



//    // 유저 피드 조회 중
//    // 유저 정보
//    public GetMemberInfoRes selectUserInfo(int userIdx){
//        String selectUsersInfoQuery = "select u.nickName as nickName,\n" +
//                "       u.name as name,\n" +
//                "       u.profileImgUrl as profileImgUrl,\n" +
//                "       u.website as website,\n" +
//                "       u.introduction as introduction,\n" +
//                "       if(followerCount is null, 0, followerCount) as followerCount,\n" +
//                "       if(followingCount is null, 0, followingCount) as followingCount,\n" +
//                "       p.postCount as postCount\n" +
//                "from User as u\n" +
//                "    left join (select userIdx, count(postIdx) as postCount from Post where status = 'ACTIVE' group by userIdx) p on p.userIdx = u.userIdx\n" +
//                "    left join (select followeeIdx, count(followIdx) as followerCount from Follow where status = 'ACTIVE' group by followeeIdx) fc on fc.followeeIdx = u.userIdx\n" +
//                "    left join (select followerIdx, count(followIdx) as followingCount from Follow where status = 'ACTIVE' group by followerIdx) f on f.followerIdx = u.userIdx\n" +
//                "where u.userIdx = ? and u.status = 'ACTIVE'";
//
//        int selectUserInfoParam = userIdx;
//
//        // List 반환할 때는 그냥 query를 사용하고,
//        // 아닐 때는 queryForObject를 사용한다.
//        return this.jdbcTemplate.queryForObject(selectUsersInfoQuery,
//                (rs, rowNum) -> new GetMemberInfoRes(
//                        rs.getString("nickName"),
//                        rs.getString("name"),
//                        rs.getString("profileImgUrl"),
//                        rs.getString("website"),
//                        rs.getString("introduction"),
//                        rs.getInt("followerCount"),
//                        rs.getInt("followingCount"),
//                        rs.getInt("postCount")
//                ), selectUserInfoParam);
//    }
//
//    // 유저 피드 조회 중
//    // 게시글 리스트
//    public List<GetMemberPostsRes> selectUserPosts(int userIdx){
//        String selectUsersPostsQuery = "select p.postIdx as postIdx,\n" +
//                "       pi.imgUrl as postImgUrl,\n" +
//                "from Post as p\n" +
//                "         join PostImgUrl as pi on pi.postIdx = p.userIdx and pi.status = 'ACTIVE'\n" +
//                "         join User as u on p.userIdx = u.userIdx\n" +
//                "where p.status = 'ACTIVE' and u.userIdx = ?\n" +
//                "group by p.postIdx\n" +
//                "having min(pi.postImgUrlIdx)\n" +
//                "order by p.postIdx";
//
//        int selectUserPostsParam = userIdx;
//
//        return this.jdbcTemplate.query(selectUsersPostsQuery,
//                (rs, rowNum) -> new GetMemberPostsRes(
//                        rs.getInt("postIdx"),
//                        rs.getString("postImgUrl")
//                ), selectUserPostsParam);
//    }
//
//    public int checkUserExist(int userIdx){
//        String checkUserExistQuery = "select exists(select userIdx from User where userIdx = ?)";
//        int checkUserExistParams = userIdx;
//        return this.jdbcTemplate.queryForObject(checkUserExistQuery,
//                int.class,
//                checkUserExistParams);
//    }
}



