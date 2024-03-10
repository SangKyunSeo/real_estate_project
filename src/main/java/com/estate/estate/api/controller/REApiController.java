package com.estate.estate.api.controller;

import com.estate.estate.api.request.RealEstateDealRequest;
import com.estate.estate.api.response.RealEstateDealResponse;
import com.estate.estate.api.service.REApiService;
import com.estate.estate.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openApi")
public class REApiController {

    @Autowired
    REApiService REApiService;

    // Api 부동산 실 거래가 요청 컨트롤
    @GetMapping("/getREDeal")
    public ApiResponse<RealEstateDealResponse> getRealEstateDealList(@RequestBody RealEstateDealRequest request){
        return ApiResponse.success(REApiService.getEstateDealList(request));
    }
}
