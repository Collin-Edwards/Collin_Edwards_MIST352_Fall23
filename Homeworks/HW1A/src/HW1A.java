/**Author: Collin Edwards
 *Class:MIST352-Fall23
 * HW #1
 * This program prints out the word hi and adds num1 and num2 together
 */
// for line 7 the name of the class should reflect the class name. This is also a class header which is the beginning of a definition. so it should be HW1A instead of HW11.
public class HW1A {
	//line 9-18 is the body of the class. Line 9 is also the method header which marks the beginning of a method which will be the starting point of the application
	public static void main(String[] args) {
		//the reason line 11 contains a syntax error is because their is not a semicolon which marks the end of a statement. It will not correctly print out the word "Hi"
		System.out.println("Hi");
		//line 13 is assigning the integer 10 to the variable "num1"
		int num1 = 10;
		//line 15 is assigning a primitive data type to the variable "num2" that contains a floating point number with 15 digits of accuracy
		double num2 = 5.5;
		//line 17 is assigning the char data type which is only enclosed in a single quote which provides access to single characters.
		char letter = 'A';
		//line 19 generates a syntax error because the integer data type cannot contain decimal points or fractions, and the sum of num1 and num2 will give you a decimal number so you have to change it to a "float" or "double" data type.
		double sum = num1 + num2 ;
		//line 21 prints out the results of line 19
		System.out.println("Sum: " + sum);
	}
}
