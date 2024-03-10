package com.estate.estate.api.response;

import lombok.*;

@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class APTLttotPblancDetailResponse {
    private String houseManageNo; // 주택 관리 번호
    private String pblancNo; // 공고 번호
    private String houseNm; // 주택명
    private String houseSecd; // 주택 구분 코드
    private String houseSecdNm; // 주택 구분 코드명
    private String houseDtlSecd; // 주택 상세 구분 코드
    private String houseDtlSecdNm; // 주택 상세 구분 코드명
    private String rendSecd; // 분양 구분 코드
    private String rentSecdNm; // 분양 구분 코드명
    private String subscrptAreaCode; // 공급 지역 코드
    private String subscrptAreaCodeNm; // 공급 지역명
    private String hssplyZip; // 공급위치 우편번호
    private String hssplyAdres; // 공급 위치
    private String totSuplyHshldco; // 공급 규모
    private String rcritPblancDe; // 모집 공고일
    private String rceptBgnde; // 청약 접수 시작일
    private String rceptEndde; // 청약 접수 종료일
    private String spsplyRceptBgnde; // 특별 공급 접수 시작일
    private String spsplyRceptEndde; // 특별 공급 접수 종료일
    private String gnrlRnk1CrspareaRcptde; // 1순위 해당지역 접수시작일
    private String gnrlRnk1CrspareaEndde; // 1순위 해당지역 접수종료일
    private String gnrlRnk1EtcGgRcptde; // 1순위 경기지역 접수시작일
    private String gnrlRnk1EtcGgEndde; // 1순위 경기지역 접수종료일
    private String gnrlRnk1EtcAreaRcptde; // 1순위 기타지역 접수시작일
    private String gnrlRnk1EtcAreaEndde; // 1순위 기타지역 접수종료일
    private String gnrlRnk2CrspareaRcept; // 2순위 해당지역 접수시작일
    private String gnrlRnk2CrspareaEndde; // 2순위 해당지역 접수종료일
    private String gnrlRnk2EtcGg_rcptde; // 2순위 경기지역 접수시작일
    private String gnrlRnk2EtcGgEndde; // 2순위 경기지역 접수종료일
    private String gnrlRnk2EtcAreaRcptde; // 2순위 기타지역 접수시작일
    private String gnrlRnk2EtcAreaEndde; // 2순위 기타지역 접수종료일
    private String przwnerPresnatnDe; // 당첨자발표일
    private String cntrctCnclsBgnde; // 계약시작일
    private String cntrctCnclsEndde; // 계약종료일
    private String hmpgAdres; // 홈페이지주소
    private String cnstrctEntrpsNm; // 건설업체명 (시공사)
    private String mdhsTelno; // 문의처
    private String bsnsMbyNm; // 사업주체명 (시행사)
    private String mvnPrearngeYn; // 입주예정월
    private String specltRdnEarthAt; // 투기과열지구
    private String mdatTrgetAreaSecd; // 조정대상지역
    private String parcprcUlsAt; // 분양가상한제
    private String imprmnBsnsAt; // 정비사업
    private String publicHouseEarthAt; // 공공주택지구
    private String lrsclBldlndAt; // 대규모 택지개발지구
    private String nplnPrvoprPublicHouseAt; // 수도권 내 민영 공공주택지구
    private String pblancUrl; // 분양정보 URL

}
