package textExcel;

public class ValueCell extends RealCell implements Cell {

	private String fullCell;
	private double doubleValue;
	private String abbText;
	
	public ValueCell(String value){
		super(value);
		fullCell = value;
		//make abbreviated cell text
		String abbText = value;
		while(abbText.length()<=10){
			abbText = abbText + " ";
		}
		//make decimal value
		if  (value.indexOf(".")>=0){
			String [] parts = value.split(".");
			if(parts.length>1){
				int whole = Integer.parseInt(parts[0]);
				int decimal = Integer.parseInt(parts[1]);
				double dec = (double) decimal;
				while(dec>=1){
					dec = dec/10;
				}
				doubleValue = (double) whole + dec;
			}
		}
		else{
			doubleValue = (double) Integer.parseInt(value);
		}
	}
	
	@Override
	public String abbreviatedCellText() {
		int length = abbText.length();
		if(length<=10){
			abbText = abbText + " ";
		}
		return abbText.substring(0, 9);
	}

	@Override
	public String fullCellText() {
		return ("\""+fullCell+"\"");
	}
	
	public double getDoubleValue(){
		return doubleValue;
	}

	
}
