package com.estate.estate.api.service;

import com.estate.estate.api.request.APTLttotPblancDetailRequest;
import com.estate.estate.api.response.APTLttotPblancDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HSInfoApiService {

    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @Value("${openApi.HSICallBackUrl}")
    private String callBackUrl;

    // APT 분양정보 상세조회 요청
    public List<APTLttotPblancDetailResponse> getAPTLttotPblancDetail(APTLttotPblancDetailRequest aptLttotPblancDetailRequest){

        return null;
    }



}
