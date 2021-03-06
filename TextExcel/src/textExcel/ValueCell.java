package textExcel;

public class ValueCell extends RealCell implements Cell {

	private String fullCell;
	private double doubleValue;
	
	public ValueCell(String value){
		super(value);
		fullCell = super.fullCellText();
		if(fullCell.indexOf(".")>=0&&fullCell.endsWith("00")){
			while (fullCell.endsWith("00")){
				fullCell=fullCell.substring(0, fullCell.length()-1);
			}
			if(Character.isDigit(fullCell.charAt(fullCell.length()-2))){
				fullCell = fullCell.substring(0, fullCell.length()-1);
			}
		}
		doubleValue = Double.parseDouble(value);
	}
	
	@Override
	public String abbreviatedCellText() {
		String abbText = fullCell;
		if(abbText.length()<=8 && abbText.indexOf(".")<0){
			abbText = abbText + ".0";
		}
		while(abbText.length()<10){
			abbText = abbText + " ";
		}
		if(abbText.length()>10){
			abbText = abbText.substring(0, 10);
		}
		return abbText;
	}

	@Override
	public String fullCellText() {
		return (fullCell+"");
	}
	
	public double getDoubleValue(){
		return doubleValue;
	}

	
}
