package com.airasia.hotelpackagemanager.model;

import com.airasia.hotelpackagemanager.util.DateFormatUtil;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Model class for Hotel Package
 * @author nitish
 */
@Entity
@Table(name = "hotel_package")
public class HotelPackage {

    private long id;
    private String hotelName;
    private long days;
    private long nights;
    private Timestamp expireyDate;
    private String description;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private double price;
    private boolean active;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "hotel_name", nullable = false)
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Column(name = "days")
    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    @Column(name = "nights", nullable = false)
    public long getNights() {
        return nights;
    }

    public void setNights(long nights) {
        this.nights = nights;
    }

    @Column(name = "expirey_date")
    public Timestamp getExpireyDate() {
        return expireyDate;
    }

    public void setExpireyDate(Timestamp expireyDate) {
        this.expireyDate = expireyDate;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @CreationTimestamp
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @UpdateTimestamp
    @Column(name = "modify_date")
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Type(type="yes_no")
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void addExpireyDate(String expireyDate){
        try {
            this.expireyDate = new Timestamp(DateFormatUtil.parseDateYYYYMMDD(expireyDate).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
