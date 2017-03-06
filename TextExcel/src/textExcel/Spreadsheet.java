package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] spreadsheet;
	
	public Spreadsheet(){
		Cell[][] spreadsheet = new Cell[12][20];
		for(int i = 0; i < 12; i++){
			for (int j = 0; j < 20; j++){
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		String [] words = command.split(" ");
	//clear cells
		if(words[0].equals("clear")){
			if(words.length == 2){
				SpreadsheetLocation clearcell = new SpreadsheetLocation(words[1]);
				spreadsheet[clearcell.getRow()][clearcell.getCol()] = new EmptyCell();
			}
			else{
				for(int i = 0; i < 12; i++){
					for (int j = 0; j < 20; j++){
						spreadsheet[i][j] = new EmptyCell();
					}
				}
			}
			return getGridText();
		}
	//set cell values
		if (words.length==3){
			if (words[1].equals("=")){
				//this only works for text cells!!!!!!
				//you're going to have to fix it later for real cells!!!!!
				SpreadsheetLocation textcell = new SpreadsheetLocation(words[1]);
				spreadsheet[textcell.getRow()][textcell.getCol()] = new TextCell(words[2]);
				return getGridText();
			}
		}
		
		return "";
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
		// TODO Auto-generated method stub
		return null;
	}

}
