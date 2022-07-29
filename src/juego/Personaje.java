package juego;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Personaje {

	private double x;
	private double y;
	private double ancho;
	private double alto;
	private Image mikasaFrente1 = Herramientas.cargarImagen("imagenesMikasaNormal/frente1.png");
	private Image mikasaFrente2 = Herramientas.cargarImagen("imagenesMikasaNormal/frente2.png");
	private Image mikasaFrente3 = Herramientas.cargarImagen("imagenesMikasaNormal/frente3.png");
	private Image mikasaIzquierda1 = Herramientas.cargarImagen("imagenesMikasaNormal/left1.png");
	private Image mikasaIzquierda2 = Herramientas.cargarImagen("imagenesMikasaNormal/left2.png");
	private Image mikasaIzquierda3 = Herramientas.cargarImagen("imagenesMikasaNormal/left3.png");
	private Image mikasaDerecha1 = Herramientas.cargarImagen("imagenesMikasaNormal/right1.png");
	private Image mikasaDerecha2 = Herramientas.cargarImagen("imagenesMikasaNormal/right2.png");
	private Image mikasaDerecha3 = Herramientas.cargarImagen("imagenesMikasaNormal/right3.png");
	private Image mikasaEspaldas1 = Herramientas.cargarImagen("imagenesMikasaNormal/back1.png");
	private Image mikasaEspaldas2 = Herramientas.cargarImagen("imagenesMikasaNormal/back2.png");
	private Image mikasaEspaldas3 = Herramientas.cargarImagen("imagenesMikasaNormal/back3.png");
	private Image mikasaTitanFrente1 = Herramientas.cargarImagen("imagenesMikasaTitan/frente1.png");
	private Image mikasaTitanFrente2 = Herramientas.cargarImagen("imagenesMikasaTitan/frente2.png");
	private Image mikasaTitanFrente3 = Herramientas.cargarImagen("imagenesMikasaTitan/frente3.png");
	private Image mikasaTitanIzquierda1 = Herramientas.cargarImagen("imagenesMikasaTitan/left1.png");
	private Image mikasaTitanIzquierda2 = Herramientas.cargarImagen("imagenesMikasaTitan/left2.png");
	private Image mikasaTitanIzquierda3 = Herramientas.cargarImagen("imagenesMikasaTitan/left3.png");
	private Image mikasaTitanDerecha1 = Herramientas.cargarImagen("imagenesMikasaTitan/right1.png");
	private Image mikasaTitanDerecha2 = Herramientas.cargarImagen("imagenesMikasaTitan/right2.png");
	private Image mikasaTitanDerecha3 = Herramientas.cargarImagen("imagenesMikasaTitan/right3.png");
	private Image mikasaTitanEspaldas1 = Herramientas.cargarImagen("imagenesMikasaTitan/back1.png");
	private Image mikasaTitanEspaldas2 = Herramientas.cargarImagen("imagenesMikasaTitan/back2.png");
	private Image mikasaTitanEspaldas3 = Herramientas.cargarImagen("imagenesMikasaTitan/back3.png");
	private Image vidas5 = Herramientas.cargarImagen("imagenes/vidas5.png");
	private Image vidas4 = Herramientas.cargarImagen("imagenes/vidas4.png");
	private Image vidas3 = Herramientas.cargarImagen("imagenes/vidas3.png");
	private Image vidas2 = Herramientas.cargarImagen("imagenes/vidas2.png");
	private Image vidas1 = Herramientas.cargarImagen("imagenes/vidas1.png");
	private Image vidaActual = vidas5;
	private Image spriteActual = mikasaFrente2;
	private double orientacion;
	private double velocidad;
	private double escala;
	private boolean mikasaTitan;
	private int vidas;

	public Personaje(double x, double y, double ancho, double alto, double orientacion, 
			double velocidad, double escala, boolean mikasaTitan, int vidas) {

		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.orientacion = orientacion;
		this.velocidad = velocidad;
		this.escala = escala;
		this.mikasaTitan = mikasaTitan;
		this.vidas = vidas;
	}

	void Imagen(Image imagen) {
		spriteActual = imagen;
	}

	void dibujarPersonaje(Entorno entorno) {

		Color color = new Color(0, 0, 255, 0);
		entorno.dibujarImagen(spriteActual, this.x, this.y, 0, this.escala);
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, color);

	}

	void dibujarVidas(Entorno entorno) {
		if (this.getVidas() == 5)
			this.vidaActual = this.vidas5;
		if (this.getVidas() == 4)
			this.vidaActual = this.vidas4;
		if (this.getVidas() == 3)
			this.vidaActual = this.vidas3;
		if (this.getVidas() == 2)
			this.vidaActual = this.vidas2;
		if (this.getVidas() == 1)
			this.vidaActual = this.vidas1;
		entorno.dibujarImagen(vidaActual, 205, 760, 0, 0.8);
	}

	void girarIzquierda() {

		this.orientacion -= 1;
		miOrientacion();
	}

	void girarDerecha() {

		this.orientacion += 1;
		miOrientacion();
	}

	void miOrientacion() {

		if (this.orientacion == 0 & this.getMikasaTitan() == false)
			spriteActual = mikasaFrente1;

		if (this.orientacion == 0 & this.getMikasaTitan() == true)
			spriteActual = mikasaTitanFrente1;

		if (this.orientacion == -1)
			this.orientacion = 3;

		if (this.orientacion == -2)
			this.orientacion = 2;

		if (this.orientacion == -3)
			this.orientacion = 1;

		if (this.orientacion == -4 & this.getMikasaTitan() == false) {
			this.orientacion = 0;
			spriteActual = mikasaFrente1;
		}

		if (this.orientacion == -4 & this.getMikasaTitan() == true) {
			this.orientacion = 0;
			spriteActual = mikasaTitanFrente1;
		}

		if (this.orientacion == 1 & this.getMikasaTitan() == false)
			spriteActual = mikasaIzquierda1;

		if (this.orientacion == 2 & this.getMikasaTitan() == false)
			spriteActual = mikasaEspaldas1;

		if (this.orientacion == 3 & this.getMikasaTitan() == false)
			spriteActual = mikasaDerecha1;

		if (this.orientacion == 1 & this.getMikasaTitan() == true)
			spriteActual = mikasaTitanIzquierda1;

		if (this.orientacion == 2 & this.getMikasaTitan() == true)
			spriteActual = mikasaTitanEspaldas1;

		if (this.orientacion == 3 & this.getMikasaTitan() == true)
			spriteActual = mikasaTitanDerecha1;

		if (this.orientacion == 4 & this.getMikasaTitan() == false) {
			this.orientacion = 0;
			spriteActual = mikasaFrente1;
		}

		if (this.orientacion == 4 & this.getMikasaTitan() == true) {
			this.orientacion = 0;
			spriteActual = mikasaTitanFrente1;
		}
	}

	void avanzar(double velocidad) {

		if (this.orientacion == 0)
			avanzarFrente(velocidad);

		if (this.orientacion == 1)
			avanzarIzquierda(velocidad);

		if (this.orientacion == 2)
			avanzarEspaldas(velocidad);

		if (this.orientacion == 3)
			avanzarDerecha(velocidad);
	}

	void retroceder(double velocidad) {

		if (this.orientacion == 0)
			retrocederFrente(velocidad);

		if (this.orientacion == -1)
			retrocederDerecha(velocidad);

		if (this.orientacion == -2)
			retrocederEspaldas(velocidad);

		if (this.orientacion == -3)
			retrocederIzquierda(velocidad);

		if (this.orientacion == 1)
			retrocederIzquierda(velocidad);

		if (this.orientacion == 2)
			retrocederEspaldas(velocidad);

		if (this.orientacion == 3)
			retrocederDerecha(velocidad);
	}

	void avanzarFrente(double velocidad) {
		this.y += velocidad;
		animacionFrente();
	}

	void avanzarIzquierda(double velocidad) {
		this.x -= velocidad;
		animacionIzquierda();
	}

	void avanzarEspaldas(double velocidad) {
		this.y -= velocidad;
		animacionEspaldas();
	}

	void avanzarDerecha(double velocidad) {
		this.x += velocidad;
		animacionDerecha();
	}

	void retrocederFrente(double velocidad) {
		this.y -= velocidad;
		animacionFrente();
	}

	void retrocederDerecha(double velocidad) {
		this.x -= velocidad;
		animacionDerecha();
	}

	void retrocederIzquierda(double velocidad) {
		this.x += velocidad;
		animacionIzquierda();
	}

	void retrocederEspaldas(double velocidad) {
		this.y += velocidad;
		animacionEspaldas();
	}

	void animacionFrente() {

		if (this.getMikasaTitan() == false) {

			if (this.y <= 40 && this.y >= 0)
				spriteActual = mikasaFrente1;
			else if (this.y <= 80 && this.y > 40)
				spriteActual = mikasaFrente2;
			else if (this.y <= 120 && this.y > 80)
				spriteActual = mikasaFrente3;
			else if (this.y <= 160 && this.y > 120)
				spriteActual = mikasaFrente2;
			else if (this.y <= 200 && this.y > 160)
				spriteActual = mikasaFrente1;
			else if (this.y <= 240 && this.y > 200)
				spriteActual = mikasaFrente2;
			else if (this.y <= 280 && this.y > 240)
				spriteActual = mikasaFrente3;
			else if (this.y <= 320 && this.y > 280)
				spriteActual = mikasaFrente2;
			else if (this.y <= 360 && this.y > 320)
				spriteActual = mikasaFrente1;
			else if (this.y <= 400 && this.y > 360)
				spriteActual = mikasaFrente2;
			else if (this.y <= 440 && this.y > 400)
				spriteActual = mikasaFrente3;
			else if (this.y <= 480 && this.y > 440)
				spriteActual = mikasaFrente2;
			else if (this.y <= 520 && this.y > 480)
				spriteActual = mikasaFrente1;
			else if (this.y <= 560 && this.y > 520)
				spriteActual = mikasaFrente2;
			else if (this.y <= 600 && this.y > 560)
				spriteActual = mikasaFrente3;
			else if (this.y <= 640 && this.y > 600)
				spriteActual = mikasaFrente2;
			else if (this.y <= 680 && this.y > 640)
				spriteActual = mikasaFrente1;
			else if (this.y <= 720 && this.y > 680)
				spriteActual = mikasaFrente2;
			else if (this.y <= 760 && this.y > 720)
				spriteActual = mikasaFrente3;
			else if (this.y <= 800 && this.y > 760)
				spriteActual = mikasaFrente2;
		}

		if (this.getMikasaTitan() == true) {

			if (this.y <= 40 && this.y >= 0)
				spriteActual = mikasaTitanFrente1;
			else if (this.y <= 80 && this.y > 40)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 120 && this.y > 80)
				spriteActual = mikasaTitanFrente3;
			else if (this.y <= 160 && this.y > 120)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 200 && this.y > 160)
				spriteActual = mikasaTitanFrente1;
			else if (this.y <= 240 && this.y > 200)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 280 && this.y > 240)
				spriteActual = mikasaTitanFrente3;
			else if (this.y <= 320 && this.y > 280)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 360 && this.y > 320)
				spriteActual = mikasaTitanFrente1;
			else if (this.y <= 400 && this.y > 360)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 440 && this.y > 400)
				spriteActual = mikasaTitanFrente3;
			else if (this.y <= 480 && this.y > 440)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 520 && this.y > 480)
				spriteActual = mikasaTitanFrente1;
			else if (this.y <= 560 && this.y > 520)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 600 && this.y > 560)
				spriteActual = mikasaTitanFrente3;
			else if (this.y <= 640 && this.y > 600)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 680 && this.y > 640)
				spriteActual = mikasaTitanFrente1;
			else if (this.y <= 720 && this.y > 680)
				spriteActual = mikasaTitanFrente2;
			else if (this.y <= 760 && this.y > 720)
				spriteActual = mikasaTitanFrente3;
			else if (this.y <= 800 && this.y > 760)
				spriteActual = mikasaTitanFrente2;
		}
	}

	void animacionDerecha() {

		if (this.getMikasaTitan() == false) {

			if (this.x <= 40 && this.x >= 0)
				spriteActual = mikasaDerecha1;
			else if (this.x <= 80 && this.x > 40)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 120 && this.x > 80)
				spriteActual = mikasaDerecha3;
			else if (this.x <= 160 && this.x > 120)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 200 && this.x > 160)
				spriteActual = mikasaDerecha1;
			else if (this.x <= 240 && this.x > 200)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 280 && this.x > 240)
				spriteActual = mikasaDerecha3;
			else if (this.x <= 320 && this.x > 280)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 360 && this.x > 320)
				spriteActual = mikasaDerecha1;
			else if (this.x <= 400 && this.x > 360)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 440 && this.x > 400)
				spriteActual = mikasaDerecha3;
			else if (this.x <= 480 && this.x > 440)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 520 && this.x > 480)
				spriteActual = mikasaDerecha1;
			else if (this.x <= 560 && this.x > 520)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 600 && this.x > 560)
				spriteActual = mikasaDerecha3;
			else if (this.x <= 640 && this.x > 600)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 680 && this.x > 640)
				spriteActual = mikasaDerecha3;
			else if (this.x <= 720 && this.x > 680)
				spriteActual = mikasaDerecha2;
			else if (this.x <= 760 && this.x > 720)
				spriteActual = mikasaDerecha1;
			else if (this.x <= 800 && this.x > 760)
				spriteActual = mikasaDerecha2;
		}

		if (this.getMikasaTitan() == true) {

			if (this.x <= 40 && this.x >= 0)
				spriteActual = mikasaTitanDerecha1;
			else if (this.x <= 80 && this.x > 40)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 120 && this.x > 80)
				spriteActual = mikasaTitanDerecha3;
			else if (this.x <= 160 && this.x > 120)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 200 && this.x > 160)
				spriteActual = mikasaTitanDerecha1;
			else if (this.x <= 240 && this.x > 200)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 280 && this.x > 240)
				spriteActual = mikasaTitanDerecha3;
			else if (this.x <= 320 && this.x > 280)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 360 && this.x > 320)
				spriteActual = mikasaTitanDerecha1;
			else if (this.x <= 400 && this.x > 360)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 440 && this.x > 400)
				spriteActual = mikasaTitanDerecha3;
			else if (this.x <= 480 && this.x > 440)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 520 && this.x > 480)
				spriteActual = mikasaTitanDerecha1;
			else if (this.x <= 560 && this.x > 520)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 600 && this.x > 560)
				spriteActual = mikasaTitanDerecha3;
			else if (this.x <= 640 && this.x > 600)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 680 && this.x > 640)
				spriteActual = mikasaTitanDerecha3;
			else if (this.x <= 720 && this.x > 680)
				spriteActual = mikasaTitanDerecha2;
			else if (this.x <= 760 && this.x > 720)
				spriteActual = mikasaTitanDerecha1;
			else if (this.x <= 800 && this.x > 760)
				spriteActual = mikasaTitanDerecha2;
		}
	}

	void animacionIzquierda() {

		if (this.getMikasaTitan() == false) {

			if (this.x <= 40 && this.x / 10 >= 0)
				spriteActual = mikasaIzquierda1;
			else if (this.x <= 80 && this.x > 40)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 120 && this.x > 80)
				spriteActual = mikasaIzquierda3;
			else if (this.x <= 160 && this.x > 120)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 200 && this.x > 160)
				spriteActual = mikasaIzquierda1;
			else if (this.x <= 240 && this.x > 200)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 280 && this.x > 240)
				spriteActual = mikasaIzquierda3;
			else if (this.x <= 320 && this.x > 280)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 360 && this.x > 320)
				spriteActual = mikasaIzquierda1;
			else if (this.x <= 400 && this.x > 360)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 440 && this.x > 400)
				spriteActual = mikasaIzquierda3;
			else if (this.x <= 480 && this.x > 440)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 520 && this.x > 480)
				spriteActual = mikasaIzquierda1;
			else if (this.x <= 560 && this.x > 520)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 600 && this.x > 560)
				spriteActual = mikasaIzquierda3;
			else if (this.x <= 640 && this.x > 600)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 680 && this.x > 640)
				spriteActual = mikasaIzquierda1;
			else if (this.x <= 720 && this.x > 680)
				spriteActual = mikasaIzquierda2;
			else if (this.x <= 760 && this.x > 720)
				spriteActual = mikasaIzquierda3;
			else if (this.x <= 800 && this.x > 760)
				spriteActual = mikasaIzquierda2;
		}

		if (this.getMikasaTitan() == true) {

			if (this.x <= 40 && this.x / 10 >= 0)
				spriteActual = mikasaTitanIzquierda1;
			else if (this.x <= 80 && this.x > 40)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 120 && this.x > 80)
				spriteActual = mikasaTitanIzquierda3;
			else if (this.x <= 160 && this.x > 120)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 200 && this.x > 160)
				spriteActual = mikasaTitanIzquierda1;
			else if (this.x <= 240 && this.x > 200)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 280 && this.x > 240)
				spriteActual = mikasaTitanIzquierda3;
			else if (this.x <= 320 && this.x > 280)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 360 && this.x > 320)
				spriteActual = mikasaTitanIzquierda1;
			else if (this.x <= 400 && this.x > 360)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 440 && this.x > 400)
				spriteActual = mikasaTitanIzquierda3;
			else if (this.x <= 480 && this.x > 440)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 520 && this.x > 480)
				spriteActual = mikasaTitanIzquierda1;
			else if (this.x <= 560 && this.x > 520)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 600 && this.x > 560)
				spriteActual = mikasaTitanIzquierda3;
			else if (this.x <= 640 && this.x > 600)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 680 && this.x > 640)
				spriteActual = mikasaTitanIzquierda1;
			else if (this.x <= 720 && this.x > 680)
				spriteActual = mikasaTitanIzquierda2;
			else if (this.x <= 760 && this.x > 720)
				spriteActual = mikasaTitanIzquierda3;
			else if (this.x <= 800 && this.x > 760)
				spriteActual = mikasaTitanIzquierda2;
		}
	}

	void animacionEspaldas() {

		if (this.getMikasaTitan() == false) {

			if (this.y <= 40 && this.y >= 0)
				spriteActual = mikasaEspaldas1;
			else if (this.y <= 80 && this.y > 40)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 120 && this.y > 80)
				spriteActual = mikasaEspaldas3;
			else if (this.y <= 160 && this.y > 120)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 200 && this.y > 160)
				spriteActual = mikasaEspaldas1;
			else if (this.y <= 240 && this.y > 200)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 280 && this.y > 240)
				spriteActual = mikasaEspaldas3;
			else if (this.y <= 320 && this.y > 280)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 360 && this.y > 320)
				spriteActual = mikasaEspaldas1;
			else if (this.y <= 400 && this.y > 360)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 440 && this.y > 400)
				spriteActual = mikasaEspaldas3;
			else if (this.y <= 480 && this.y > 440)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 520 && this.y > 480)
				spriteActual = mikasaEspaldas1;
			else if (this.y <= 560 && this.y > 520)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 600 && this.y > 560)
				spriteActual = mikasaEspaldas3;
			else if (this.y <= 640 && this.y > 600)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 680 && this.y > 640)
				spriteActual = mikasaEspaldas1;
			else if (this.y <= 720 && this.y > 680)
				spriteActual = mikasaEspaldas2;
			else if (this.y <= 760 && this.y > 720)
				spriteActual = mikasaEspaldas3;
			else if (this.y <= 800 && this.y > 760)
				spriteActual = mikasaEspaldas2;
		}

		if (this.getMikasaTitan() == true) {

			if (this.y <= 40 && this.y >= 0)
				spriteActual = mikasaTitanEspaldas1;
			else if (this.y <= 80 && this.y > 40)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 120 && this.y > 80)
				spriteActual = mikasaTitanEspaldas3;
			else if (this.y <= 160 && this.y > 120)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 200 && this.y > 160)
				spriteActual = mikasaTitanEspaldas1;
			else if (this.y <= 240 && this.y > 200)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 280 && this.y > 240)
				spriteActual = mikasaTitanEspaldas3;
			else if (this.y <= 320 && this.y > 280)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 360 && this.y > 320)
				spriteActual = mikasaTitanEspaldas1;
			else if (this.y <= 400 && this.y > 360)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 440 && this.y > 400)
				spriteActual = mikasaTitanEspaldas3;
			else if (this.y <= 480 && this.y > 440)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 520 && this.y > 480)
				spriteActual = mikasaTitanEspaldas1;
			else if (this.y <= 560 && this.y > 520)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 600 && this.y > 560)
				spriteActual = mikasaTitanEspaldas3;
			else if (this.y <= 640 && this.y > 600)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 680 && this.y > 640)
				spriteActual = mikasaTitanEspaldas1;
			else if (this.y <= 720 && this.y > 680)
				spriteActual = mikasaTitanEspaldas2;
			else if (this.y <= 760 && this.y > 720)
				spriteActual = mikasaTitanEspaldas3;
			else if (this.y <= 800 && this.y > 760)
				spriteActual = mikasaTitanEspaldas2;
		}
	}

	public double getOrientacion() {
		return this.orientacion;
	}

	public double setOrientacion(double x) {
		this.orientacion = x;
		return this.orientacion;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getXIzquierda() {
		return this.x - (this.ancho / 2);
	}

	public double getXDerecha() {
		return this.x + (this.ancho / 2);
	}

	public double getYArriba() {
		return this.y - (this.alto / 2);
	}

	public double getYAbajo() {
		return this.y + (this.alto / 2);
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getVelocidad() {
		return this.velocidad;
	}

	public void setEscala(double escala) {
		this.escala += escala;
	}

	public double getEscala() {
		return this.escala;
	}

	public boolean getMikasaTitan() {
		return this.mikasaTitan;
	}

	public void setMikasaTitan(boolean estado) {
		this.mikasaTitan = estado;
	}

	public int getVidas() {
		return this.vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = 5;
	}

	public void sumarVidas(int vidas) {
		this.vidas += 1;
	}

	public void restarVidas() {
		this.vidas -= 1;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}
}
