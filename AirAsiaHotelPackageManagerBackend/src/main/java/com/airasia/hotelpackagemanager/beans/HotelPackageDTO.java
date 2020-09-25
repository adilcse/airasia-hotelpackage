package com.airasia.hotelpackagemanager.beans;

import com.airasia.hotelpackagemanager.util.DateFormatUtil;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * DTO class for entity HotelPackage
 * @author nitish
 */
public class HotelPackageDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String hotelName;
    private long days;
    private long nights;
    private String packageLastDate;
    private String description;
    private double price;
    private boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public long getNights() {
        return nights;
    }

    public void setNights(long nights) {
        this.nights = nights;
    }

    public String getPackageLastDate() {
        return packageLastDate;
    }

    public void setPackageLastDate(String packageLastDate) {
        this.packageLastDate = packageLastDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void addExpireyDate(Timestamp timestamp) {
        try {
            this.packageLastDate = DateFormatUtil.fomratDateYYYYMMDD(new Date(timestamp.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
