# hex-decimal-converter
Basic and simple project for fun. Has two functions:
  1. convert decimal values to hex values (works for negative decimal values by treating them as unsigned numbers). 
  2. convert hex values to decimal values.

TODOs
-------------------
* Set up some type of GUI for the user to interact with.
* Change all integers to longs.
  * The conversion process is kind of messy since it works with both longs and ints, maybe just settle for 64 bit conversions.

Directory Structure
-------------------
The directory structure is as follows

	hex-to-decimal-converter
		|--- src:                                           Source files for project
		    |
		    |--- conversionTools:                           Houses the conversion classes
		         |--- DecimalToHexConverter.java            Converts from decimal values to hex values
		         |--- hexEnum.java                          Helps map from hex values to decimal values  
		         |--- HexToDecimalConverter.java            Converts from hex values to decimal values
		    |--- main:                                      Houses files which runs the program
		        |--- app.java                               Start point for the project



