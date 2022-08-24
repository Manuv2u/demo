package com.kb.md.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kb.md.Entity.Car;


public interface CarRepository extends JpaRepository<Car, Long> {
}
