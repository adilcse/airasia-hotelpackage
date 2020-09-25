package com.airasia.hotelpackagemanager.service;

import com.airasia.hotelpackagemanager.model.HotelPackage;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for hotel packages
 * @author nitish
 */
public interface HotelPackageService {

    List<HotelPackage> getAllHotelPackages();

    Optional<HotelPackage> getHotelPackageById(Long hotelPackageId);

    HotelPackage createHotelPackage(HotelPackage hotelPackage);

    HotelPackage updateHotelPackage(HotelPackage hotelPackage);

    void deleteHotelPackage(HotelPackage hotelPackage);
}
