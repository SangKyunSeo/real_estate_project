package com.estate.estate.api.response;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RealEstateDeal {

    @SerializedName("거래금액")
    private String dealAmount; // 거래 금액
    @SerializedName("건축년도")
    private String buildYear; // 건축 년도
    @SerializedName("년")
    private String dealYear; // 계약 년도
    @SerializedName("월")
    private String dealMonth; // 계약 월
    @SerializedName("일")
    private String dealDay; // 계약 일
    @SerializedName("도로명")
    private String roadName; // 도로명
    @SerializedName("도로명코드")
    private String roadNameCode; // 도로명 코드
    @SerializedName("법정동")
    private String dong; // 법정동
    @SerializedName("아파트")
    private String apartmentName; // 아파트명
    @SerializedName("전용면적")
    private String areaForExclusiveUse; // 전용면적(m제곱)
    @SerializedName("지번")
    private String jibun; // 지번
    @SerializedName("지역코드")
    private String regionalCode; // 지역코드
    @SerializedName("층")
    private int floor; // 층
    @SerializedName("거래유형")
    private String ReqGbn; // 거래 유형
    @SerializedName("동")
    private String apartmentDong; // 아파트 동명
}
