package com.airasia.hotelpackagemanager.service;

import com.airasia.hotelpackagemanager.model.HotelPackage;
import com.airasia.hotelpackagemanager.repository.HotelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for hotel package
 * @author nitish
 */
@Service
public class HotelPackageServiceImpl implements HotelPackageService{

    @Autowired
    private HotelPackageRepository hotelPackageRepository;

    /**
     * Get all hotel packages
     * @return list of hotel packages
     */
    @Override
    public List<HotelPackage> getAllHotelPackages() {
        return hotelPackageRepository.findAll();
    }

    /**
     * Get package by id
     * @param hotelPackageId
     * @return specific package
     */
    @Override
    public Optional<HotelPackage> getHotelPackageById(Long hotelPackageId) {
        return hotelPackageRepository.findById(hotelPackageId);
    }

    /**
     * Create hotel package
     * @param hotelPackage
     * @return newly created hotel package
     */
    @Override
    public HotelPackage createHotelPackage(HotelPackage hotelPackage) {
        return hotelPackageRepository.save(hotelPackage);
    }

    /**
     * Update existing hotel package
     * @param hotelPackage
     * @return update hotel package
     */
    @Override
    public HotelPackage updateHotelPackage(HotelPackage hotelPackage) {
        return hotelPackageRepository.save(hotelPackage);
    }

    /**
     * Delete hotel package
     * @param hotelPackage
     */
    @Override
    public void deleteHotelPackage(HotelPackage hotelPackage) {
        hotelPackageRepository.delete(hotelPackage);
    }
}
