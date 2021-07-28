package com.coat.ams.api.allocation.recap.controllers;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coat.ams.api.allocation.recap.data.AllocationRecapEntity;
import com.coat.ams.api.allocation.recap.service.AllocationRecapService;
import com.coat.ams.api.allocation.recap.ui.model.RecapResponseModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/users/{id}/recap")
public class AllocationRecapController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    AllocationRecapService allocationRecapService;
    
    @GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE} )
    public List<RecapResponseModel> allocationRecap(@PathVariable String id) {

        List<RecapResponseModel> returnValue = new ArrayList<>();
        
        List<AllocationRecapEntity> recapEntities = allocationRecapService.getAllocationRecap(id);
        
        if(recapEntities == null || recapEntities.isEmpty()) {
            return returnValue;
        }
        
        Type listType = new TypeToken<List<RecapResponseModel>>(){}.getType();
 
        returnValue = new ModelMapper().map(recapEntities, listType);
        logger.info("Returning " + returnValue.size() + " recap allocation");
        return returnValue;
    }
}
