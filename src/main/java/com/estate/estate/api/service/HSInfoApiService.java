package com.estate.estate.api.service;

import com.estate.estate.api.request.APTLttotPblancDetailRequest;
import com.estate.estate.api.response.APTLttotPblancDetailResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
public class HSInfoApiService {

    // 서비스키
    @Value("${openApi.HSIserviceKey}")
    private String serviceKey;

    // url
    @Value("${openApi.HSICallBackUrl}")
    private String callBackUrl;

    @Value("${default.api.pageNo}")
    private int page;

    @Value("${default.api.numOfRows}")
    private int perPage;

    // 주택관리번호 파라미터 이름
    private String houseManageNoPM = "cond[HOUSE_MANAGE_NO::EQ]";

    // 공고번호 파라미터 이름
    private String pblancNoPM = "cond[PBLANC_NO::EQ]";

    // 공급지역명 파라미터 이름
    private String subscrptAreaCodeNmPM = "cond[SUBSRPT_AREA_CODE_NM::EQ]";

    // 모집공고일 파라미터 이름
    private String rcritPblancDePM = "cond[RCRIT_PBLANC_DE::";


    // APT 분양정보 상세조회 요청
    public List<APTLttotPblancDetailResponse> getAPTLttotPblancDetail(APTLttotPblancDetailRequest aptLttotPblancDetailRequest){
        log.debug("[Api APT 분양정보 상세조회 요청 서비스 파라미터] : " + aptLttotPblancDetailRequest);
        HttpURLConnection urlConnection = null;
        InputStream stream = null;
        String streamStr;
        String urlStr = generateUrl(aptLttotPblancDetailRequest);
        List<APTLttotPblancDetailResponse> responseList = new ArrayList<>();

        try{
            URL url = new URL(urlStr);
            log.debug("[URL] : " + urlStr);

            urlConnection = (HttpURLConnection)url.openConnection();
            stream = getNetworkConnection(urlConnection);
            streamStr = readStreamToString(stream);
            log.debug("[Api APT 분양정보 상세조회 요청 통신 JSON String 결과] : Stream String = " + streamStr);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(streamStr);
            log.debug("[JSON Object] : jsonObject = " + jsonObject);

            Long currentCount = (Long) jsonObject.get("currentCount");
            Long totalCount = (Long) jsonObject.get("totalCount");
            Long page = (Long) jsonObject.get("page");
            Long perPage = (Long) jsonObject.get("perPage");
            log.debug("[JSON Object currentCount] : " + currentCount);
            log.debug("[JSON Object totalCount] : " + totalCount);
            log.debug("[JSON Object page] : " + page);
            log.debug("[JSON Object perPage] : " + perPage);

            JSONArray jsonArray = (JSONArray) jsonObject.get("data");
            log.debug("[JSON Array] : " + jsonArray);


            for(Object item : jsonArray){
                Gson gson = new Gson();
                APTLttotPblancDetailResponse response = gson.fromJson(item.toString(), APTLttotPblancDetailResponse.class);
                responseList.add(response);
            }

        }catch(IOException e){
            log.error("[URL Error] : " + e.getMessage());
        }catch(ParseException e){
            log.error("[JSon Parsing Error] : " + e.getMessage());
        }finally{
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }

        return responseList;

    }

    // Api 청약홈 분양정보 url 생성
    public String generateUrl(APTLttotPblancDetailRequest request){
        String url = callBackUrl
                + "/getAPTLttotPblancDetail"
                + "?page=" + (request.getPage() == 0 ? page : request.getPage())
                + "&perPage=" + (request.getPerPage() == 0 ? perPage : request.getPerPage())
                + "&serviceKey=" + serviceKey;

        if(request.getHouseManageNo() != null){
            url += "&" + houseManageNoPM + "=" + request.getHouseManageNo();
        }

        if(request.getPblancNo() != null){
            url += "&" + pblancNoPM + "=" + request.getPblancNo();
        }

        if(request.getSubscrptAreaCodeNm() != null){
            url += "&" + subscrptAreaCodeNmPM + "=" + request.getSubscrptAreaCodeNm();
        }

        if(request.getStRcritPblancDe() != null){
            url += "&" + rcritPblancDePM + "GTE]=" + request.getStRcritPblancDe();
        }

        if(request.getEnRcritPblancDe() != null){
            url += "&" + rcritPblancDePM + "LTE]=" + request.getEnRcritPblancDe();
        }

        return url;
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



}
