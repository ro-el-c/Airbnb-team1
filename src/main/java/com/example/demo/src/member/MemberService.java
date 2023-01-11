package com.example.demo.src.member;


import com.example.demo.config.BaseException;

import com.example.demo.src.member.model.*;
import com.example.demo.utils.JwtService;
import com.example.demo.utils.SHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

// Service Create, Update, Delete 의 로직 처리
@Service
public class MemberService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MemerDao memerDao;
    private final MemberProvider memberProvider;
    private final JwtService jwtService;

    @Autowired
    public MemberService(MemerDao memerDao, MemberProvider memberProvider, JwtService jwtService) {
        this.memerDao = memerDao;
        this.memberProvider = memberProvider;
        this.jwtService = jwtService;
    }

    //ㅇㅇㅁㄹㅇㄴㄹdd

//    public PostMemberRes createUser(PostMemberReq postMemberReq) throws BaseException {
//        // 이메일 중복 확인 // 의미적 validation 처리
//        if(memberProvider.checkEmail(postMemberReq.getEmail()) == 1){
//            // Dao 아닌 Provider 에서. Why?
//            // 무언가를 check하는 것 = 조회의 의미. 따라서 Provider에서.
//            throw new BaseException(POST_USERS_EXISTS_EMAIL);
//        }
//
//        String pwd;
//        try{
//            //암호화
//            pwd = new SHA256().encrypt(postMemberReq.getPassword());
//            postMemberReq.setPassword(pwd);
//        } catch (Exception ignored) {
//            throw new BaseException(PASSWORD_ENCRYPTION_ERROR);
//        }
//        try{
//            int userIdx = memerDao.createUser(postMemberReq);
//            //jwt 발급.
//            // TODO: jwt는 다음주차에서 배울 내용입니다!
//            String jwt = jwtService.createJwt(userIdx);
//            return new PostMemberRes(jwt,userIdx);
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }
//
//    public void modifyUserName(PatchMemberReq patchMemberReq) throws BaseException {
//        try{
//            int result = memerDao.modifyMemberFirstName(patchMemberReq);
//            if(result == 0){
//                throw new BaseException(MODIFY_FAIL_USERNAME);
//            }
//        } catch(Exception exception){
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }

}
