package com.vendertool.sharedtypes.exception;

public class DuplicateException extends VTRuntimeException {
	
	private static final long serialVersionUID = 5660765195342454974L;

	public DuplicateException(String ex){
		super(ex);
	}
}
