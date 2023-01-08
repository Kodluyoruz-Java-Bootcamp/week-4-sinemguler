package com.emlakcepteservice.controller;

import com.emlakcepteservice.model.Realty;
import com.emlakcepteservice.request.RealtyRequest;
import com.emlakcepteservice.request.RealtyUpdateRequest;
import com.emlakcepteservice.response.RealtyResponse;
import com.emlakcepteservice.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController {
    @Autowired
    private RealtyService realtyService;

    // GET /realtyes
    @GetMapping
    public ResponseEntity<List<Realty>> getAll() {
        return ResponseEntity.ok(realtyService.getAll());
    }

    // POST /realtyes
    @PostMapping
    public ResponseEntity<Realty> create(@RequestBody RealtyRequest realtyRequest) {
        Realty realty = realtyService.create(realtyRequest);
        return new ResponseEntity<>(realty,HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Realty>> getAllByUserId(@PathVariable int id) {
        List<Realty> realtyes = realtyService.getAllById(id);
        return ResponseEntity.ok(realtyes);
    }

    @GetMapping(value = "/status/active")
    public ResponseEntity<List<Realty>> getAllActiveRealtyes() {
        List<Realty> realtyes = realtyService.getAllActiveRealtyes();
        return ResponseEntity.ok(realtyes);
    }

    @GetMapping(value = "/status/passive")
    public ResponseEntity<List<Realty>> getAllPassiveRealtyes() {
        List<Realty> realtyes = realtyService.getAllPassiveRealtyes();
        return ResponseEntity.ok(realtyes);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RealtyResponse> update( @PathVariable int id, @RequestBody() RealtyUpdateRequest realtyUpdateRequest) {
        realtyUpdateRequest.setId(id);
        RealtyResponse realtyResponse = realtyService.update(realtyUpdateRequest);
        return new ResponseEntity<>(realtyResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        realtyService.delete(id);
        return "deleted " +  id;
    }

}
