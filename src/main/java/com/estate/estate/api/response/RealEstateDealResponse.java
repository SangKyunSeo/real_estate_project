package com.estate.estate.api.response;

import lombok.*;

@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RealEstateDealResponse {
    private String resultCode; // 결과 코드
    private int numOfRows; // 한 페이지 결과 수
    private int pageNo; //페이지 번호
    private int totalCount; // 전체 결과 수
    private int dealAmount; // 거래 금액
    private String buildYear; // 건축 년도
    private String dealYear; // 계약 년도
    private String dealMonth; // 계약 월
    private String dealDay; // 계약 일
    private String roadName; // 도로명
    private String roadNameCode; // 도로명 코드
    private String dong; // 법정동
    private String apartmentName; // 아파트명
    private String areaForExclusiveUse; // 전용면적(m제곱)
    private String jibun; // 지번
    private String regionalCode; // 지역코드
    private int floor; // 층
    private String ReqGbn; // 거래 유형
    private String apartmentDong; // 아파트 동명



}
