package com.kb.md.Service;
import com.kb.md.Dao.CarDAO;
import com.kb.md.Dao.ResponseStructure;
import com.kb.md.Entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarDAO dao ;
        public ResponseEntity<ResponseStructure<Car>> saveCar(Car user) {
            if (user != null) {
                ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
                responseStructure.setStatus(HttpStatus.OK.value());
                responseStructure.setMessage("Sucessfully Saved");
                responseStructure.setData(dao.saveCar(user));
                ResponseEntity<ResponseStructure<Car>> responseEntity = new ResponseEntity<ResponseStructure<Car>>(
                        responseStructure, HttpStatus.OK);
                return responseEntity;
            } else {
                ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
                responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
                responseStructure.setMessage("Not Saved");
                responseStructure.setData(null);
                ResponseEntity<ResponseStructure<Car>> responseEntity = new ResponseEntity<ResponseStructure<Car>>(
                        responseStructure, HttpStatus.NOT_FOUND);
                return responseEntity;
            }
    }
    public ResponseEntity<ResponseStructure<Car>> getByIdCar(Long id){
        if (dao.getCarById(id) != null) {
            ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Sucessfully");
            responseStructure.setData(dao.getCarById(id));
            ResponseEntity<ResponseStructure<Car>> responseEntity = new ResponseEntity<ResponseStructure<Car>>(
                    responseStructure, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Not Found");
            responseStructure.setData(null);
            ResponseEntity<ResponseStructure<Car>> responseEntity = new ResponseEntity<ResponseStructure<Car>>(
                    responseStructure, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }
    public ResponseEntity<ResponseStructure<List<Car>>> getAllCar(){
        if (dao.getallCars().size() > 0) {
            ResponseStructure<List<Car>> responseStructure = new ResponseStructure<List<Car>>();
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Sucessfuly");
            responseStructure.setData(dao.getallCars());
            ResponseEntity<ResponseStructure<List<Car>>> responseEntity = new ResponseEntity<ResponseStructure<List<Car>>>(
                    responseStructure, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseStructure<List<Car>> responseStructure = new ResponseStructure<List<Car>>();
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Not Found List");
            responseStructure.setData(null);
            ResponseEntity<ResponseStructure<List<Car>>> responseEntity = new ResponseEntity<ResponseStructure<List<Car>>>(
                    responseStructure, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }
    public ResponseEntity<ResponseStructure<Boolean>> deleteCarById(Long id){
        if (dao.deleteCarById(id)==true) {
            ResponseStructure<Boolean> responseStructure = new ResponseStructure<Boolean>();
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Sucessfully deleted");
            responseStructure.setData(true);
            ResponseEntity<ResponseStructure<Boolean>> responseEntity = new ResponseEntity<ResponseStructure<Boolean>>(
                    responseStructure, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseStructure<Boolean> responseStructure = new ResponseStructure<Boolean>();
            responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure.setMessage("User Not Deleted");
            responseStructure.setData(false);
            ResponseEntity<ResponseStructure<Boolean>> responseEntity = new ResponseEntity<ResponseStructure<Boolean>>(
                    responseStructure, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }
    public ResponseEntity<ResponseStructure<Car>> updateCarById(Long id , Car car){
          //  Car car1 = dao.getCarById(id);
        if (dao.updateCar(id ,car) != null) {
            ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Sucessfully update");
            responseStructure.setData(dao.updateCar(id ,car) );
            ResponseEntity<ResponseStructure<Car>> responseEntity = new ResponseEntity<ResponseStructure<Car>>(
                    responseStructure, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Not update");
            responseStructure.setData(null);
            ResponseEntity<ResponseStructure<Car>> responseEntity = new ResponseEntity<ResponseStructure<Car>>(
                    responseStructure, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }
}
