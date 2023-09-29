import javax.swing.JOptionPane;

/**								//**************************************************
 * 								//	Collin Edwards			28Sep23
 */								//	  						Exam1B		 		   *
								//	This program will display a welcome message, 		
 								//	ask you(the user) to input some text, and the  *
								//	program will print out the length of the text 								
								//	you inputed. After that the program will ask   *
								//	you to find a specific character in that input.											   
								//	Next the program will then print out the area  *
								//	of the first occurrence of that character												
								//**************************************************

public class Exam1B {
/**
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	// printing out that welcome message
System.out.println("Greetings big dawg, I'm going to ask you for some things.\n");
	//telling the user to only input text and no number on the next line so it's easier to read
System.out.println("Please put only text, no numbers please");
	//using the go to JOptionPane since it looks more engaging and prompting the user to enter in long text
String CookedInput = JOptionPane.showInputDialog("Enter any text bud (hint:make it long)");
	// defining the variable length as an integer and then telling it to give me the length of whatever text the user entered
int length = CookedInput.length();
	// telling the program to print out a message to show the user how long the text they just entered was
JOptionPane.showMessageDialog(null, "bud the length of the text you just inputed was " + length +"." + " sheesh!");
	// asking the user to give the program a character to find out of the input they just gave
String CookedInput2 = JOptionPane.showInputDialog("i want you to give me a character to find in an input(just 1 my guy!)");
char ThisIsACharacterToFind = CookedInput2.charAt(0);
	// having the program find and display the first occurrence of that character. then telling the program to display the message where it occurs at
int index = CookedInput.indexOf(ThisIsACharacterToFind);
JOptionPane.showMessageDialog(null, "The character '" + ThisIsACharacterToFind + "' first occurs at index " + index + " in the input you recently put in my guy.");
System.out.println("\nthanks for playing with my program big dawg :)");


	}

}
