package com.vendertool.sharedtypes.rnr;

import java.util.ArrayList;
import java.util.List;

import com.vendertool.sharedtypes.core.VTError;

public class BaseResponse {
	public enum ResponseAckStatusEnum{ SUCCESS, FAILURE, PARTIAL_SUCCESS_WITH_FAILURE; }
	
	private List<VTError> errors;
	private ResponseAckStatusEnum status;

	public BaseResponse() {
		errors = new ArrayList<VTError>();
	}
	
	public List<VTError> getErrors() {
		return errors;
	}

	public void setErrors(List<VTError> errors) {
		if(errors == null) {
			throw new IllegalArgumentException(
					"Trying to set null to error, use clearErrors() instead");
		}
		this.errors = errors;
	}
	
	public boolean addError(VTError error) {
		if(error == null) {
			return false;
		}
		
		return this.errors.add(error);
	}
	
	public void clearErrors() {
		this.errors.clear();
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}

	public ResponseAckStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ResponseAckStatusEnum status) {
		this.status = status;
	}
}
