/** Author: Collin Edwards
 * Class: MIST352-Fall23
 * HW#1
 * This program will prompt the user to enter in their own values whether they be decimal numbers or whole numbers and it will solve them.
 */
import javax.swing.JOptionPane;
public class HW1B {

	public static void main(String[] args) {
		System.out.println("it be like that sometimes");
		//for lines 10-16 I consulted with the chapter 2 powerpoint(slides 105-111) about converting strings to a number
		String input1 = JOptionPane.showInputDialog("Enter value for num1");
		
		float num1 = Float.parseFloat(input1);
		
		String input2 = JOptionPane.showInputDialog("Enter value for num2:");
		
        double num2 = Double.parseDouble(input2);
		
		char letter = 'A';
		
			double sum = num1 + num2 ;
			
		System.out.println("Sum: " + sum);
	}

}
