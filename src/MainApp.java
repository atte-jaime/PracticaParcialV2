import processing.core.PApplet;

public class MainApp extends PApplet{

	public static void main(String[] args) {
		MainApp.main("MainApp");
	}
	
	Logica app;
	
	public void settings(){
		size(1020,180);
	}
	
	public void setup(){
		app = new Logica(this);
	}
	
	public void draw(){
		background(255);
		app.ejecutar();
	}
	

}
