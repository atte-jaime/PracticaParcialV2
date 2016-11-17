import processing.core.PApplet;
import processing.core.PImage;

public class Mensaje extends Thread {

	private PApplet app;
	private PImage fondo;
	private PImage men;
	private int tiempo = 0;
	private int mensaje;

	public Mensaje(PApplet app, PImage image) {
		this.app = app;
		fondo = image;
		men = app.createImage(fondo.width, fondo.height, fondo.format);
	}

	public void run() {
		while (true) {
			tiempo++;

			if (tiempo == 5) {
				tiempo = 0;
				mensaje++;
				if(mensaje==2){
					mensaje=0;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pintar() {
		switch (mensaje) {
		case 0:
			app.image(fondo, 0, 0);
			break;

		case 1:
			primerMensaje();
			break;

		}
	}

	private void primerMensaje() {
		letras(fondo, men, 255, 30, 0);
		letras(fondo, men,180,30,0);
		letras(fondo, men,200,180,0);
		letras(fondo, men,200,80,0);
		fondo(fondo, men,255, 180, 0);
		fondo(fondo, men,180,100,0);
		fondo(fondo, men,200,20,0);
		fondo(fondo, men,100,120,0);
		app.image(men, 0, 0);
	}

	private void fondo(PImage ref, PImage edit, float r, float g, float b) {
		edit.loadPixels();
		for (int x = 0; x < ref.width; x++) {
			for (int y = 0; y < ref.height; y++) {
				int loc = x + y * ref.width;
				if (ref.pixels[loc] == app.color(r, g, b)) {
					edit.pixels[loc] = app.color(255);
				}
			}
		}
		edit.updatePixels();
	}

	private void letras(PImage ref, PImage edit, float r, float g, float b) {
		edit.loadPixels();
		for (int x = 0; x < ref.width; x++) {
			for (int y = 0; y < ref.height; y++) {
				int loc = x + y * ref.width;
				if (ref.pixels[loc] == app.color(r, g, b)) {
					edit.pixels[loc] = app.color(0);
				}
			}
		}
		edit.updatePixels();
	}

}
