package com.kb.md.Controller;

import com.kb.md.Dao.ResponseStructure;
import com.kb.md.Entity.Car;
import com.kb.md.Service.CarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CarController {
    @Autowired
    CarService carService ;

    @ApiOperation(value = "Save the car Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "car Saved"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
    @PostMapping("/v1/car")
    public ResponseEntity<ResponseStructure<Car>> saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @ApiOperation(value = "get the car Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "car get"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
    @GetMapping("/v1/car/{id}")
    public ResponseEntity<ResponseStructure<Car>> getCarByID(@PathVariable long id){
        return carService.getByIdCar(id);
    }
    @ApiOperation(value = "list of  the car Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "car list"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
       @GetMapping("/v1/car")
    public ResponseEntity<ResponseStructure<List<Car>>>getAllCar(){
        return carService.getAllCar();
       }

    @ApiOperation(value = "delete the car Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "car Saved"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
       @DeleteMapping("/v1/car/{id}")
    public ResponseEntity<ResponseStructure<Boolean>> deleteCarById(@PathVariable Long id){
        return carService.deleteCarById(id);
       }
    @ApiOperation(value = "update the car Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "car Saved"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
       @PutMapping("/v1/car/{id}")
       public ResponseEntity<ResponseStructure<Car>> updateCar( @PathVariable Long id,@RequestBody Car car) {
        return  carService.updateCarById(id , car);
       }
       @GetMapping("/v1/hi")
        public Car get(){
        return new Car();
       }
}
