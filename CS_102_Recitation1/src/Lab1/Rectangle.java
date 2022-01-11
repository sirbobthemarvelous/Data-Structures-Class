package Lab1;

public class Rectangle {
	private int width;
	private int length;
	
	public Rectangle() {
		width = 1;
		length = 1;
	}
	public Rectangle(int w, int l) {
		width = w;
		length = l;
	}
	
	public int getWidth() {
		return width;
	}
	public int getLength() {
		return length;
	}
	public void setWidth(int w) {
		width = w;
	}
	public void setLength(int l) {
		length = l;
	}
	//remember to print out the result 10 times
	public int getArea() {
		for(int i = 0; i<10;i++) {
			System.out.println("The Result is: "+width*length);
		}
		return width*length;
	}
	public boolean isSquare() {
		if(width == length) {
			return true;
		}
		return false;
	}
}
