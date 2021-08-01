package com.omnirio.catalog.utility;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

@Service
public class ValidatorUtility {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	public void validate(Object obj) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Object>> constraintViolations =
				validator.validate(obj);
		if(!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	

}
