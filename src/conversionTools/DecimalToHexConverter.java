package conversionTools;

public class DecimalToHexConverter {
	/**
	 * Takes in decimal input and converts into hexadecimal format
	 * @param {int} decimal
	 * @return {String} hex format of decimal, assumes 32 bit integer for negative input
	 */
	public String decimalToHex(int decimal){
		if (decimal < 0) {
			// TODO: Implement behavior for negative inputs (wrap around based on 32 bit integers)
			return "";
		} else {
			return divideBySixteen(decimal);
		}
	}
	/**
	 * Take in a decimal as a parameter and continuously mod by 16 to produce
	 * the hexadecimal equivalent.
	 * @param {int} decimal
	 * @return {String} hex format of decimal
	 */
	private String divideBySixteen(int decimal) {
		if (decimal == 0) {
			return "0";
		}
		
		String res = "",
			   hexChar = "";
		int modValue = 0;
		while (decimal > 0) {
			modValue = decimal % 16;
			hexChar = toHex(modValue);
			decimal = decimal / 16;
			res = hexChar + res;
		}
		return res;
	}
	
	/**
	 * Basic switch case which interchanges basic value for hex format.
	 * @param {int } value integer 0-15 inclusive
	 * @return {String} hex representation of value 
	 */
	private String toHex(int value) {
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
