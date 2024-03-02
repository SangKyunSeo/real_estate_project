package com.estate.estate;

import com.estate.estate.api.service.ApiService;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EstateApplicationTests {

    @InjectMocks
    ApiService apiService;

    @Test
    void contextLoads() {
    }

//    @Test
//    @DisplayName("Open Api 조회 테스트")
//    void getOpenApiDataTest(){
//
//    }

}
