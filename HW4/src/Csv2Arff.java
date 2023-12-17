import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 * This class allows you to convert a csv file to arff file.
 * @author Collin Edwards
 * MIST 352 
 */

public class Csv2Arff {
	private String csvFileLocation;
	
	/**
	 * Keep as is. 
	 * Constructor.
	 * @param Location
	 */
	public Csv2Arff(String Location)
	{
		csvFileLocation=Location;
	}
	
	/**
	 * You need to code this
	 * This method accepts a name of a csv file and it writes an arff file from the csv file
	 * Writing arff file is similar to writing any .txt file. Just make sure the arff file name ends with .arff
	 * @param theLocation: The name and location of any csv file
	 * @throws IOException 
	 */
	public void Convert2Arff() throws IOException {
	    String arffFileName = csvFileLocation.replace(".csv", ".arff");  		// here is where the meat and potatoes starts. replacing the file extension format from csv to arff

	    Scanner scanner = new Scanner(new File(csvFileLocation));  				// starting the  scanner for reading csv file
	    PrintWriter pw = new PrintWriter(new FileWriter(arffFileName));  		// starting the printwriter for writing arff file

	    pw.println("@relation " + extractRelationName(csvFileLocation));  		// writing the  arff header with relation name in quotes
	  

	    pw.println("@data");  				// starting with the data section in each arff file
	    while (scanner.hasNextLine()) {
	        String line = scanner.nextLine(); 		 // here we're reading each line from csv file
	
	        line = line.replace(",", ", ");  				// formatting and adding space after the commas
	        pw.println(line); 				 // writing the line to the arff file
	    }

	    scanner.close();  // here im closing the scanner
	    pw.close();  // closing the print writer as well

	    System.out.println("ARFF file created: " + arffFileName);  // print out the confirmation message
	}

	/**
	 * extracts the base name of a file from a file path, removes the .csv extension
	 * @param theLocation the path to the .csv file
	 * @return base name of the file without .csv extension
	 */
	private String extractRelationName(String theLocation) {
	    File f = new File(theLocation);  						// creating the file object from file path
	    return f.getName().replace(".csv", "");  				// returns the file name without .csv extension
	}

	


	
	/**
	 * This method should red the text file to a two dimensional array of Strings.
	 * This method should return the data given in a specific row and column in the two dimensional array
	 * @param theFile: name of the csv file to open 
	 * @param row: row number in the two dimensional array
	 * @param column: column number in the two dimensional array
	 * @return strData2Return: the data in the [column][row]
	 * @throws FileNotFoundException 
	 */
	
	public static String RetrieveCell(String theFile, int row, int column) throws FileNotFoundException {
	    
	    List<String[]> data = new ArrayList<>();	// create a list to store rows of data; each row is an array of strings

	
	    Scanner scanner = new Scanner(new File(theFile));  // starting the scanner to read the file

	 
	    while (scanner.hasNextLine()) {		 // reading the file line by line
	       
	        String line = scanner.nextLine();	 // it's going to get the next line from the file
	     
	        String[] rowData = line.split(",");	 // essentially this split the line into separate elements based on commas
	        
	        data.add(rowData);	// adds the array of strings (i.e., the row) to the list
	    }

	  
	    scanner.close();   // closing the scanner since it's not needed anymore 

	    
	    if (row < data.size() && column < data.get(row).length) {					// check if the requested row and column are within the bounds of the data
	      
	        return data.get(row)[column];					  // return the data at the specified row and column
	    } else {											 // informs if the row or column is out of the data range and return an empty string
	       
	        System.out.println("row or column out of bounds"); // you know this just prints the message if the above parameters are met 
	        return "";
	    }
	}




	}


