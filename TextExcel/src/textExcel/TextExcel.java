package textExcel;

import java.util.*;
import java.io.FileNotFoundException;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args) throws FileNotFoundException
	{
	    Scanner input = new Scanner(System.in);
	    Spreadsheet sheet = new Spreadsheet();
	    String userInput = input.nextLine();
	    while(!userInput.equalsIgnoreCase("quit")){
	    	System.out.println(sheet.processCommand(userInput));
	    	userInput = input.nextLine();
	    }
	}
}
