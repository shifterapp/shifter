package byrjun.model;

public class ShirtSizes {
	String sizeType;
	int count;	
	
	public ShirtSizes(String sizeType, int count){
		this.sizeType = sizeType;
		this.count = count;
	}
	
	public String getSizeType() {
		return sizeType;
	}
	
	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}	
}
