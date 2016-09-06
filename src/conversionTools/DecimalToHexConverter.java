package conversionTools;

public class DecimalToHexConverter {
	/**
	 * Takes in decimal input and converts into hexadecimal format.
	 * @param {int} decimal to be converted into hex format.
	 * @return {String} hex format of decimal, assumes 32 bit integer for negative input.
	 */
	public String decimalToHex(int decimal){
		if (decimal < 0) {
			// Convert to unsigned long if negative decimal
			long unsignedDecimal = Integer.toUnsignedLong(decimal);
			return convertToHex(unsignedDecimal);
		} else {
			return convertToHex(decimal);
		}
	}
	
	/**
	 * Take in a decimal as a parameter and continuously mod by 16 to produce
	 * the hexadecimal equivalent.
	 * @param {int} decimal to be converted into hex format.
	 * @return {String} hex format of decimal.
	 */
	private String convertToHex(long decimal) {
		if (decimal == 0) {
			return "0";
		}
		String res = "",
			   hexChar = "";
		long modValue = 0;
		while (decimal > 0) {
			modValue = decimal % 16;
			hexChar = toHexChar((int)modValue);
			decimal = decimal / 16;
			res = hexChar + res;
		}
		return res;
	}
	
	/**
	 * Basic switch case interchanges decimal value for hex value.
	 * @param {int} value 0-15 inclusive.
	 * @return {String} hex string char for value. 
	 */
	private String toHexChar(int value) {
		switch (value) {
			case 10:
				return "a";
			case 11:
				return "b";
			case 12: 
				return "c";
			case 13:
				return "d";
			case 14:
				return "e";
			case 15: 
				return "f";
			default:
				return Integer.toString(value);
		}		
	}
}
