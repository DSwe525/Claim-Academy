package com.cribs.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="crib")
public class Crib {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="size")
    private String size;
    @Column(name ="price")
    private Double price;
    @Column(name ="date_posted")
    LocalDateTime datePosted = LocalDateTime.now();
    @Column(name ="image")
    private String image;

    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;
    
    public Crib() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        if(LocalDateTime.now().isAfter(datePosted.plusDays(90))) {
            return this.price * .90;
        }
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Crib [id=" + id + ", size=" + size + ", price=" + price + ", datePosted=" + datePosted + ", image="
                + image + ", address=" + address + "]";
    }




}



    

    

