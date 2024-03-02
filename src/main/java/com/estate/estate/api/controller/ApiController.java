package com.estate.estate.api.controller;

import com.estate.estate.api.request.RealEstateDealRequest;
import com.estate.estate.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openApi")
public class ApiController {

    @Autowired
    ApiService apiService;

    // Api 부동산 실 거래가 요청 컨트롤
    @GetMapping("/getAll")
    public void getRealEstateDealList(@RequestBody RealEstateDealRequest request){
        apiService.getEstateDealList(request);
    }
}
