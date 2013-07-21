package com.vendertool.batch;

import java.util.HashMap;
import java.util.Map;

public enum VenderBatchStatus {

	   RECORD_LOADED(1, "Record read from input feed."),
	   RECORD_VALIDATION_SUCESS(2, "Validation Success"),
	   RECORD_VALIDATION_FAILURE(3, "Validation Failure"),
	   RECORD_OPERATION_SUCESS(4, "Operation Sucess"),
	   RECORD_OPERATION_FAILURE(5, "Operation Failure");
	   
	   private final int value;
	   private final String description;
	   
	   private VenderBatchStatus(int value, String description) {
	      this.value = value;
	      this.description = description;
	   }
	   public int getValue() {
	      return value;
	   }
	   
	   public String getDescription(){
		   return description;
	   }
	   @Override
	    public String toString() {
	        return getValue()+" -- " +getDescription();
	    }
	   
	   private static Map<Integer, VenderBatchStatus> map = new HashMap<Integer, VenderBatchStatus>();

	    static {
	        for (VenderBatchStatus legEnum : VenderBatchStatus.values()) {
	            map.put(legEnum.value, legEnum);
	        }
	    }
	    
	    public static VenderBatchStatus valueOf(int statusValue) {
	        return map.get(statusValue);
	    }
}