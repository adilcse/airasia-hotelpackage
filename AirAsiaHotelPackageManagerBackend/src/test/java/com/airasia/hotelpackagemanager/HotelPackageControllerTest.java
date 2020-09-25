package com.airasia.hotelpackagemanager;

import com.airasia.hotelpackagemanager.model.HotelPackage;
import com.airasia.hotelpackagemanager.util.DateFormatUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.sql.Timestamp;

/**
 * Test class for Hotel package controller
 * @author nitish
 */
@SpringBootTest(classes = HotelPackageManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HotelPackageControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private String getRootUrl() {
        return "http://localhost:8080/airasia/api/v1/hotelpackages";
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testCreateHotelPackage() throws Exception{
        HotelPackage hotelPackage= new HotelPackage();
        hotelPackage.setDays(2);
        hotelPackage.setNights(1);
        hotelPackage.setHotelName("Test Hotel");
        hotelPackage.setDescription("Mega Test Sales");
        hotelPackage.setExpireyDate(new Timestamp(DateFormatUtil.parseDateYYYYMMDD("20200820").getTime()));
        hotelPackage.setPrice(100.00);

        ResponseEntity<HotelPackage> postResponse = restTemplate.postForEntity(getRootUrl(), hotelPackage, HotelPackage.class);
        Assert.notNull(postResponse);
        Assert.notNull(postResponse.getBody());
    }

    @Test
    public void testGetHotelPackageId() {
        HotelPackage hotelPackage = restTemplate.getForObject(getRootUrl() + "/1", HotelPackage.class);
        Assert.notNull(hotelPackage);
    }
}
