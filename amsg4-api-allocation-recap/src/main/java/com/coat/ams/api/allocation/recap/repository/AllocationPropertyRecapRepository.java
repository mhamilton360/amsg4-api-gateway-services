package com.coat.ams.api.allocation.recap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coat.ams.api.allocation.recap.entity.AllocationPropertyRecapEntity;



/**
	procedure BAS.get_alloc_property_recap
	(    I_batch_ids IN CLOB ,  			--- comma separated batch Id string 
	     I_report varchar2 ,    			--- which report to be displayed property, property_class, property_subclass
	     o_property_cur OUT sys_refcursor,	--- actual  query cursor returned
	     o_status OUT VARCHAR  				--- the Validation will return Success or failure. 
	     										--- We can return detailed error message like batch Id’s are 
	     										--- invalid and batch Ids are not run yet may be with a separater ‘:’ or ‘/’
	)

 * @author mhamil9
 * @param <AllocationPropertyRecapEntity>
 *
 */

@Repository
public interface AllocationPropertyRecapRepository extends JpaRepository<AllocationPropertyRecapEntity, Long> {
}
