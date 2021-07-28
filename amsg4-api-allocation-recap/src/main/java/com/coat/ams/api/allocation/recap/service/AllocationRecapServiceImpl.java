/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coat.ams.api.allocation.recap.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.coat.ams.api.allocation.recap.data.AllocationRecapEntity;

@Service
public class AllocationRecapServiceImpl implements AllocationRecapService {

    @Override
    public List<AllocationRecapEntity> getAllocationRecap(String userId) {
        List<AllocationRecapEntity> returnValue = new ArrayList<>();
        
        AllocationRecapEntity allocationRecapEntity = new AllocationRecapEntity();
        allocationRecapEntity.setUserId(userId);
        allocationRecapEntity.setRecapId("recap1Id");
        allocationRecapEntity.setDescription("recap 1 description");
        allocationRecapEntity.setId(1L);
        allocationRecapEntity.setName("recap 1 name");
        
        AllocationRecapEntity recapEntity2 = new AllocationRecapEntity();
        recapEntity2.setUserId(userId);
        recapEntity2.setRecapId("recap2Id");
        recapEntity2.setDescription("recap 2 description");
        recapEntity2.setId(2L);
        recapEntity2.setName("recap 2 name");
        
        returnValue.add(allocationRecapEntity);
        returnValue.add(recapEntity2);
        
        return returnValue;
    }
    
}
