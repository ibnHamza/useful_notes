package me.error;


 
import lombok.Data;

@Data
public class CustomException extends Exception{
	
	/**
	 * 
	 */
 
	private String code;
    private String message;
    private String description;
 

	public CustomException(String msg) {
		super(msg);
		 
	}

	
	  public CustomException(ErrorDetails error) {
	  
	  this.code= error.getErrorCode();
	  this.description = error.getErrorDesc();
	  this.message = error.getErrorMessage();
	  
	  }
	 
	
	 
	 

}
