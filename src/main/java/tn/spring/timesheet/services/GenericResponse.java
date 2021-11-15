package tn.spring.timesheet.services;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericResponse {

    private Boolean error;
    private List<ErrorPayload> errorPayload;
    private Object payload;

    public GenericResponse(Boolean error) {
        this.error = error;
    }

    public static GenericResponse ok() {
        return new GenericResponse(false);
    }

     public GenericResponse payload(Serializable o) {
         this.payload = o;
         return this;
     }

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public List<ErrorPayload> getErrorPayload() {
		return errorPayload;
	}

	public void setErrorPayload(List<ErrorPayload> errorPayload) {
		this.errorPayload = errorPayload;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public GenericResponse(Boolean error, List<ErrorPayload> errorPayload, Object payload) {
		super();
		this.error = error;
		this.errorPayload = errorPayload;
		this.payload = payload;
	}

	public GenericResponse() {
		super();

	}
     

}

