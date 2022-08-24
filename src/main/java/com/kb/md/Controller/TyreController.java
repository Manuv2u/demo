package com.kb.md.Controller;

import com.kb.md.Dao.ResponseStructure;
import com.kb.md.Entity.Car;
import com.kb.md.Entity.Tyre;
import com.kb.md.Service.TyreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TyreController {
    @Autowired
    TyreService service ;

    @ApiOperation(value = "Save the tyre Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "tyre Saved"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
    @PostMapping("/v1/car/{id}/tyre")
    public ResponseEntity<ResponseStructure<Tyre>> saveTyre(@PathVariable Long id , @RequestBody Tyre tyre){
        return service.saveTyre(id ,tyre);
    }
    @ApiOperation(value = "get the tyre Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "tyre Saved"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
    @GetMapping("/v1/tyre/{id}")
    public ResponseEntity<ResponseStructure<Tyre>> getTyreById(@PathVariable Long id ){
        return  service.getById(id);
    }
    @ApiOperation(value = "get the tyre list Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "tyre Saved"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
    @GetMapping("/v1/tyre")
    public ResponseEntity<ResponseStructure<List<Tyre>>> getAllTyre(){
        return service.getAllListTyre();
    }

    @ApiOperation(value = "update the tyre Details", produces = "application/json", consumes = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "tyre Saved"),
            @ApiResponse(code = 405, message = "Bad Request , unproper user data") })
    @PutMapping("/v1/tyre/{id}")
    public ResponseEntity<ResponseStructure<Tyre>> updateTyre(@PathVariable Long id, @RequestBody Tyre car) {
        return  service.updatetyreById(id , car);
    }
    @GetMapping("/v1/hii")
    public Tyre get(){
        return new Tyre();
    }
}
