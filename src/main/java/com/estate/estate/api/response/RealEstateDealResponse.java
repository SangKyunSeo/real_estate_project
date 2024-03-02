package com.estate.estate.api.response;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class RealEstateDealResponse {

    private String resultCode; // 결과 코드
    private int numOfRows; // 한 페이지 결과 수
    private int pageNo; //페이지 번호
    private int totalCount; // 전체 결과 수

    private List<RealEstateDeal> realEstateDeals; // Api 응답 데이터 배열

    public static RealEstateDealResponse toDto(String resultCode, int numOfRows, int pageNo, int totalCount, List<RealEstateDeal> list){
        return RealEstateDealResponse.builder()
                .resultCode(resultCode)
                .numOfRows(numOfRows)
                .pageNo(pageNo)
                .totalCount(totalCount)
                .realEstateDeals(list)
                .build();
    }
}
