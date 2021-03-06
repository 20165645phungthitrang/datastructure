package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CircleK extends Circle implements Comparable<CircleK>{
	private Integer number;
	private Text text;
	private Integer x;
	private Integer y;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
	
	public CircleK() {
		super();
	}
	
	
	public CircleK(Integer layoutX, Integer layoutY) {
		super();
		this.x = layoutX;
		this.y = layoutY;
		this.setFill(Color.GREEN);
		this.setStroke(Color.BLUE);
		this.setStrokeWidth(3);
		this.setRadius(30);
		
		//this.text = new Text(number.toString());
		//text.setStroke(Color.BLACK);
	}
	
	public CircleK(String str, Integer layoutX, Integer layoutY) {
		super();
		this.x = layoutX;
		this.y = layoutY;
		this.setFill(Color.GREEN);
		this.setStroke(Color.BLUE);
		this.setStrokeWidth(3);
		this.setRadius(30);
		
		this.text = new Text(str);
		text.setStroke(Color.BLACK);
	}
	
	
	public CircleK(Integer number, Integer layoutX, Integer layoutY) {
		super();
		this.number = number;
		this.x = layoutX;
		this.y = layoutY;
		this.setFill(Color.GREEN);
		this.setStroke(Color.BLUE);
		this.setStrokeWidth(3);
		this.setRadius(30);
		
		this.text = new Text(number.toString());
		text.setStroke(Color.BLACK);
	}
	
	public void changeBackGround(Color color) {
		this.setFill(color);
	}
	
	
	
	public void delete() {
		this.setFill(null);
		this.setStroke(null);
		this.text.setVisible(false);
	}
	
	public void delete( Integer layoutX, Integer layoutY) {
		this.setFill(null);
		this.setStroke(null);
		this.text.setVisible(false);
	}
	
	
	
	@Override
	public int compareTo(CircleK circleK) {
		
		return this.getNumber()<circleK.getNumber()?1:-1;
	}
	
	
}
