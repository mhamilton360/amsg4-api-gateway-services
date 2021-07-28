package com.coat.ams.api.allocation.recap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AllocationPropertyRecapEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  StoreID;
	private Integer  SimStoreID;
	private Float    ShiftFactor;
	private Long     BatchID;
	private String   PropertyType;
	private String   Property;
	private String   ProxyPropertyType;
	private String   ProxyProperty;
	private String   VGR;
	private Long     ImminentAllocationTotal;
	private Long     NonImminentAllocationTotal;
	private Long     PreAllocationTotal;
	private Long     SAQ;
	private Long     StoreOHUnits;
	private Long     UnManUnits;
	private Long     StoreITUnits;
	private Long     StoreOOUnits;
	private Long     TotalStoreInventoryUnits;
	private Long     DistroedQuantity;
	private Long     AllocationTotal;
	private Float    WOSTarget;
	private Float    ActualWOS;
	private Float    VariancetoWOS;
	private Long     VariancetoWOSPct;
	private Long     SellingSeasonUnits;
	private Long     L4WUnits;
	private Long     L8WUnits;
	private String   SalesPeriodUsed;
	private Long     SalesAlgoUsed;
	private Long     SKU0Count;
	private Long     TotalSku0Count;
	private Long     AverageDepth;

	// getters and setters
}
