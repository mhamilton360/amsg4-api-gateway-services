package com.coat.ams.api.allocation.recap.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coat.ams.api.allocation.recap.entity.AllocationPropertyRecapEntity;
import com.coat.ams.api.allocation.recap.service.AllocationPropertyRecapServiceImpl;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/allocation")
public class AllocationPropertyRecapController {
	
	@Autowired
	AllocationPropertyRecapServiceImpl allocationPropertyRecapServiceImpl; 
	
	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")	
	public String status() {
		return ("AMSG4 Allocation Recap status check on port "+ env.getProperty("local.server.port"));
	}
	
	@GetMapping(	
		path="/recap", 
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	)
	public List<AllocationPropertyRecapEntity> getAllocationPropertyRecap() {
		
		/*
		 * AllocationPropertyRecapEntity recap = new AllocationPropertyRecapEntity();
		 * 
		 * return ResponseEntity.status(HttpStatus.OK).body(recap);
		 */
		
		//Test values: 263377/property
		String batchIds = "263377";
		String reportIds = "property";  
		return allocationPropertyRecapServiceImpl.findById(batchIds, reportIds);
		
	}

	@GetMapping(path="/recap/{batchIds}/{reportIds}", 
			    produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<AllocationPropertyRecapEntity> getAllocatonPropertyRecapById(
			@PathVariable("batchIds") String batchIds, 
			@PathVariable("reportIds") String reportIds) {
		
		return allocationPropertyRecapServiceImpl.findById(batchIds, reportIds);
	}

	@PostMapping(	
		path="/recap", consumes = "application/json", produces = "application/json"
	)
	public ResponseEntity<Object>  create(@RequestBody AllocationPropertyRecapEntity allocPropertyRecap) {
		return null; //String.format("successfully accessed POST api\n");
	}

	@PutMapping(path="/recap/{id}", 
		consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	)
	public String update(@RequestBody String body, @PathVariable String id) {
		return String.format("successfully accessed PUT api with body={%s} and id={%s}\n", body, id);
	}

	@DeleteMapping(
		path="/recap/{id}", 
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	)
	public String update(String id) {
		return String.format("successfully accessed DELETE api with Id={%s}\n", id);
	}
}
