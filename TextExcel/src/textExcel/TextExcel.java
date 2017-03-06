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
	    while(!userInput.equals("quit"));{
	    	if(!userInput.equals("quit")){
	    		System.out.println(sheet.processCommand(userInput));
	    		userInput = input.nextLine();
	    	}
	    }
	    System.out.println("Thank you for using Spreadsheet!");
	}
}
