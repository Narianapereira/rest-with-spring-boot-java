package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo) throws Exception{
	
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	return SimpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo) throws Exception{
	
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return SimpleMath.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo) throws Exception{
	
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return SimpleMath.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo) throws Exception{
	
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return SimpleMath.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo) throws Exception{
	
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	return SimpleMath.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/squareRoot/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable(value="numberOne") String numberOne) throws Exception{
	
		if(!NumberConverter.isNumeric(numberOne)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
	return SimpleMath.squareRoot(NumberConverter.convertToDouble(numberOne));
	}
	
}
	
	

