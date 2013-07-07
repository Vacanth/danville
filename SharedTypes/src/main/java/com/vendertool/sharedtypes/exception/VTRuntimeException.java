package com.vendertool.sharedtypes.exception;

public class VTRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -4057210276493039070L;

	public VTRuntimeException(String ex){
		super(ex);
	}
	
	public VTRuntimeException(Exception ex) {
		super(ex);
	}
}
