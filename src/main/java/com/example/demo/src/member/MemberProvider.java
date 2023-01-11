package com.example.demo.src.member;


import com.example.demo.config.BaseException;
import com.example.demo.src.member.model.*;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Service
public class MemberProvider {

    private final MemerDao memerDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MemberProvider(MemerDao memerDao, JwtService jwtService) {
        this.memerDao = memerDao;
        this.jwtService = jwtService;
    }

    public GetMemberRes getMemberById(int member_id) throws BaseException{
        try{
            GetMemberRes getMemberRes = memerDao.getMemberById(member_id);
            return getMemberRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

//    public GetMemberFeedRes retrieveUserFeed(int userIdxByJwt, int userIdx) throws BaseException{
//        // userIdxByJwt : 로그인 된 계정 index, userIdx : 볼 피드의 계정 index(path variable로 받은 계정)
//
//        Boolean isMyFeed = true;
//
//        // validation 처리
//        if(checkUserExist(userIdx)==0){
//            throw new BaseException(USERS_EMPTY_USER_ID);
//        }
//
//        try{
//            if(userIdxByJwt != userIdx)
//                isMyFeed = false;
//
//            GetMemberInfoRes getUserInfo = memerDao.selectUserInfo(userIdx);
//            List<GetMemberPostsRes> getUserPosts = memerDao.selectUserPosts(userIdx);
//            GetMemberFeedRes getUsersRes = new GetMemberFeedRes(isMyFeed, getUserInfo, getUserPosts);
//            return getUsersRes;
//        }
//        catch (Exception exception) {
//            exception.printStackTrace();
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }

//    public int checkMemberExist(int memberIdx) throws BaseException{
//        try{
//            return memerDao.checkMemberExist(memberIdx);
//        } catch (Exception exception){
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }

//    // email로 유저 조회 함수
//    public GetMemberRes getUsersByEmail(String email) throws BaseException{
//        try{
//            GetMemberRes getUsersRes = memerDao.getUsersByEmail(email);
//            return getUsersRes;
//        }
//        catch (Exception exception) {
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }


//    public int checkEmail(String email) throws BaseException{
//        try{
//            return memerDao.checkEmail(email);
//        } catch (Exception exception){
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }
//
//    public DeleteMemberRes deleteUserByIdx(DeleteMemberReq deleteMemberReq) throws BaseException {
//        try {
//            DeleteMemberRes deleteMemberRes = memerDao.deleteMemberByIdx(deleteMemberReq);
//            return deleteMemberRes;
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            throw new BaseException(DELETE_USER_FAIL);
//        }
//    }

}
