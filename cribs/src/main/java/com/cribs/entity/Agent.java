package com.cribs.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agent")
public class Agent {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="name")
    private String name;
    @Column(name ="phone_number")
    private String phoneNumber;
    @Column(name ="image")
    private String image;
    
    @OneToMany
    @JoinColumn(name="agent_id", referencedColumnName = "id")
    private List<Crib> cribsForSale;
    
    public Agent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Agent [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", image=" + image + "]";
    }
    

}
