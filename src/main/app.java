package main;
import java.util.Scanner;

import conversionTools.DecimalToHexConverter;
import conversionTools.HexToDecimalConverter;

public class app {

	public static void main(String[] args) {
		HexToDecimalConverter hexToDecimal = new HexToDecimalConverter();
		DecimalToHexConverter decimalToHex = new DecimalToHexConverter();
		Scanner console = new Scanner(System.in);
		
		System.out.print("Would you like (1) HexToDecimalConversion or (2) DecimalToHex conversion? ");
		String conversionChoice = console.nextLine();
		while (!conversionChoice.equalsIgnoreCase("q")) {
			if(conversionChoice.equals("1")) {
				convertHexToDecimal(console, hexToDecimal);
			} else if (conversionChoice.equals("2")) {
				convertDecimalToHex(console, decimalToHex);
			}
			System.out.print("Would you like (1) HexToDecimalConversion or (2) DecimalToHex conversion? ");
			conversionChoice = console.nextLine();
		}
	}
	
	/**
	 * Take in user input as hex values and convert to decimal values.
	 * @param {Scanner} console to take in values from stdin.
	 * @param {HexToDecimalConverter} hexToDecimal to convert from hex to decimal.
	 */
	public static void convertHexToDecimal(Scanner console, HexToDecimalConverter hexToDecimal) {
		System.out.print("Hex ");
		String hex = console.nextLine();
		while(!hex.equalsIgnoreCase("q")) {
			System.out.printf("Decimal: %d\n", hexToDecimal.hexToDecimal(hex));
			System.out.print("Hex ");
			hex = console.nextLine();
		}
	}
	
	/**
	 * Take in user input as decimal values and convert to hex values.
	 * @param {Scanner} console to take in values from stdin.
	 * @param {DecimalToHexConverter} decimalToHex to convert from decimal to hex.
	 */
	public static void convertDecimalToHex(Scanner console, DecimalToHexConverter decimalToHex) {
		System.out.print("Decimal ");
		String input = console.nextLine();
		int decimal;
		while(!input.equalsIgnoreCase("q")) {
			decimal = Integer.parseInt(input);
			System.out.printf("Hex: %s\n", decimalToHex.decimalToHex(decimal));
			System.out.print("Decimal ");
			input = console.nextLine();
		}
	}
	
}
