package com.kb.md.Entity;
import javax.persistence.*;
import lombok.Data;
@Entity
public class Tyre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tyreid;
    private String brand ;
    @OneToOne
    @JoinColumn(name = "car_id" ,referencedColumnName = "carid")
    private Car car;
	public long getTyreid() {
		return tyreid;
	}
	public void setTyreid(long tyreid) {
		this.tyreid = tyreid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
    
    
    }

