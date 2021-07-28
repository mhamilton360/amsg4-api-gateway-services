package com.coat.ams.api.allocation.recap.service.impl;

import java.util.List;
import java.util.Optional;

import com.coat.ams.api.allocation.recap.entity.AllocationPropertyRecapEntity;

public interface AllocationPropertyRecapService {
	
	List<AllocationPropertyRecapEntity> findAll();

    Optional < AllocationPropertyRecapEntity > findById(Long id);

    List<AllocationPropertyRecapEntity> findById(String batchIds, String reportId);

    void save(AllocationPropertyRecapEntity recap);

    void delete(Long id);

}
