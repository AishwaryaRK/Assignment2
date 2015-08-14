package org.pp.hugeinteger;

import java.util.function.Predicate;

public class HugeInteger {
	private static final int SIZE = 40;
	private int[] digits;
	private int length;

	public HugeInteger(String number) {
		digits = new int[SIZE];
		parse(number);
		length = number.length();

	}

	public HugeInteger() {
		digits = new int[SIZE];
	}

	private void parse(String number) {
		int i = 0;
		for (char c : number.toCharArray()) {
			digits[i++] = Integer.parseInt(c + "");
		}
	}

	public HugeInteger add(HugeInteger hugeInteger2) {
		HugeInteger sum = new HugeInteger();
		for (int i = 0; i < length; i++) {
			sum.digits[i + 1] = digits[i];
		}
		sum.length = length + 1;
		for (int i = length, j = hugeInteger2.length - 1; j >= 0; i--, j--) {
			int summation = sum.getDigits()[i] + hugeInteger2.getDigits()[j];
			if (summation > 9) {
				sum.getDigits()[i] = (summation % 10);
				sum.getDigits()[i - 1] = (summation / 10);
			} else {
				sum.getDigits()[i] = summation;
			}
		}
		return sum;
	}

	public HugeInteger sub(HugeInteger hugeInteger2) {
		HugeInteger sum = new HugeInteger();
		for (int i = 0; i < length; i++) {
			sum.digits[i + 1] = digits[i];
		}
		sum.length = length + 1;
		for (int i = length, j = hugeInteger2.length - 1; j >= 0; i--, j--) {
			if (sum.getDigits()[i] < hugeInteger2.digits[j]) {
				sum.getDigits()[i] = sum.getDigits()[i] + 10 - hugeInteger2.digits[j];
				sum.getDigits()[i - 1]--;
			} else {
				sum.getDigits()[i] -= hugeInteger2.digits[j];
			}
		}
		return sum;
	}

	public Predicate<HugeInteger> isEqualTo = (hugeInteger2) -> {
		return toString().equals(hugeInteger2.toString());
	};

	public Predicate<HugeInteger> isNotEqualTo = (hugeInteger2) -> {
		return !isEqualTo.test(hugeInteger2);
	};

	public Predicate<HugeInteger> isGreaterThan = (hugeInteger2) -> {
		if (length > hugeInteger2.length) {
			return true;
		}
		if (length < hugeInteger2.length) {
			return false;
		}
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != hugeInteger2.digits[i]) {
				if (digits[i] > hugeInteger2.digits[i]) {
					return true;
				}
				return false;
			}
		}
		return false;
	};

	public Predicate<HugeInteger> isGreaterThanOrEqualTo = (hugeInteger2) -> {
		if (length > hugeInteger2.length) {
			return true;
		}
		if (length < hugeInteger2.length) {
			return false;
		}
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != hugeInteger2.digits[i]) {
				if (digits[i] > hugeInteger2.digits[i]) {
					return true;
				}
				return false;
			}
		}
		return true;
	};

	public Predicate<HugeInteger> isLessThan = (hugeInteger2) -> {
		return !isGreaterThanOrEqualTo.test(hugeInteger2);
	};

	public Predicate<HugeInteger> isLessThanOrEqualTo = (hugeInteger2) -> {
		return !isGreaterThan.test(hugeInteger2);
	};

	@Override
	public String toString() {
		String number = "";
		for (int i = 1; i < length; i++) {
			number += digits[i];
		}
		if (digits[0] != 0) {
			number = digits[0] + number;
		}
		return number;
	}

	public int[] getDigits() {
		return digits;
	}

}
