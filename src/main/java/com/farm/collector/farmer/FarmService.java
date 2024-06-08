/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farm.collector.farmer;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zngcamphalala
 */
@Service
@Slf4j
public class FarmService {
    
    @Autowired
    private FarmRepo farmRepo;

    @Autowired
    private FieldDataRepo fieldRepo;

    public Farm saveFarm(Farm farm) {
        log.info("Farm service" + farm);
        return farmRepo.save(farm);
    }

    public FieldData saveField(FieldData field) {
        return fieldRepo.save(field);
    }

    public List<FieldData> getFieldsByFarmAndSeason(Long farmId, String season) {
        return fieldRepo.findByFarmIdAndSeason(farmId, season);
    }

    public List<FieldData> getFieldsByCropTypeAndSeason(String cropType, String season) {
        return fieldRepo.findByCropTypeAndSeason(cropType, season);
    }
    
     public Farm getFarmById(Long id) {

        log.info("Fetching the Farm by id {} ", id);
        Farm farm = farmRepo.findById(id).orElse(null);
        if (farm != null) {

            return farm;
        } else {
            // Handle the case where the farm is not found
            return new Farm();
        }
    }
    
}
