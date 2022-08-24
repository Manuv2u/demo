package com.kb.md.Entity;

import lombok.Data;

import javax.persistence.*;
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carid;
    private String brand ;
    private String name ;
    private String type ;
    private double price ;
    @OneToOne(mappedBy = "car" ,cascade = CascadeType.ALL)
    private Tyre tyre;

	public long getCarid() {
		return carid;
	}
	public void setCarid(long carid) {
		this.carid = carid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Tyre getTyre() {
		return tyre;
	}
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
    
}
