/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.farm.collector.farmer;

import java.util.Optional;
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
public class FarmServiceTest {
    @Mock
    private FarmRepo farmRepository;

    @InjectMocks
    private FarmService farmService;

    private Farm farm;

    @BeforeEach
    void setUp() {
        farm = new Farm();
        farm.setId(1L);
        farm.setName("MyFirstFarm");
    }

    @Test
    void testGetFarmById() {
        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
        Farm result = farmService.getFarmById(1L);
        assertEquals(farm.getId(), result.getId());
        assertEquals(farm.getName(), result.getName());
        verify(farmRepository, times(1)).findById(1L);
    }
}
