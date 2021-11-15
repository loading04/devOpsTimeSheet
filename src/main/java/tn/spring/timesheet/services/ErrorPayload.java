package tn.spring.timesheet.services;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorPayload {

    private String errorMessage;
    private String errorType;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public ErrorPayload(String errorMessage, String errorType) {
		super();
		this.errorMessage = errorMessage;
		this.errorType = errorType;
	}

//Getters and Setters and Constructors
    
}