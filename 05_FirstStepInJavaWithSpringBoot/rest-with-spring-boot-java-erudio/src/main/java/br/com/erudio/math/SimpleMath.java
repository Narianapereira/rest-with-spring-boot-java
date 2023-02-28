package br.com.erudio.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

public class SimpleMath {
	
	public static Double sum(Double numberOne,
			Double numberTwo){
		return numberOne + numberTwo;
	}

	public static Double subtraction(Double numberOne, Double numberTwo){
	return numberOne - numberTwo;
	}
	
	public static Double multiplication(Double numberOne, Double numberTwo){
	return numberOne * numberTwo;
	}

	public static Double division(Double numberOne,Double numberTwo) {
	return numberOne / numberTwo;
	}
	
	public static Double mean(Double numberOne,Double numberTwo){
	return (numberOne + numberTwo)/2;
	}
	
	public static Double squareRoot(Double numberOne) {
	return Math.sqrt(numberOne);
	}

}
