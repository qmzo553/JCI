package Ch10.ThreeStackslnOneArray;

public class StackNode {
	
	int value;
	int backLink;
	
	StackNode(int value, int backLink){
		this.value = value;
		this.backLink = backLink;
	}
	
	@Override
	public String toString() {
		return value + "(back lingk : " + backLink + ")";
	}
}
