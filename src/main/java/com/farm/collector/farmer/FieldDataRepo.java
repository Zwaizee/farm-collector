/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.farm.collector.farmer;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zngcamphalala
 */
@Repository
public interface FieldDataRepo extends JpaRepository<FieldData, Long>{
    
    List<FieldData> findByFarmIdAndSeason(Long farmId, String season);
    List<FieldData> findByCropTypeAndSeason(String cropType, String season);
}
