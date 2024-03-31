package com.estate.estate.api.request;

import lombok.*;

// APT 분양정보 상세조회 요청 객체
@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class APTLttotPblancDetailRequest {
    private int page;
    private int perPage;
    private String houseManageNo; // 주택 관리 번호 : 2022000248 : cond[::EQ] = 2022000248
    private String pblancNo; // 공고 번호 : 2022000248 : cond[::EQ] = 2022000248
    private String subscrptAreaCodeNm; // 공급 지역명 : 서울 : cond[::EQ] = 서울
    private String stRcritPblancDe; // 모집 공고일 : 2022-05-21 : cond[RCRIT_PBLANC_DE::LT] -> LT : 작은 , LTE : 작거나 같은 , GT : 큰 , GTE: 크거나 같은
    private String enRcritPblancDe;
}
