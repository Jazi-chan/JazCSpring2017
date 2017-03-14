package textExcel;

public abstract class RealCell implements Cell {

	private String fullCell;
	private double doubleValue;
	private String abbText;
	
	@Override
	public String abbreviatedCellText() {
		return abbText.substring(0, 9);
	}

	@Override
	public String fullCellText() {
		return ("\""+fullCell+"\"");
	}
	
	public double getDoubleValue(){
		return doubleValue;
	}
	
	public RealCell(String value){
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

}
