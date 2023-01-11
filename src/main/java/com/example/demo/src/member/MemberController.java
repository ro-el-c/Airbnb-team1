package com.example.demo.src.member;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.member.model.*;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.config.BaseResponseStatus.POST_USERS_EMPTY_EMAIL;
import static com.example.demo.config.BaseResponseStatus.POST_USERS_INVALID_EMAIL;
import static com.example.demo.utils.ValidationRegex.isRegexEmail;

@RestController
@RequestMapping("/members") // controller 에 있는 모든 api 의 uri 앞에 기본적으로 들어감
public class MemberController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final MemberProvider memberProvider;
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final JwtService jwtService;


    public MemberController(MemberProvider memberProvider, MemberService memberService, JwtService jwtService){
        this.memberProvider = memberProvider;
        this.memberService = memberService;
        this.jwtService = jwtService;
    }


    @ResponseBody
    @GetMapping("/{member_id}") // (GET) 127.0.0.1:9000/members/:member_id
    public BaseResponse<GetMemberFeedRes> getMemberByMemberId(@PathVariable("member_id")int member_id) {
        try{
            GetMemberRes getMemberRes = memberProvider.getMemberById(member_id);
            return new BaseResponse(getMemberRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 회원 조회 API
     * [GET] /members
     * 이메일 검색 조회 API
     * [GET] /members? Email=
     * @return BaseResponse<GetMembersRes>
     */


//     /*
//     * 내 피드인지, 다른 사람의 피드인지
//     * 비교
//     * -> 현재 로그인 계정 vs 조회 피드의 계정
//     * */
//    @ResponseBody
//    @GetMapping("/{memberIdx}")
//    public BaseResponse<GetMemberFeedRes> getUsersFeed(@PathVariable("member_id")int member_id) {
//        try{
//            GetMemberFeedRes getUsersFeedRes = memberProvider.retrieveUserFeed(member_id, member_id);
//            return new BaseResponse<>(getMembersFeedRes);
//        } catch(BaseException exception){
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }


//    /*
//     * email 검색 조회 API
//     */
//    @ResponseBody
//    @GetMapping("") // GetMapping == get method // (GET) 127.0.0.1:9000/users  // 아무런 uri 명시된 게 없으므로, 좌측 주석이 api의 uri가 됨
//    // email 검색 조회 api
//    // 클라이언트에게 email 받아서, 해당 email 가진 유저 출력
//    // email은 query string으로 받을 것 -> 바로 아래 @RequestParam 가 명시
//    public BaseResponse<GetUserFeedRes> getUsers(@RequestParam(required = true) String Email) {
//        // 반환하는 값 == GetUserRes // = 모델
//        try{
//            // TODO: email 관련한 짧은 validation 예시입니다. 그 외 더 부가적으로 추가해주세요!
//            if(Email.length()==0){
//                return new BaseResponse<>(POST_USERS_EMPTY_EMAIL);
//            }
//            // 이메일 정규표현
//            if(!isRegexEmail(Email)){
//                return new BaseResponse<>(POST_USERS_INVALID_EMAIL);
//            }
//            GetUserRes getUsersRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse(getUsersRes);
//        } catch(BaseException exception){
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }

//    /*
//     * 유저 삭제 API
//     * [DELETE] /users/:member_id
//     */
//    @ResponseBody
//    @DeleteMapping("/{member_id}") // (DELETE) 127.0.0.1:9000/users/:member_id
//    public BaseResponse<DeleteMemberRes> deleteMemberByMemberId(@PathVariable("member_id")int member_id) {
//        try{
//            // Req -> userIdx로 접근
//            // Res 반환
//            DeleteMemberReq deleteMemberReq = new DeleteMemberReq(member_id);
//            DeleteMemberRes deleteMemberRes = memberProvider.deleteUserByIdx(deleteMemberReq);
//            return new BaseResponse<>(deleteMemberRes);
//        } catch(BaseException exception){
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }


//    /**
//     * 회원가입 API
//     * [POST] /users
//     * @return BaseResponse<PostUserRes>
//     */
//    // Body
//    @ResponseBody
//    @PostMapping("") // (POST) 127.0.0.1:9000/users
//    public BaseResponse<PostMemberRes> createMember(@RequestBody PostMemberReq postMemberReq) {
//        // TODO: email 관련한 짧은 validation 예시입니다. 그 외 더 부가적으로 추가해주세요!
//
//        if(postMemberReq.getEmail() == null){
//            return new BaseResponse<>(POST_USERS_EMPTY_EMAIL);
//        }
//        // 이메일 정규표현
//        if(!isRegexEmail(postMemberReq.getEmail())){
//            return new BaseResponse<>(POST_USERS_INVALID_EMAIL);
//        }
//        try{
//            PostMemberRes postMemberRes = memberService.createUser(postMemberReq);
//            return new BaseResponse<>(postMemberRes);
//        } catch(BaseException exception){
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }


//    /**
//     * 유저정보변경 API
//     * [PATCH] /members/:member_id
//     * @return BaseResponse<String>
//     */
//    @ResponseBody
//    @PatchMapping("/{member_id}") // (PATCH) 127.0.0.1:9000/users/:member_id
//    public BaseResponse<String> modifyMemberName(@PathVariable("member_id") int member_id, @RequestBody Member member){
//        try {
//            /* TODO: jwt는 다음주차에서 배울 내용입니다!
//            jwt에서 idx 추출.
//            int userIdxByJwt = jwtService.getUserIdx();
//            userIdx와 접근한 유저가 같은지 확인
//            if(member_id != userIdxByJwt){
//                return new BaseResponse<>(INVALID_USER_JWT);
//            }
//            */
//
//            PatchMemberReq patchMemberReq = new PatchMemberReq(member_id, member.getNickName());
//            memberService.modifyUserName(patchMemberReq);
//
//            String result = "";
//        return new BaseResponse<>(result);
//        } catch (BaseException exception) {
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }

}
