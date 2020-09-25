package com.airasia.hotelpackagemanager.controller;

import com.airasia.hotelpackagemanager.beans.HotelPackageDTO;
import com.airasia.hotelpackagemanager.exception.ResourceNotFoundException;
import com.airasia.hotelpackagemanager.model.HotelPackage;
import com.airasia.hotelpackagemanager.service.HotelPackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller for Hotel Package
 * @author nitish
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class HotelPackageController {

    @Autowired
    private HotelPackageService hotelPackageService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/hotelpackages")
    public List<HotelPackageDTO> getAllHotelPackages() {
        List<HotelPackage> allHotelPackages = hotelPackageService.getAllHotelPackages();
        return allHotelPackages.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/hotelpackages/{id}")
    public ResponseEntity<HotelPackageDTO> getHotelPackageById(@PathVariable(value = "id") Long hotelPackageId) {
        HotelPackage hotelPackage = hotelPackageService.getHotelPackageById(hotelPackageId).get();
        return ResponseEntity.ok().body(convertToDto(hotelPackage));
    }

    @PostMapping("/hotelpackages")
    public HotelPackage createHotelPackage(@RequestBody HotelPackageDTO hotelPackageDTO) {
        return hotelPackageService.createHotelPackage(convertToEntity(hotelPackageDTO));
    }

    @PutMapping("/hotelpackages/{id}")
    public ResponseEntity<HotelPackage> updateHotelPackage(@PathVariable(value = "id") Long hotelPackageId, @RequestBody HotelPackage hotelPackage) throws ResourceNotFoundException {
        HotelPackage hotelPackageTemp = hotelPackageService.getHotelPackageById(hotelPackageId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel Package not found for this id :: " + hotelPackageId));
        hotelPackageTemp.setDescription(hotelPackage.getDescription());
        hotelPackageTemp.setHotelName(hotelPackage.getHotelName());
        hotelPackageTemp.setNights(hotelPackage.getNights());
        hotelPackageTemp.setDays(hotelPackage.getDays());
        final HotelPackage updatedHotelPackage = hotelPackageService.updateHotelPackage(hotelPackageTemp);
        return ResponseEntity.ok(updatedHotelPackage);
    }

    @DeleteMapping("/hotelpackages/{id}")
    public Map<String, Boolean> deleteHotelPackage(@PathVariable(value = "id") Long hotelPackageId)
            throws ResourceNotFoundException {
        HotelPackage hotelPackage = hotelPackageService.getHotelPackageById(hotelPackageId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel Package not found for this id :: " + hotelPackageId));

        hotelPackageService.deleteHotelPackage(hotelPackage);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public HotelPackageDTO convertToDto(HotelPackage hotelPackage) {
        modelMapper.typeMap(HotelPackage.class, HotelPackageDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getExpireyDate(),
                    HotelPackageDTO::addExpireyDate);
        });
        HotelPackageDTO hotelPackageDTO = modelMapper.map(hotelPackage, HotelPackageDTO.class);
        return hotelPackageDTO;
    }

    public HotelPackage convertToEntity(HotelPackageDTO hotelPackageDTO) {
        modelMapper.typeMap(HotelPackageDTO.class, HotelPackage.class).addMappings(mapper -> {
            mapper.map(src -> src.getPackageLastDate(),
                    HotelPackage::addExpireyDate);
        });
        HotelPackage hotelPackage = modelMapper.map(hotelPackageDTO, HotelPackage.class);
        return hotelPackage;
    }
}
