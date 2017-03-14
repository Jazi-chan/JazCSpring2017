package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] spreadsheet;
	
	public Spreadsheet(){
		spreadsheet = new Cell[12][20];
		for(int i = 0; i < 12; i++){
			for (int j = 0; j < 20; j++){
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		if (command.length() == 0){
			return "";
		}
		String [] words = command.split(" ",3);
	//clear cells
		if(words[0].equalsIgnoreCase("clear")){
			clearCells(words);
			return getGridText();
		}
	//set cell values
		if (words.length>2){
			if (words[1].equals("=")){
				setCell(words);
				return getGridText();
			}
		}
	//inspect cells
		SpreadsheetLocation inspectIt = new SpreadsheetLocation(words[0]);
		return getCell(inspectIt).fullCellText();
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{		
		return spreadsheet[loc.getCol()][loc.getRow()];
	}

	@Override
	public String getGridText()
	{
		String topline = "   |";
		for (char alphabet = 'A'; alphabet <= 'L'; alphabet++){
			topline = topline+alphabet+"         |";
		}
		String gridtext = "\n";
		for(int i = 0; i< spreadsheet[0].length; i++){
			gridtext = gridtext+(i+1);
			if(i+1<10){
				gridtext=gridtext+"  |";
			}
			else{
				gridtext=gridtext+" |";
			}
			for(int j = 0; j< spreadsheet.length; j++){
				gridtext=gridtext+spreadsheet[j][i].abbreviatedCellText()+"|";
			}
			gridtext=gridtext+"\n";
		}
		String fulltext = topline + gridtext;
		return fulltext;
	}
	
	public void clearCells(String[] clear){
		if(clear.length == 2){
			SpreadsheetLocation clearcell = new SpreadsheetLocation(clear[1]);
			spreadsheet[clearcell.getCol()][clearcell.getRow()] = new EmptyCell();
		}
		else{
			for(int i = 0; i < 12; i++){
				for (int j = 0; j < 20; j++){
					spreadsheet[i][j] = new EmptyCell();
				}
			}
		}
		return;
	}
	
	public void setCell(String[] values){
		//this doesn't work for formula cells!!! It should handle everything though
		SpreadsheetLocation cell = new SpreadsheetLocation(values[0]);
		String cellValue = values[2];
		if(cellValue.indexOf("\"")>=0){		
			cellValue = cellValue.substring(1, cellValue.length()-1);
			spreadsheet[cell.getCol()][cell.getRow()] = new TextCell(cellValue);
		}
		else if(cellValue.indexOf("%")>=0){
			spreadsheet[cell.getCol()][cell.getRow()] = new PercentCell(cellValue.substring(0,cellValue.length()-2));
		}
		else if(cellValue.indexOf("(")>=0){
			//put FormulaCell here!!!
		}
		else{
			spreadsheet[cell.getCol()][cell.getRow()] = new ValueCell(cellValue);
		}
		return;
	}

}
