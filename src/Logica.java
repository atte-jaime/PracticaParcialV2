import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

	private PApplet app;
	private PImage fondo;
	private Mensaje men;

	public Logica(PApplet app) {
		this.app = app;
		fondo = app.loadImage("imagen.png");
		men = new Mensaje(app, fondo);
		men.start();
	}

	public void ejecutar() {
		men.pintar();
	}



}
