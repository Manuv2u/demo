package com.kb.md.Service;

import com.kb.md.Dao.ResponseStructure;
import com.kb.md.Dao.TyreDao;
import com.kb.md.Entity.Car;
import com.kb.md.Entity.Tyre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TyreService {
    @Autowired
    TyreDao dao ;

    public ResponseEntity<ResponseStructure<Tyre>> saveTyre(Long id ,Tyre tyre){
        if (dao.saveTyre(id ,tyre) != null) {
            ResponseStructure<Tyre> responseStructure = new ResponseStructure<Tyre>();
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Sucessfully Saved");
            responseStructure.setData(dao.saveTyre(id ,tyre));
            ResponseEntity<ResponseStructure<Tyre>> responseEntity = new ResponseEntity<ResponseStructure<Tyre>>(
                    responseStructure, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseStructure<Tyre> responseStructure = new ResponseStructure<Tyre>();
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Not Saved");
            responseStructure.setData(null);
            ResponseEntity<ResponseStructure<Tyre>> responseEntity = new ResponseEntity<ResponseStructure<Tyre>>(
                    responseStructure, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }

    public ResponseEntity<ResponseStructure<Tyre>> getById(Long id ){
        if (dao.getById(id) != null) {
            ResponseStructure<Tyre> responseStructure = new ResponseStructure<Tyre>();
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Sucessfully get");
            responseStructure.setData(dao.getById(id));
            ResponseEntity<ResponseStructure<Tyre>> responseEntity = new ResponseEntity<ResponseStructure<Tyre>>(
                    responseStructure, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseStructure<Tyre> responseStructure = new ResponseStructure<Tyre>();
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Not data prasent");
            responseStructure.setData(null);
            ResponseEntity<ResponseStructure<Tyre>> responseEntity = new ResponseEntity<ResponseStructure<Tyre>>(
                    responseStructure, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }
    public ResponseEntity<ResponseStructure<List<Tyre>>> getAllListTyre(){
        if (dao.getAllTyre() != null) {
            ResponseStructure<List<Tyre>> responseStructure = new ResponseStructure<List<Tyre>>();
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Sucessfully Saved");
            responseStructure.setData(dao.getAllTyre());
            ResponseEntity<ResponseStructure<List<Tyre>>> responseEntity = new ResponseEntity<ResponseStructure<List<Tyre>>>(
                    responseStructure, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseStructure<List<Tyre>> responseStructure = new ResponseStructure<List<Tyre>>();
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Not Saved");
            responseStructure.setData(null);
            ResponseEntity<ResponseStructure<List<Tyre>>> responseEntity = new ResponseEntity<ResponseStructure<List<Tyre>>>(
                    responseStructure, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }
    public ResponseEntity<ResponseStructure<Tyre>> updatetyreById(Long id , Tyre car){
       // Tyre car1 = dao.getById(id);
        if (dao.updateTyre(id ,car) != null) {
            ResponseStructure<Tyre> responseStructure = new ResponseStructure<Tyre>();
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Sucessfully update");
            responseStructure.setData(dao.updateTyre(id ,car) );
            ResponseEntity<ResponseStructure<Tyre>> responseEntity = new ResponseEntity<ResponseStructure<Tyre>>(
                    responseStructure, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseStructure<Tyre> responseStructure = new ResponseStructure<Tyre>();
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Not update");
            responseStructure.setData(null);
            ResponseEntity<ResponseStructure<Tyre>> responseEntity = new ResponseEntity<ResponseStructure<Tyre>>(
                    responseStructure, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }
}

