/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farm.collector.farmer;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author zngcamphalala
 */
@ExtendWith(MockitoExtension.class)
public class FieldDataServiceTest {
    
     @Mock
    private FieldDataRepo fieldDataRepository;

    @InjectMocks
    private FarmService farmService;

    private FieldData fieldData;

    @BeforeEach
    void setUp() {
        fieldData = new FieldData();
        fieldData.setId(1L);
        fieldData.setSeason("Spring");
        fieldData.setCropType("Corn");
        fieldData.setAcresPlantingArea(5);
        fieldData.setPlantedAmount(100.0);
        fieldData.setHaverstedAmount(50.0);
    }

    @Test
    void testGetFieldDataByFarmIdAndSeason() {
        List<FieldData> fieldDataList = new ArrayList<>();
        fieldDataList.add(fieldData);
        when(fieldDataRepository.findByFarmIdAndSeason(1L, "Spring")).thenReturn(fieldDataList);
        List<FieldData> result = farmService.getFieldsByFarmAndSeason(1L, "Spring");
        assertEquals(1, result.size());
        assertEquals(fieldData.getId(), result.get(0).getId());
        verify(fieldDataRepository, times(1)).findByFarmIdAndSeason(1L, "Spring");
    }
    
}
