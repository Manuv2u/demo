package com.kb.md.Dao;


import java.util.List;
import java.util.Optional;

import com.kb.md.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kb.md.Entity.Car;
@Repository
public class CarDAO {
  @Autowired
  CarRepository carRepository ;
    public List<Car> getallCars()
    {
      List<Car> car = carRepository.findAll();
      return car ;
    }

    public Car saveCar(Car car){
     return carRepository.save(car);
    }
    public Car getCarById(Long car_id){
      Optional<Car> car = carRepository.findById(car_id);
      if(car.isPresent()){
        return car.get();
      }
      else
        return null;
    }
    public boolean deleteCarById(Long car_id){
      Car car= getCarById(car_id);
      if(car!=null){
        carRepository.delete(car);
        return true ;
      }
      else
        return false ;
    }
    public Car updateCar(Long car_id , Car car){
      Car car1= getCarById(car_id);
      if(car!=null){
        car.setCarid(car_id);
       return carRepository.save(car);
      }
      else
        return null;
    }
}
