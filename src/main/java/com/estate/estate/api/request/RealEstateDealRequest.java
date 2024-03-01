package com.estate.estate.api.request;

import lombok.*;

@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RealEstateDealRequest {
    private String serviceKey;
    private int pageNo;
    private int numOfRows;
    private String lawdCd;
    private String dealYmd;
}
