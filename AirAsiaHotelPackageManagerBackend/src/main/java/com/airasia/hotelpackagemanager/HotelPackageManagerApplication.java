package com.airasia.hotelpackagemanager;

import com.airasia.hotelpackagemanager.model.HotelPackage;
import com.airasia.hotelpackagemanager.repository.HotelPackageRepository;
import com.airasia.hotelpackagemanager.util.DateFormatUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

@SpringBootApplication
public class HotelPackageManagerApplication implements CommandLineRunner {

    @Autowired
    private HotelPackageRepository hotelPackageRepository;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(HotelPackageManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        HotelPackage hotelPackage = new HotelPackage();
        hotelPackage.setDays(2);
        hotelPackage.setNights(1);
        hotelPackage.setHotelName("Test Hotel");
        hotelPackage.setDescription("Mega Test Sales");
        hotelPackage.setExpireyDate(new Timestamp(DateFormatUtil.parseDateYYYYMMDD("20200820").getTime()));
        hotelPackage.setPrice(100.00);
        hotelPackage.setActive(true);
        hotelPackageRepository.save(hotelPackage);
    }
}
