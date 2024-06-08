/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farm.collector.farmer;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zngcamphalala
 */
@RestController
@RequestMapping(value = "/farms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
@Slf4j
public class FarmController {
    
    @Autowired
    private FarmService farmService;

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
        if(farm.getFieldDataList() != null){
            farm.getFieldDataList().forEach(data -> data.setFarm(farm));
        }
        Farm savedFarm = farmService.saveFarm(farm);
        log.info("Farm " + farm);
        return new ResponseEntity<>(savedFarm, HttpStatus.CREATED);
    }

    @PostMapping("/fields")
    public ResponseEntity<FieldData> createField(FieldData field) {
        FieldData savedField = farmService.saveField(field);
        return new ResponseEntity<>(savedField, HttpStatus.CREATED);
    }

    @GetMapping("/reports")
    public ResponseEntity<List<FieldData>> getReportByFarmAndSeason(
        @RequestParam Long farmId, @RequestParam String season) {
        List<FieldData> fields = farmService.getFieldsByFarmAndSeason(farmId, season);
        return new ResponseEntity<>(fields, HttpStatus.OK);
    }

    @GetMapping("/reports/crop")
    public ResponseEntity<List<FieldData>> getReportByCropTypeAndSeason(
        @RequestParam String cropType, @RequestParam String season) {
        List<FieldData> fields = farmService.getFieldsByCropTypeAndSeason(cropType, season);
        return new ResponseEntity<>(fields, HttpStatus.OK);
    }
    
}
