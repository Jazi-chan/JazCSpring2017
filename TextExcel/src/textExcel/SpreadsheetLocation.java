package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int column;
	
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	if(cellName.charAt(0) > 96){
    		column = cellName.charAt(0)-97;
    	}
    	else{
    		column = cellName.charAt(0)-65;
    	}      
        row = Integer.parseInt(cellName.substring(1))-1;
    }

}
