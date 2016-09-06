package conversionTools;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HexToDecimalConverter {	
	/**
	 * Convert a hexadecimal string into a decimal number, throws an exception
	 * if the input was unable to be converted.
	 * @param {string} hex, string representation of hexadecimal number
	 * @return {long} decimal counterpart of the hexadecimal number
	 */
	public long hexToDecimal(String hex) {
		long ret = 0;
		for(int i = hex.length() -1 ; i >= 0; i--) {
			String digit = Character.toString(hex.charAt(i));
			int tmp = convertDigit(digit);
			if (tmp == -1) {
				throw new IllegalArgumentException("Illegal Argument: <non-hex-value>");
			}
			ret += (tmp * Math.pow(16,hex.length() - i - 1));
		}
		return ret;
	}
	
	/**
	 * Convert a hex digit into its decimal counterpart
	 * @param {string} c, string representation of the hex digit 
	 * @return {int} decimal counterpart of the parameter, returns
	 * -1 if digit is unable to be converted. 
	 */
	private int convertDigit(String c) {
		String digitMatch = "\\d";
		String charMatch = "[abcdefABCDEF]";
		Pattern num = Pattern.compile(digitMatch);
		Pattern alph = Pattern.compile(charMatch);
		
		if (num.matcher(c).find( )) {
			return Integer.parseInt(c);
		} else if (alph.matcher(c).find( )) {
			return hexEnum.match(c);
		} else {
			return -1;
		}
	}
	
}
