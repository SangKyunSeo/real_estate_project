package com.estate.estate.api.request;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RealEstateDealRequest {
    private int pageNo;
    private int numOfRows;
    private String lawdCd;
    private String dealYmd;
}
