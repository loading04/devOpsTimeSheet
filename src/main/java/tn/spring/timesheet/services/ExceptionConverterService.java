package tn.spring.timesheet.services;


import java.util.Collections;

import org.springframework.stereotype.Service;

@Service
public class ExceptionConverterService {
	  public GenericResponse convert(Exception x) {

	        GenericResponse genericResponse = new GenericResponse();
	        genericResponse.setError(true);
	        String exceptionType = x.getClass().getSimpleName();
	        String exceptionMessage = x.getClass().getSimpleName();
	        genericResponse.setErrorPayload(Collections.singletonList(new ErrorPayload(exceptionType, exceptionMessage)));
	        return genericResponse;

	    }

	}


