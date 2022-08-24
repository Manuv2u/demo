package com.kb.md.Dao;

import java.util.List;
import java.util.Optional;
import com.kb.md.Entity.Car;
import com.kb.md.Entity.Tyre;
import com.kb.md.Repository.TyreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TyreDao {
    @Autowired
    TyreRepository tyreRepository;
    @Autowired
    CarDAO dao ;
    public Tyre saveTyre( Long car_id ,Tyre tyre){
        Car car = dao.getCarById(car_id);
        if(car!=null){
          tyre.setCar(car);
           car.setTyre(tyre);
       return tyreRepository.save(tyre);}
       else
           return null;
    }
    public List<Tyre> getAllTyre(){
        List<Tyre> list = tyreRepository.findAll();
        if(list.isEmpty()){
            return null;
        }else
            return list ;
    }
    public Tyre getById(Long tyre_Id){
        Optional<Tyre> tyre = tyreRepository.findById(tyre_Id);
        Tyre tyre1 =new Tyre();
        if(tyre.isPresent()){
           // Car car = tyre1.getCar();
            Tyre tyre2 =  tyre.get();
            tyre2.getCar();
            return tyre2 ;
        }else
            return null;
    }
    public Tyre updateTyre(Long tyre_id , Tyre tyre){
        Tyre car1= getById(tyre_id);
        if(car1!=null){
            tyre.setTyreid(tyre_id);
            return tyreRepository.save(tyre);
        }
        else
            return null;
    }
}
