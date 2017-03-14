package textExcel;

public class PercentCell extends RealCell implements Cell {

	private String fullCell;
	private double doubleValue;
	
	@Override
	public String abbreviatedCellText() {
		String abbText = fullCell;
		while(abbText.length()<9){
			abbText = abbText+" ";
		}
		return (abbText.substring(0, 8)+"%");
	}

	@Override
	public String fullCellText() {
		return (doubleValue+"");
	}
	
	public PercentCell(String value){
		super(value);
		doubleValue = doubleValue/100.0;
	}

}
