package textExcel;

public class TextCell implements Cell {

	private String text;
	
	public TextCell(String str){
		text=str;
	}
	
	@Override
	public String abbreviatedCellText() {
		String abbText = text;
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
		return "\""+text+"\"";
	}

}