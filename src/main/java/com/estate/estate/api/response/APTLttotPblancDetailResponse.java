package com.estate.estate.api.response;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@ToString
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class APTLttotPblancDetailResponse {
    @SerializedName("HOUSE_MANAGE_NO")
    private String houseManageNo; // 주택 관리 번호
    @SerializedName("PBLANC_NO")
    private String pblancNo; // 공고 번호
    @SerializedName("HOUSE_NM")
    private String houseNm; // 주택명
    @SerializedName("HOUSE_SECD")
    private String houseSecd; // 주택 구분 코드
    @SerializedName("HOUSE_SECD_NM")
    private String houseSecdNm; // 주택 구분 코드명
    @SerializedName("HOUSE_DTL_SECD")
    private String houseDtlSecd; // 주택 상세 구분 코드
    @SerializedName("HOUSE_DTL_SECD_NM")
    private String houseDtlSecdNm; // 주택 상세 구분 코드명
    @SerializedName("RENT_SECD")
    private String rentSecd; // 분양 구분 코드
    @SerializedName("RENT_SECD_NM")
    private String rentSecdNm; // 분양 구분 코드명
    @SerializedName("SUBSCRPT_AREA_CODE")
    private String subscrptAreaCode; // 공급 지역 코드
    @SerializedName("SUBSCRPT_AREA_CODE_NM")
    private String subscrptAreaCodeNm; // 공급 지역명
    @SerializedName("HSSPLY_ZIP")
    private String hssplyZip; // 공급위치 우편번호
    @SerializedName("HSSPLY_ADRES")
    private String hssplyAdres; // 공급 위치
    @SerializedName("TOT_SUPLY_HSHLDCO")
    private String totSuplyHshldco; // 공급 규모
    @SerializedName("RCRIT_PBLANC_DE")
    private String rcritPblancDe; // 모집 공고일
    @SerializedName("RCEPT_BGNDE")
    private String rceptBgnde; // 청약 접수 시작일
    @SerializedName("RCEPT_ENDDE")
    private String rceptEndde; // 청약 접수 종료일
    @SerializedName("SPSPLY_RCEPT_BGNDE")
    private String spsplyRceptBgnde; // 특별 공급 접수 시작일
    @SerializedName("SPSPLY_RCEPT_ENDDE")
    private String spsplyRceptEndde; // 특별 공급 접수 종료일
    @SerializedName("GNRL_RNK1_CRSPAREA_RCPTDE")
    private String gnrlRnk1CrspareaRcptde; // 1순위 해당지역 접수시작일
    @SerializedName("GNRL_RNK1_CRSPAREA_ENDDE")
    private String gnrlRnk1CrspareaEndde; // 1순위 해당지역 접수종료일
    @SerializedName("GNRL_RNK1_ETC_GG_RCPTDE")
    private String gnrlRnk1EtcGgRcptde; // 1순위 경기지역 접수시작일
    @SerializedName("GNRL_RNK1_ETC_GG_ENDDE")
    private String gnrlRnk1EtcGgEndde; // 1순위 경기지역 접수종료일
    @SerializedName("GNRL_RNK1_ETC_AREA_RCPTDE")
    private String gnrlRnk1EtcAreaRcptde; // 1순위 기타지역 접수시작일
    @SerializedName("GNRL_RNK1_ETC_AREA_ENDDE")
    private String gnrlRnk1EtcAreaEndde; // 1순위 기타지역 접수종료일
    @SerializedName("GNRL_RNK2_CRSPAREA_RCPTDE")
    private String gnrlRnk2CrspareaRcptde; // 2순위 해당지역 접수시작일
    @SerializedName("GNRL_RNK2_CRSPAREA_ENDDE")
    private String gnrlRnk2CrspareaEndde; // 2순위 해당지역 접수종료일
    @SerializedName("GNRL_RNK2_ETC_GG_RCPTDE")
    private String gnrlRnk2EtcGgRcptde; // 2순위 경기지역 접수시작일
    @SerializedName("GNRL_RNK2_ETC_GG_ENDDE")
    private String gnrlRnk2EtcGgEndde; // 2순위 경기지역 접수종료일
    @SerializedName("GNRL_RNK2_ETC_AREA_RCPTDE")
    private String gnrlRnk2EtcAreaRcptde; // 2순위 기타지역 접수시작일
    @SerializedName("GNRL_RNK2_ETC_AREA_ENDDE")
    private String gnrlRnk2EtcAreaEndde; // 2순위 기타지역 접수종료일
    @SerializedName("PRZWNER_PRESNATN_DE")
    private String przwnerPresnatnDe; // 당첨자발표일
    @SerializedName("CNTRCT_CNCLS_BGNDE")
    private String cntrctCnclsBgnde; // 계약시작일
    @SerializedName("CNTRCT_CNCLS_ENDDE")
    private String cntrctCnclsEndde; // 계약종료일
    @SerializedName("HMPG_ADRES")
    private String hmpgAdres; // 홈페이지주소
    @SerializedName("CNSTRCT_ENTRPS_NM")
    private String cnstrctEntrpsNm; // 건설업체명 (시공사)
    private String mdhsTelno; // 문의처
    private String bsnsMbyNm; // 사업주체명 (시행사)
    @SerializedName("MVN_PREARNGE_YM")
    private String mvnPrearngeYm; // 입주예정월
    @SerializedName("SPECLT_RDN_EARTH_AT")
    private String specltRdnEarthAt; // 투기과열지구
    @SerializedName("MDAT_TRGET_AREA_SECD")
    private String mdatTrgetAreaSecd; // 조정대상지역
    @SerializedName("PARCPRC_ULS_AT")
    private String parcprcUlsAt; // 분양가상한제
    @SerializedName("IMPRMN_BSNS_AT")
    private String imprmnBsnsAt; // 정비사업
    @SerializedName("PUBLIC_HOUSE_EARTH_AT")
    private String publicHouseEarthAt; // 공공주택지구
    @SerializedName("LRSCL_BLDLND_AT")
    private String lrsclBldlndAt; // 대규모 택지개발지구
    @SerializedName("NPLN_PRVOPR_PUBLIC_HOUSE_AT")
    private String nplnPrvoprPublicHouseAt; // 수도권 내 민영 공공주택지구
    @SerializedName("PBLANC_URL")
    private String pblancUrl; // 분양정보 URL

}
