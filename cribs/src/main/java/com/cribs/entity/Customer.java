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
@Table(name="customer")
public class Customer {
    
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="email")
    private String email;
    @Column(name ="password")
    private String password;
    
    @OneToMany
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private List<Crib> cribsPurchased;
    
    public List<Crib> getCribsPurchased() {
        return cribsPurchased;
    }

    public void setCribsPurchased(List<Crib> cribsPurchased) {
        this.cribsPurchased = cribsPurchased;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    @Override
    public String toString() {
        return "Customer [id=" + id + ", email=" + email + ", password=" + password + "]";
    }


    
}
