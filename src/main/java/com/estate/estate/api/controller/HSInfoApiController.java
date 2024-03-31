package com.estate.estate.api.controller;

import com.estate.estate.api.request.APTLttotPblancDetailRequest;
import com.estate.estate.api.response.APTLttotPblancDetailResponse;
import com.estate.estate.api.service.HSInfoApiService;
import com.estate.estate.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/openApi")
public class HSInfoApiController {

    @Autowired
    private HSInfoApiService hsInfoApiService;

    @GetMapping("/getHsAptInfo")
    public ApiResponse<List<APTLttotPblancDetailResponse>> getHsAptInfo(@RequestBody APTLttotPblancDetailRequest request){
        return ApiResponse.success(hsInfoApiService.getAPTLttotPblancDetail(request));
    }
}
