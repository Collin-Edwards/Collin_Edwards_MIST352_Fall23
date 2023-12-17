import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 */

/**
 * @author Collin Edwards
 * MIST 352-001 Business Application Programming
 * HW3
 * I used ChatGPT to the print array section
 * This is the prompt I used, and I will also be attaching screenshots for my submission.
 */
@SuppressWarnings("unused")
public class HW4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//***********************************************************************************************
		// Keep lines 21 - 27 as is
        //Location of the data folder which has all csv files
		// Set the path to the directory containing the CSV files
		String directoryPath = "src/Data"; 

		// Find all CSV file names in the specified directory and store them in an array
		String[] csvFileNames = findCSVFileNames(new File(directoryPath));

		// Print the names of the CSV files as retrieved from the directory
		PrintArray(csvFileNames, "\n");  // print out the array of csv files

		// Iterate over the array of CSV file names
		for (int i = 0; i < csvFileNames.length; i++) {
		    // Append the directory path to each CSV file name for full path specification
		    csvFileNames[i] = directoryPath + "/" + csvFileNames[i];  // add directory to each filename
		}

		// Print the array of CSV file names again, this time with the directory path included
		PrintArray(csvFileNames, "\n");  // print the array again after adding directory

		// Iterate over the array of full path CSV file names
		for (String csvFileName : csvFileNames) {
		    try {
		        // Create a Csv2Arff object for each file to handle CSV to ARFF conversion
		        Csv2Arff converter = new Csv2Arff(csvFileName);

		        // Convert the current CSV file to an ARFF file
		        converter.Convert2Arff();  // convert csv to arff
		    } catch (IOException e) {
		        // If an IOException occurs during conversion, print an error message and stack trace
		        System.out.println("Error converting file: " + csvFileName);
		        e.printStackTrace();
		    }
		}

		// Initialize a Scanner object for reading input from the user
		Scanner scanner = new Scanner(System.in);  // user interaction for specific cell data

		// Prompt the user to enter the name of the file including its path
		System.out.println("Enter the name of the file (including path):");
		String fileName = scanner.nextLine();

		// Prompt the user to enter the column number for data retrieval
		System.out.println("Enter the column number:");
		int column = scanner.nextInt();

		// Prompt the user to enter the row number for data retrieval
		System.out.println("Enter the row number:");
		int row = scanner.nextInt();

		try {
		    // Retrieve and display the data from the specified cell in the CSV file
		    String cellData = Csv2Arff.RetrieveCell(fileName, row, column);  // retrieve and display cell data
		    System.out.println("Data at [" + row + "][" + column + "]: " + cellData);
		} catch (IOException e) {
		    // If an IOException occurs during data retrieval, print an error message and stack trace
		    System.out.println("Error retrieving data from file: " + fileName);  // displaying this message
		    e.printStackTrace();
		}

		// Close the scanner to prevent resource leaks
		scanner.close();  // closing the scanner

	    }
    //***********************************************************************************************
        //to do:
        	// 1. print out the array of csv files
        	// 2. access the array csvFileNames add the directory to each file name. So, the file Ant1.csv should become src/Data/Ant1.csv       	
        	// 3. print out the array of csv files again after adding directory to each
        	// 4. Go through the array again (using while / for loop), every time you access a cell, create an object of type Csv2Arff.
        	// 5. Call the proper method to write the arff file for the current csv file in the loop.
        	// 6. Ask use for name of a file to look in, and then column number and row number.
        		// 6.1 Printout the value from that file.
               
    
	/**
	 *  You need to code this
	 *  This method simply prints out the content of any given String array
	 * @param array: The array to print
	 */
	public static void PrintArray(String[] array, String delimiter)
	{
		/**
		 * Prints each element of a given String array to the console.
		 * If the array is empty or null, it informs the user.
		 *
		 * @param array The array of strings to be printed.
		 * @param delimiter A string delimiter to separate array elements in the output.
		 *                  If null or empty, newline is used by default.
		 */
		
		    // Check if the delimiter is not given or empty, set it to newline character
		    String effectiveDelimiter = (delimiter == null || delimiter.isEmpty()) ? "\n" : delimiter;

		    // Check if the array is not null to prevent NullPointerException
		    if (array != null) {
		        // Check if the array has elements to prevent printing unnecessary delimiters
		        if (array.length > 0) {
		            // Initialize a StringBuilder for efficient string concatenation
		            StringBuilder output = new StringBuilder();

		            // Iterate through all elements of the array except the last one
		            for (int i = 0; i < array.length - 1; i++) {
		                // Append the current element and the delimiter to the output
		                output.append(array[i]).append(effectiveDelimiter);
		            }

		            // Append the last element to avoid trailing delimiter
		            output.append(array[array.length - 1]);

		            // Print the constructed string to the console
		            System.out.println(output.toString());
		        } else {
		            // Inform the user that the array is empty
		            System.out.println("The array is empty. No elements to print.");
		        }
		    } else {
		        // Inform the user that the array is null
		        System.out.println("The array is null. Cannot print elements.");
		    }
		}

	
	

	/**
	 * Keep as is.
	 * This method finds all csv files in a given directory
	 * @param directory: location of all csv files. This is passed from the main
	 * @return: Array of strings, each strring represents the name the location of a csv file
	 */
    private static String[] findCSVFileNames(File directory) {
        List<String> csvFileNames = new ArrayList<>();
        addCSVFileNames(directory, csvFileNames);
        return csvFileNames.toArray((new String[0]));
    }

    /**
     * Keep as is.
     * This method is magical. We Do not care what it does.
     * @param directory
     * @param csvFileNames
     */
    private static void addCSVFileNames(File directory, List<String> csvFileNames) {
        if (directory.isDirectory()) {
            // Define a filter for CSV files
            FilenameFilter csvFilter = (dir, name) -> name.toLowerCase().endsWith(".csv");

            // List all CSV files in the current directory
            File[] files = directory.listFiles(csvFilter);
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        csvFileNames.add(file.getName());
                    }
                }
            }

            // List all directories in the current directory
            File[] dirs = directory.listFiles(File::isDirectory);
            if (dirs != null) {
                for (File dir : dirs) {
                    addCSVFileNames(dir, csvFileNames); // Recursive call
                }
            }
        }
    }}


	


