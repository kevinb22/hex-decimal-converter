package conversionTools;

public enum hexEnum {
	A (10),
	B (11),
	C (12),
	D (13),
	E (14),
	F (15),
	a (10),
	b (11),
	c (12),
	d (13),
	e (14),
	f (15);
	
	private int decimal;
	
	/**
	 * Constructor assign decimal field of hexEnum.
	 * @param {int }decimal to be assigned to field.
	 */
	hexEnum(int decimal) {
		this.decimal = decimal;
	}
	
	/**
	 * @return {int} value of the corresponding hexEnum.
	 */
	int getDecimal () {
		return this.decimal;
	}
	
	/**
	 * Returns the decimal corresponding to the hex input.
	 * @param {String} c, input representing a hex string.
	 * @return {int} corresponding decimal value.
	 */
	public static int match (String c) {
		for (hexEnum h : hexEnum.values()) {
			if (h.toString().equals(c)) {
				return h.getDecimal();
			}
		}
		return -1;
	}
}
