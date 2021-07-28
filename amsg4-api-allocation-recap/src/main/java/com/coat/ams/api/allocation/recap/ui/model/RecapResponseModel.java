/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coat.ams.api.allocation.recap.ui.model;

/**
 *
 * @author skargopolov
 */
public class RecapResponseModel {
    private String recapId;
    private String userId; 
    private String name;
    private String description;

    /**
     * @return the id
     */
    public String getRecapId() {
        return recapId;
    }

    /**
     * @param recapId the recapId to set
     */
    public void setRecapId(String recapId) {
        this.recapId = recapId;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
