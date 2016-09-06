package main;
import java.util.Scanner;

import conversionTools.DecimalToHexConverter;
import conversionTools.HexToDecimalConverter;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HexToDecimalConverter hexToDecimal = new HexToDecimalConverter();
		DecimalToHexConverter decimalToHex = new DecimalToHexConverter();
		Scanner console = new Scanner(System.in);
		
		// TODO: Look into best way to split between conversion methods on the fly/ during runtime
		/*int conversionChoice;
		System.out.print("Would you like (1) HexToDecimalConversion or (2) DecimalToHex conversion? ");
		if(conversionChoice == 1) {
			
		} else {
			
		}*/
		
		/*System.out.print("Hex ");
		String hex = console.nextLine();
		while(!hex.equalsIgnoreCase("exit")) {
			System.out.printf("Decimal: %d\n", hexToDecimal.hexToDecimal(hex));
			System.out.print("Hex ");
			hex = console.nextLine();
		}
		
		System.out.print("Decimal ");
		String input = console.nextLine();
		int decimal;
		while(!input.equalsIgnoreCase("exit")) {
			decimal = Integer.parseInt(input);
			System.out.printf("Hex: %s\n", decimalToHex.decimalToHex(decimal));
			System.out.print("Decimal ");
			input = console.nextLine();
		}*/
	}

}
