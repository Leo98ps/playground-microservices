package br.com.playground;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.playground.exceptions.UnsupportedMathOperationException;

/**
 * Controller for mathematical operations.
 */
@RestController
public class MathController {

	/**
	 * Calculates the sum of two integers.
	 * 
	 * @param numberOne The first number to be added.
	 * @param numberTwo The second number to be added.
	 *
	 * @return The sum of the two provided numbers.
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@RequestMapping(value = "/add/{numberOne}/{numberTwo}", /* */
			method = RequestMethod.GET)
	public BigDecimal add(/* */
			@PathVariable(value = "numberOne") String numberOne, /* */
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if ((!StringUtils.hasText(numberOne) || !numberOne.matches("\\d+(\\.\\d+)?")) /* */
				|| (!StringUtils.hasText(numberTwo) || !numberTwo.matches("\\d+(\\.\\d+)?"))) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return new BigDecimal(numberOne)/* */
				.add(new BigDecimal(numberTwo)).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Subtracts the second number from the first number and returns the result.
	 * 
	 * @param numberOne The first number.
	 * @param numberTwo The second number to subtract from the first.
	 *
	 * @return The result of subtracting the second number from the first.
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", /* */
			method = RequestMethod.GET)
	public BigDecimal subtract(/* */
			@PathVariable(value = "numberOne") String numberOne, /* */
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if ((!StringUtils.hasText(numberOne) || !numberOne.matches("\\d+(\\.\\d+)?")) /* */
				|| (!StringUtils.hasText(numberTwo) || !numberTwo.matches("\\d+(\\.\\d+)?"))) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return new BigDecimal(numberOne)/* */
				.subtract(new BigDecimal(numberTwo)).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Multiplies the two provided numbers.
	 * 
	 * @param numberOne The first number.
	 * @param numberTwo The second number to multiply with the first.
	 * 
	 * @return The result of multiplying the two numbers (numberOne * numberTwo).
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", /* */
			method = RequestMethod.GET)
	public BigDecimal multiply(/* */
			@PathVariable(value = "numberOne") String numberOne, /* */
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if ((!StringUtils.hasText(numberOne) || !numberOne.matches("\\d+(\\.\\d+)?")) /* */
				|| (!StringUtils.hasText(numberTwo) || !numberTwo.matches("\\d+(\\.\\d+)?"))) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return new BigDecimal(numberOne)/* */
				.multiply(new BigDecimal(numberTwo)).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Divides the first number by the second number and returns the result.
	 * 
	 * @param numberOne The number to be divided.
	 * @param numberTwo The number by which the dividend is to be divided.
	 * 
	 * @return The result of dividing the dividend by the divisor.
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@RequestMapping(value = "/divide/{numberOne}/{numberTwo}", /* */
			method = RequestMethod.GET)
	public BigDecimal divide(/* */
			@PathVariable(value = "numberOne") String numberOne, /* */
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if ((!StringUtils.hasText(numberOne) || !numberOne.matches("\\d+(\\.\\d+)?")) /* */
				|| (!StringUtils.hasText(numberTwo) || !numberTwo.matches("\\d+(\\.\\d+)?"))) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return new BigDecimal(numberOne)/* */
				.divide(new BigDecimal(numberTwo)).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Calculates the average of the two provided numbers.
	 * 
	 * @param numberOne The first number.
	 * @param numberTwo The second number.
	 * 
	 * @return The average of the two numbers ((numberOne + numberTwo) / 2).
	 *
	 * @throws Exception If any other exception occurs.
	 */
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}", /* */
			method = RequestMethod.GET)
	public BigDecimal average(/* */
			@PathVariable(value = "numberOne") String numberOne, /* */
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if ((!StringUtils.hasText(numberOne) || !numberOne.matches("\\d+(\\.\\d+)?")) /* */
				|| (!StringUtils.hasText(numberTwo) || !numberTwo.matches("\\d+(\\.\\d+)?"))) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return (new BigDecimal(numberOne).add(new BigDecimal(numberTwo)))/* */
				.divide(BigDecimal.valueOf(2)).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * Calculates the square root of the provided number.
	 * 
	 * @param numberOne The number whose square root is to be calculated.
	 * 
	 * @return The square root of the provided number.
	 *
	 * @throws Exception If any other exception occurs.
	 */
	@RequestMapping(value = "/sqrt/{numberOne}", /* */
			method = RequestMethod.GET)
	public BigDecimal sqrt(/* */
			@PathVariable(value = "numberOne") String numberOne) throws Exception {

		if (!StringUtils.hasText(numberOne) || !numberOne.matches("\\d+(\\.\\d+)?")) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return new BigDecimal(numberOne).sqrt(new MathContext(2));
	}
}
