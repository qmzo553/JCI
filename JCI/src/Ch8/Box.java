package Ch8;

public class Box {
	
	private final int width;
	private final int height;
	private final int color;
	
	public Box(int width, int height, int color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public boolean canBeNext(Box box) {
		
		if(box == null) {
			return false;
		}
		
		return((box.width > this.width) && (box.height > this.height) && (box.color != this.color));
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		return "Box{" + "width=" + width + ", height=" + height + ", color=" + color + '}';
	}
}
