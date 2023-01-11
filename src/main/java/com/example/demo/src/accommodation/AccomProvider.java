package com.example.demo.src.accommodation;


import com.example.demo.config.BaseException;
import com.example.demo.src.accommodation.model.GetAccomRes;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Service
public class AccomProvider {

    private final AccomDao accomDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AccomProvider(AccomDao accomDao, JwtService jwtService) {
        this.accomDao = accomDao;
        this.jwtService = jwtService;
    }

    public List<GetAccomRes> getAccoms() {
        return accomDao.selectAccoms();
    }
}
