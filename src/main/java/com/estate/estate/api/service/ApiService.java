package com.estate.estate.api.service;

import com.estate.estate.api.request.RealEstateDealRequest;
import com.estate.estate.api.response.RealEstateDeal;
import com.estate.estate.api.response.RealEstateDealResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ApiService {

    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @Value("${openApi.callBackUrl}")
    private String callBackUrl;

    // Api 부동산 실 거래가 조회 서비스
    public void getEstateDealList(RealEstateDealRequest request){
        HttpURLConnection urlConnection = null;
        InputStream stream = null;
        String streamStr = null;
        String result = null;

        String urlStr = generateUrl(request);

        try{
            URL url = new URL(urlStr);
            log.info("[URL] : " + url);

            urlConnection = (HttpURLConnection)url.openConnection();
            stream = getNetworkConnection(urlConnection);
            streamStr = readStreamToString(stream);

            log.info("[XML 데이터] : " + streamStr);
            JSONObject jsonObject = XML.toJSONObject(streamStr.toString());
            log.info("[JSONObject 데이터 ] : " + jsonObject);

            RealEstateDealResponse response = getRealEstateDealResponse(jsonObject);
            log.info("[JSON객체 -> Api 응답 객체] : " + response);

            if(stream != null) stream.close();
        }catch(IOException e){
            log.error("[URL ERROR] : " + e.getMessage());
        }finally{
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
    }
    // Api 부동산 실거래 url 생성
    public String generateUrl(RealEstateDealRequest request){
        return callBackUrl
                + "?serviceKey=" + serviceKey
//                + "&pageNo=" + request.getPageNo()
//                + "&numOfRows=" + request.getNumOfRows()
                + "&LAWD_CD=" + request.getLawdCd()
                + "&DEAL_YMD=" + request.getDealYmd();
    }

    // Api 통신
    private InputStream getNetworkConnection(HttpURLConnection urlConnection) throws IOException {
        urlConnection.setConnectTimeout(3000);
        urlConnection.setReadTimeout(3000);
        urlConnection.setRequestMethod("GET");
        urlConnection.setDoInput(true);

        if(urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code : " + urlConnection.getResponseCode());
        }

        return urlConnection.getInputStream();
    }

    // Api 응답 데이터 문자열 변환
    private String readStreamToString(InputStream stream) throws IOException{
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        String readLine;
        while((readLine = br.readLine()) != null) {
            result.append(readLine + "\n\r");
        }

        br.close();

        return result.toString();
    }

    // JSON 데이터 추출 (resultCode)
    private String getResultCode(JSONObject jsonObject){
        return jsonObject.getJSONObject("response").getJSONObject("header").getString("resultCode");
    }
    // JSON 데이터 추출 (num of rows)
    private int getNumOfRows(JSONObject jsonObject){
        return jsonObject.getJSONObject("response").getJSONObject("body").getInt("numOfRows");
    }

    // JSON 데이터 추출 (page no)
    private int getPageNo(JSONObject jsonObject){
        return jsonObject.getJSONObject("response").getJSONObject("body").getInt("pageNo");
    }

    // JSON 데이터 추출 (total count)
    private int getTotalCount(JSONObject jsonObject){
        return jsonObject.getJSONObject("response").getJSONObject("body").getInt("totalCount");
    }
    // JSON 데이터 추출 (items)
    private JSONArray getItems(JSONObject jsonObject){
        return jsonObject
                .getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");
    }
    // JSON 데이터 Response Object 변환
    private RealEstateDealResponse getRealEstateDealResponse(JSONObject jsonObject){
        String resultCode = getResultCode(jsonObject);
        int numOfRows = getNumOfRows(jsonObject);
        int pageNo = getPageNo(jsonObject);
        int totalCount = getTotalCount(jsonObject);
        List<RealEstateDeal> realEstateDeals = new ArrayList<>();
        JSONArray items = getItems(jsonObject);

        for(int i = 0; i < items.length(); i++){
            Gson gson = new Gson();
            realEstateDeals.add(gson.fromJson(items.getJSONObject(i).toString(), RealEstateDeal.class));
        }

        return RealEstateDealResponse.toDto(resultCode, numOfRows, pageNo, totalCount, realEstateDeals);
    }


}
