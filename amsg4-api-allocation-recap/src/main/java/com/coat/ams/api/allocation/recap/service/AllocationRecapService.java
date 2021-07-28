/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coat.ams.api.allocation.recap.service;


import java.util.List;

import com.coat.ams.api.allocation.recap.data.AllocationRecapEntity;

public interface AllocationRecapService {
    List<AllocationRecapEntity> getAllocationRecap(String userId);
}
