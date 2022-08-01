package me.error;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 


import lombok.extern.slf4j.Slf4j;

 
 


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler   extends ResponseEntityExceptionHandler  {
	
	private static final String EXCEPTION_MSG = "Exception Code: {}, Exception Msg: {}, Exception desc: {}";
	 
	@ExceptionHandler(CustomException.class)
    protected ResponseEntity<> handleGlobalException(CustomException customException, Locale locale) {
		 GenericError response = new GenericError();
		 response.setDescription(customException.getDescription());
		 response.setMessage(customException.getMessage());
		 response.setErrorCode(customException.getCode());
		 log.error(EXCEPTION_MSG,customException.getCode(),customException.getMessage(),customException.getDescription());
		
		 if(customException.getErrorDump() != null) {
			 log.error("ErrorDump found: {}",customException.getErrorDump());
			 
		 }
		
		 GenericResponse genericResponse = generateGenericResponse(response);
		 return new ResponseEntity(genericResponse, new HttpHeaders(), HttpStatus.OK);
    }
	
	 
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,HttpHeaders headers,HttpStatus status,WebRequest request) {

//custom class to wrappp the error
		GenericError response = new GenericError();
		 response.setDescription(ErrorDetails.INPUT_VALIDATION_ERROR.getErrorDesc());
		 response.setMessage(ErrorDetails.INPUT_VALIDATION_ERROR.getErrorMessage());
		 response.setErrorCode(ErrorDetails.INPUT_VALIDATION_ERROR.getErrorCode());
		 log.error(EXCEPTION_MSG,response.getErrorCode(),response.getMessage(),response.getDescription());
		 exception.printStackTrace();
		 GenericResponse genericResponse = generateGenericResponse(response);
		  
		 return new ResponseEntity(genericResponse, new HttpHeaders(), HttpStatus.OK); 
         }
	
	
    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleException(Exception e, Locale locale) {
		//custom class to wrappp the error
    	 GenericError response = new GenericError();
		
    	 response.setDescription(e.getMessage());
		 response.setMessage(ErrorDetails.GENERAL_ERROR.getErrorMessage());
		 response.setErrorCode(ErrorDetails.GENERAL_ERROR.getErrorCode());
		 log.error(EXCEPTION_MSG,ErrorDetails.GENERAL_ERROR.getErrorCode(),e.getMessage(),ErrorDetails.GENERAL_ERROR.getErrorDesc());
		 
		 GenericResponse genericResponse = generateGenericResponse(response);
        
		 return new ResponseEntity(genericResponse, new HttpHeaders(), HttpStatus.OK);
    }
    
    
    public GenericResponse generateGenericResponse(GenericError error){
        GenericResponse genericResponse = new GenericResponse<>();
        genericResponse.setResponseEntity(null);
        genericResponse.setGenericError(error);
        return genericResponse;
    }


}
