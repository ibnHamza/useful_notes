package me.error;

 
import lombok.Getter;

@Getter
public enum ErrorDetails {
	
	GENERAL_ERROR("SOME_ERROR_CODE_1",  "GENERIC ERROR", "Failed due to generic error"),
	INPUT_VALIDATION_ERROR("SOME_ERROR_CODE_2", "Input Validation Error", "Failed due to some wrong input"),
	;
	

	
	private String errorCode;
	private String errorMessage;
	private String errorDesc;

	private ErrorDetails(String errorCode, String errorMessage, String errorDesc) {
		
		this.errorCode = errorCode;
		
		this.errorMessage = errorMessage;
		this.errorDesc = errorDesc;
			}
	
	

}
