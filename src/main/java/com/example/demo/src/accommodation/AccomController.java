package com.example.demo.src.accommodation;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.accommodation.model.GetAccomDetailRes;
import com.example.demo.src.accommodation.model.GetAccomRes;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accom") // controller 에 있는 모든 api 의 uri 앞에 기본적으로 들어감
public class AccomController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final AccomProvider accomProvider;
    @Autowired
    private final AccomService accomService;
    @Autowired
    private final JwtService jwtService;


    public AccomController(AccomProvider accomProvider, AccomService accomService, JwtService jwtService){
        this.accomProvider = accomProvider;
        this.accomService = accomService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @GetMapping("/all")
    public BaseResponse<List<GetAccomRes>> getAccoms() {
        List<GetAccomRes> getAccomResList = accomProvider.getAccoms();
        return new BaseResponse<>(getAccomResList);
    }

    @ResponseBody
    @GetMapping("/detail/{accom_id}")
    public BaseResponse<GetAccomDetailRes> getAccomDetails(@PathVariable int accom_id){
        GetAccomDetailRes getAccomDetailRes = accomService.getAccomDetails(accom_id);
        return new BaseResponse<>(getAccomDetailRes);
    }
}
