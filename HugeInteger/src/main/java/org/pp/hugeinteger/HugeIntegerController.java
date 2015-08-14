package org.pp.hugeinteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HugeIntegerController {

	@RequestMapping(produces = { "application/xml", "application/json" }, value = "/add")
	public String add(@RequestParam(value = "number1", defaultValue = "123") String number1,
			@RequestParam(value = "number2", defaultValue = "111") String number2) {
		System.out.println("in add()");
		HugeInteger hugeInteger1 = new HugeInteger(number1);
		HugeInteger hugeInteger2 = new HugeInteger(number2);
		HugeInteger sum = hugeInteger1.add(hugeInteger2);
		System.out.println(sum);
		return sum.toString();
	}

	@RequestMapping(produces = { "application/xml", "application/json" }, value = "/sub")
	public String sub(@RequestParam(value = "number1", defaultValue = "0") String number1,
			@RequestParam(value = "number2", defaultValue = "0") String number2) {
		System.out.println("in sub()");
		HugeInteger hugeInteger1 = new HugeInteger(number1);
		HugeInteger hugeInteger2 = new HugeInteger(number2);
		HugeInteger diff = hugeInteger1.sub(hugeInteger2);
		return diff.toString();
	}

	@RequestMapping(produces = { "application/xml", "application/json" }, value = "/isEqual")
	public boolean isEqual(@RequestParam(value = "number1", defaultValue = "0") String number1,
			@RequestParam(value = "number2", defaultValue = "0") String number2) {
		System.out.println("in isEqual()");
		HugeInteger hugeInteger1 = new HugeInteger(number1);
		HugeInteger hugeInteger2 = new HugeInteger(number2);
		return hugeInteger1.isEqualTo.test(hugeInteger2);
	}

	@RequestMapping(produces = { "application/xml", "application/json" }, value = "/isNotEqual")
	public boolean isNotEqual(@RequestParam(value = "number1", defaultValue = "0") String number1,
			@RequestParam(value = "number2", defaultValue = "0") String number2) {
		System.out.println("in isNotEqual()");
		HugeInteger hugeInteger1 = new HugeInteger(number1);
		HugeInteger hugeInteger2 = new HugeInteger(number2);
		return hugeInteger1.isNotEqualTo.test(hugeInteger2);
	}

	@RequestMapping(produces = { "application/xml", "application/json" }, value = "/isGreaterThan")
	public boolean isGreaterThan(@RequestParam(value = "number1", defaultValue = "0") String number1,
			@RequestParam(value = "number2", defaultValue = "0") String number2) {
		System.out.println("in isGreater()");
		HugeInteger hugeInteger1 = new HugeInteger(number1);
		HugeInteger hugeInteger2 = new HugeInteger(number2);
		return hugeInteger1.isGreaterThan.test(hugeInteger2);
	}

	@RequestMapping(produces = { "application/xml", "application/json" }, value = "/isGreaterThanOrEqualTo")
	public boolean isGreaterThanOrEqualTo(@RequestParam(value = "number1", defaultValue = "0") String number1,
			@RequestParam(value = "number2", defaultValue = "0") String number2) {

		HugeInteger hugeInteger1 = new HugeInteger(number1);
		HugeInteger hugeInteger2 = new HugeInteger(number2);
		return hugeInteger1.isGreaterThanOrEqualTo.test(hugeInteger2);
	}

	@RequestMapping(produces = { "application/xml", "application/json" }, value = "/isLessThan")
	public boolean isLessThan(@RequestParam(value = "number1", defaultValue = "0") String number1,
			@RequestParam(value = "number2", defaultValue = "0") String number2) {

		HugeInteger hugeInteger1 = new HugeInteger(number1);
		HugeInteger hugeInteger2 = new HugeInteger(number2);
		return hugeInteger1.isLessThan.test(hugeInteger2);
	}

	@RequestMapping(produces = { "application/xml", "application/json" }, value = "/isLessThanOrEqualTo")
	public boolean isLessThanOrEqualTo(@RequestParam(value = "number1", defaultValue = "0") String number1,
			@RequestParam(value = "number2", defaultValue = "0") String number2) {

		HugeInteger hugeInteger1 = new HugeInteger(number1);
		HugeInteger hugeInteger2 = new HugeInteger(number2);
		return hugeInteger1.isLessThanOrEqualTo.test(hugeInteger2);
	}

}
