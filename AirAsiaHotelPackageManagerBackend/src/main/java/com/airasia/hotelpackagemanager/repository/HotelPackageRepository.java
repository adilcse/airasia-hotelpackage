package com.airasia.hotelpackagemanager.repository;

import com.airasia.hotelpackagemanager.model.HotelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for HotelPackage
 * @author nitish
 */
@Repository
public interface HotelPackageRepository extends JpaRepository<HotelPackage, Long> {
}
