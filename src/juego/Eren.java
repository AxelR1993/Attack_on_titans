package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Eren {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private Image erenFrente1 = Herramientas.cargarImagen("imagenesErenNormal/erenFrente1.png");
	private Image erenFrente2 = Herramientas.cargarImagen("imagenesErenNormal/erenFrente2.png");
	private Image erenFrente3 = Herramientas.cargarImagen("imagenesErenNormal/erenFrente3.png");
	private Image erenIzquierda1 = Herramientas.cargarImagen("imagenesErenNormal/erenIzquierda1.png");
	private Image erenIzquierda2 = Herramientas.cargarImagen("imagenesErenNormal/erenIzquierda2.png");
	private Image erenIzquierda3 = Herramientas.cargarImagen("imagenesErenNormal/erenIzquierda3.png");
	private Image erenDerecha1 = Herramientas.cargarImagen("imagenesErenNormal/erenDerecha1.png");
	private Image erenDerecha2 = Herramientas.cargarImagen("imagenesErenNormal/erenDerecha2.png");
	private Image erenDerecha3 = Herramientas.cargarImagen("imagenesErenNormal/erenDerecha3.png");
	private Image erenEspaldas1 = Herramientas.cargarImagen("imagenesErenNormal/erenEspaldas1.png");
	private Image erenEspaldas2 = Herramientas.cargarImagen("imagenesErenNormal/erenEspaldas2.png");
	private Image erenEspaldas3 = Herramientas.cargarImagen("imagenesErenNormal/erenEspaldas3.png");
	private Image erenTitanFrente1 = Herramientas.cargarImagen("imagenesErenTitan/erenFrente1.png");
	private Image erenTitanFrente2 = Herramientas.cargarImagen("imagenesErenTitan/erenFrente2.png");
	private Image erenTitanFrente3 = Herramientas.cargarImagen("imagenesErenTitan/erenFrente3.png");
	private Image erenTitanIzquierda1 = Herramientas.cargarImagen("imagenesErenTitan/erenIzquierda1.png");
	private Image erenTitanIzquierda2 = Herramientas.cargarImagen("imagenesErenTitan/erenIzquierda2.png");
	private Image erenTitanIzquierda3 = Herramientas.cargarImagen("imagenesErenTitan/erenIzquierda3.png");
	private Image erenTitanDerecha1 = Herramientas.cargarImagen("imagenesErenTitan/erenDerecha1.png");
	private Image erenTitanDerecha2 = Herramientas.cargarImagen("imagenesErenTitan/erenDerecha2.png");
	private Image erenTitanDerecha3 = Herramientas.cargarImagen("imagenesErenTitan/erenDerecha3.png");
	private Image erenTitanEspaldas1 = Herramientas.cargarImagen("imagenesErenTitan/erenEspaldas1.png");
	private Image erenTitanEspaldas2 = Herramientas.cargarImagen("imagenesErenTitan/erenEspaldas2.png");
	private Image erenTitanEspaldas3 = Herramientas.cargarImagen("imagenesErenTitan/erenEspaldas3.png");
	private Image vidas5 = Herramientas.cargarImagen("imagenes/vidas5.png");
	private Image vidas4 = Herramientas.cargarImagen("imagenes/vidas4.png");
	private Image vidas3 = Herramientas.cargarImagen("imagenes/vidas3.png");
	private Image vidas2 = Herramientas.cargarImagen("imagenes/vidas2.png");
	private Image vidas1 = Herramientas.cargarImagen("imagenes/vidas1.png");
	private Image vidaActual = vidas5;
	private Image spriteActual = erenFrente2;
	private double orientacion;
	private double velocidad;
	private double escala;
	private boolean erenTitan;
	private int vidas;

	public Eren(double x, double y, double ancho, double alto, double orientacion, double velocidad, double escala,
			boolean erenTitan, int vidas) {

		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.orientacion = orientacion;
		this.velocidad = velocidad;
		this.escala = escala;
		this.erenTitan = erenTitan;
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
		entorno.dibujarImagen(vidaActual, 205, 670, 0, 0.8);
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

		if (this.orientacion == 0 & this.getErenTitan() == false)
			spriteActual = erenFrente1;

		if (this.orientacion == 0 & this.getErenTitan() == true)
			spriteActual = erenTitanFrente1;

		if (this.orientacion == -1)
			this.orientacion = 3;

		if (this.orientacion == -2)
			this.orientacion = 2;

		if (this.orientacion == -3)
			this.orientacion = 1;

		if (this.orientacion == -4 & this.getErenTitan() == false) {
			this.orientacion = 0;
			spriteActual = erenFrente1;
		}

		if (this.orientacion == -4 & this.getErenTitan() == true) {
			this.orientacion = 0;
			spriteActual = erenTitanFrente1;
		}

		if (this.orientacion == 1 & this.getErenTitan() == false)
			spriteActual = erenIzquierda1;

		if (this.orientacion == 2 & this.getErenTitan() == false)
			spriteActual = erenEspaldas1;

		if (this.orientacion == 3 & this.getErenTitan() == false)
			spriteActual = erenDerecha1;

		if (this.orientacion == 1 & this.getErenTitan() == true)
			spriteActual = erenTitanIzquierda1;

		if (this.orientacion == 2 & this.getErenTitan() == true)
			spriteActual = erenTitanEspaldas1;

		if (this.orientacion == 3 & this.getErenTitan() == true)
			spriteActual = erenTitanDerecha1;

		if (this.orientacion == 4 & this.getErenTitan() == false) {
			this.orientacion = 0;
			spriteActual = erenFrente1;
		}

		if (this.orientacion == 4 & this.getErenTitan() == true) {
			this.orientacion = 0;
			spriteActual = erenTitanFrente1;
		}
	}

	void avanzar(double velocidad) {

		if (this.orientacion == 0)
			avanzarFrente(velocidad);

		if (this.orientacion == -1)
			this.orientacion = 3;

		if (this.orientacion == -2)
			avanzarEspaldas(velocidad);

		if (this.orientacion == -3)
			avanzarIzquierda(velocidad);

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

	void retrocederFrente(double velocidad) {
		this.y -= velocidad;
		animacionFrente();
	}

	void avanzarDerecha(double velocidad) {
		this.x += velocidad;
		animacionDerecha();
	}

	void retrocederDerecha(double velocidad) {
		this.x -= velocidad;
		animacionDerecha();
	}

	void avanzarIzquierda(double velocidad) {
		this.x -= velocidad;
		animacionIzquierda();
	}

	void retrocederIzquierda(double velocidad) {
		this.x += velocidad;
		animacionIzquierda();
	}

	void avanzarEspaldas(double velocidad) {
		this.y -= velocidad;
		animacionEspaldas();
	}

	void retrocederEspaldas(double velocidad) {
		this.y += velocidad;
		animacionEspaldas();
	}

	void animacionFrente() {

		if (this.getErenTitan() == false) {

			if (this.y <= 40 && this.y >= 0)
				spriteActual = erenFrente1;
			else if (this.y <= 80 && this.y > 40)
				spriteActual = erenFrente2;
			else if (this.y <= 120 && this.y > 80)
				spriteActual = erenFrente3;
			else if (this.y <= 160 && this.y > 120)
				spriteActual = erenFrente2;
			else if (this.y <= 200 && this.y > 160)
				spriteActual = erenFrente1;
			else if (this.y <= 240 && this.y > 200)
				spriteActual = erenFrente2;
			else if (this.y <= 280 && this.y > 240)
				spriteActual = erenFrente3;
			else if (this.y <= 320 && this.y > 280)
				spriteActual = erenFrente2;
			else if (this.y <= 360 && this.y > 320)
				spriteActual = erenFrente1;
			else if (this.y <= 400 && this.y > 360)
				spriteActual = erenFrente2;
			else if (this.y <= 440 && this.y > 400)
				spriteActual = erenFrente3;
			else if (this.y <= 480 && this.y > 440)
				spriteActual = erenFrente2;
			else if (this.y <= 520 && this.y > 480)
				spriteActual = erenFrente1;
			else if (this.y <= 560 && this.y > 520)
				spriteActual = erenFrente2;
			else if (this.y <= 600 && this.y > 560)
				spriteActual = erenFrente3;
			else if (this.y <= 640 && this.y > 600)
				spriteActual = erenFrente2;
			else if (this.y <= 680 && this.y > 640)
				spriteActual = erenFrente1;
			else if (this.y <= 720 && this.y > 680)
				spriteActual = erenFrente2;
			else if (this.y <= 760 && this.y > 720)
				spriteActual = erenFrente3;
			else if (this.y <= 800 && this.y > 760)
				spriteActual = erenFrente2;
		}

		if (this.getErenTitan() == true) {

			if (this.y <= 40 && this.y >= 0)
				spriteActual = erenTitanFrente1;
			else if (this.y <= 80 && this.y > 40)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 120 && this.y > 80)
				spriteActual = erenTitanFrente3;
			else if (this.y <= 160 && this.y > 120)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 200 && this.y > 160)
				spriteActual = erenTitanFrente1;
			else if (this.y <= 240 && this.y > 200)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 280 && this.y > 240)
				spriteActual = erenTitanFrente3;
			else if (this.y <= 320 && this.y > 280)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 360 && this.y > 320)
				spriteActual = erenTitanFrente1;
			else if (this.y <= 400 && this.y > 360)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 440 && this.y > 400)
				spriteActual = erenTitanFrente3;
			else if (this.y <= 480 && this.y > 440)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 520 && this.y > 480)
				spriteActual = erenTitanFrente1;
			else if (this.y <= 560 && this.y > 520)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 600 && this.y > 560)
				spriteActual = erenTitanFrente3;
			else if (this.y <= 640 && this.y > 600)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 680 && this.y > 640)
				spriteActual = erenTitanFrente1;
			else if (this.y <= 720 && this.y > 680)
				spriteActual = erenTitanFrente2;
			else if (this.y <= 760 && this.y > 720)
				spriteActual = erenTitanFrente3;
			else if (this.y <= 800 && this.y > 760)
				spriteActual = erenTitanFrente2;
		}
	}

	void animacionDerecha() {

		if (this.getErenTitan() == false) {

			if (this.x <= 40 && this.x >= 0)
				spriteActual = erenDerecha1;
			else if (this.x <= 80 && this.x > 40)
				spriteActual = erenDerecha2;
			else if (this.x <= 120 && this.x > 80)
				spriteActual = erenDerecha3;
			else if (this.x <= 160 && this.x > 120)
				spriteActual = erenDerecha2;
			else if (this.x <= 200 && this.x > 160)
				spriteActual = erenDerecha1;
			else if (this.x <= 240 && this.x > 200)
				spriteActual = erenDerecha2;
			else if (this.x <= 280 && this.x > 240)
				spriteActual = erenDerecha3;
			else if (this.x <= 320 && this.x > 280)
				spriteActual = erenDerecha2;
			else if (this.x <= 360 && this.x > 320)
				spriteActual = erenDerecha1;
			else if (this.x <= 400 && this.x > 360)
				spriteActual = erenDerecha2;
			else if (this.x <= 440 && this.x > 400)
				spriteActual = erenDerecha3;
			else if (this.x <= 480 && this.x > 440)
				spriteActual = erenDerecha2;
			else if (this.x <= 520 && this.x > 480)
				spriteActual = erenDerecha1;
			else if (this.x <= 560 && this.x > 520)
				spriteActual = erenDerecha2;
			else if (this.x <= 600 && this.x > 560)
				spriteActual = erenDerecha3;
			else if (this.x <= 640 && this.x > 600)
				spriteActual = erenDerecha2;
			else if (this.x <= 680 && this.x > 640)
				spriteActual = erenDerecha3;
			else if (this.x <= 720 && this.x > 680)
				spriteActual = erenDerecha2;
			else if (this.x <= 760 && this.x > 720)
				spriteActual = erenDerecha1;
			else if (this.x <= 800 && this.x > 760)
				spriteActual = erenDerecha2;
		}

		if (this.getErenTitan() == true) {

			if (this.x <= 40 && this.x >= 0)
				spriteActual = erenTitanDerecha1;
			else if (this.x <= 80 && this.x > 40)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 120 && this.x > 80)
				spriteActual = erenTitanDerecha3;
			else if (this.x <= 160 && this.x > 120)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 200 && this.x > 160)
				spriteActual = erenTitanDerecha1;
			else if (this.x <= 240 && this.x > 200)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 280 && this.x > 240)
				spriteActual = erenTitanDerecha3;
			else if (this.x <= 320 && this.x > 280)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 360 && this.x > 320)
				spriteActual = erenTitanDerecha1;
			else if (this.x <= 400 && this.x > 360)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 440 && this.x > 400)
				spriteActual = erenTitanDerecha3;
			else if (this.x <= 480 && this.x > 440)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 520 && this.x > 480)
				spriteActual = erenTitanDerecha1;
			else if (this.x <= 560 && this.x > 520)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 600 && this.x > 560)
				spriteActual = erenTitanDerecha3;
			else if (this.x <= 640 && this.x > 600)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 680 && this.x > 640)
				spriteActual = erenTitanDerecha3;
			else if (this.x <= 720 && this.x > 680)
				spriteActual = erenTitanDerecha2;
			else if (this.x <= 760 && this.x > 720)
				spriteActual = erenTitanDerecha1;
			else if (this.x <= 800 && this.x > 760)
				spriteActual = erenTitanDerecha2;
		}
	}

	void animacionIzquierda() {

		if (this.getErenTitan() == false) {

			if (this.x <= 40 && this.x / 10 >= 0)
				spriteActual = erenIzquierda1;
			else if (this.x <= 80 && this.x > 40)
				spriteActual = erenIzquierda2;
			else if (this.x <= 120 && this.x > 80)
				spriteActual = erenIzquierda3;
			else if (this.x <= 160 && this.x > 120)
				spriteActual = erenIzquierda2;
			else if (this.x <= 200 && this.x > 160)
				spriteActual = erenIzquierda1;
			else if (this.x <= 240 && this.x > 200)
				spriteActual = erenIzquierda2;
			else if (this.x <= 280 && this.x > 240)
				spriteActual = erenIzquierda3;
			else if (this.x <= 320 && this.x > 280)
				spriteActual = erenIzquierda2;
			else if (this.x <= 360 && this.x > 320)
				spriteActual = erenIzquierda1;
			else if (this.x <= 400 && this.x > 360)
				spriteActual = erenIzquierda2;
			else if (this.x <= 440 && this.x > 400)
				spriteActual = erenIzquierda3;
			else if (this.x <= 480 && this.x > 440)
				spriteActual = erenIzquierda2;
			else if (this.x <= 520 && this.x > 480)
				spriteActual = erenIzquierda1;
			else if (this.x <= 560 && this.x > 520)
				spriteActual = erenIzquierda2;
			else if (this.x <= 600 && this.x > 560)
				spriteActual = erenIzquierda3;
			else if (this.x <= 640 && this.x > 600)
				spriteActual = erenIzquierda2;
			else if (this.x <= 680 && this.x > 640)
				spriteActual = erenIzquierda1;
			else if (this.x <= 720 && this.x > 680)
				spriteActual = erenIzquierda2;
			else if (this.x <= 760 && this.x > 720)
				spriteActual = erenIzquierda3;
			else if (this.x <= 800 && this.x > 760)
				spriteActual = erenIzquierda2;
		}

		if (this.getErenTitan() == true) {

			if (this.x <= 40 && this.x / 10 >= 0)
				spriteActual = erenTitanIzquierda1;
			else if (this.x <= 80 && this.x > 40)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 120 && this.x > 80)
				spriteActual = erenTitanIzquierda3;
			else if (this.x <= 160 && this.x > 120)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 200 && this.x > 160)
				spriteActual = erenTitanIzquierda1;
			else if (this.x <= 240 && this.x > 200)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 280 && this.x > 240)
				spriteActual = erenTitanIzquierda3;
			else if (this.x <= 320 && this.x > 280)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 360 && this.x > 320)
				spriteActual = erenTitanIzquierda1;
			else if (this.x <= 400 && this.x > 360)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 440 && this.x > 400)
				spriteActual = erenTitanIzquierda3;
			else if (this.x <= 480 && this.x > 440)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 520 && this.x > 480)
				spriteActual = erenTitanIzquierda1;
			else if (this.x <= 560 && this.x > 520)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 600 && this.x > 560)
				spriteActual = erenTitanIzquierda3;
			else if (this.x <= 640 && this.x > 600)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 680 && this.x > 640)
				spriteActual = erenTitanIzquierda1;
			else if (this.x <= 720 && this.x > 680)
				spriteActual = erenTitanIzquierda2;
			else if (this.x <= 760 && this.x > 720)
				spriteActual = erenTitanIzquierda3;
			else if (this.x <= 800 && this.x > 760)
				spriteActual = erenTitanIzquierda2;
		}
	}

	void animacionEspaldas() {

		if (this.getErenTitan() == false) {

			if (this.y <= 40 && this.y >= 0)
				spriteActual = erenEspaldas1;
			else if (this.y <= 80 && this.y > 40)
				spriteActual = erenEspaldas2;
			else if (this.y <= 120 && this.y > 80)
				spriteActual = erenEspaldas3;
			else if (this.y <= 160 && this.y > 120)
				spriteActual = erenEspaldas2;
			else if (this.y <= 200 && this.y > 160)
				spriteActual = erenEspaldas1;
			else if (this.y <= 240 && this.y > 200)
				spriteActual = erenEspaldas2;
			else if (this.y <= 280 && this.y > 240)
				spriteActual = erenEspaldas3;
			else if (this.y <= 320 && this.y > 280)
				spriteActual = erenEspaldas2;
			else if (this.y <= 360 && this.y > 320)
				spriteActual = erenEspaldas1;
			else if (this.y <= 400 && this.y > 360)
				spriteActual = erenEspaldas2;
			else if (this.y <= 440 && this.y > 400)
				spriteActual = erenEspaldas3;
			else if (this.y <= 480 && this.y > 440)
				spriteActual = erenEspaldas2;
			else if (this.y <= 520 && this.y > 480)
				spriteActual = erenEspaldas1;
			else if (this.y <= 560 && this.y > 520)
				spriteActual = erenEspaldas2;
			else if (this.y <= 600 && this.y > 560)
				spriteActual = erenEspaldas3;
			else if (this.y <= 640 && this.y > 600)
				spriteActual = erenEspaldas2;
			else if (this.y <= 680 && this.y > 640)
				spriteActual = erenEspaldas1;
			else if (this.y <= 720 && this.y > 680)
				spriteActual = erenEspaldas2;
			else if (this.y <= 760 && this.y > 720)
				spriteActual = erenEspaldas3;
			else if (this.y <= 800 && this.y > 760)
				spriteActual = erenEspaldas2;
		}

		if (this.getErenTitan() == true) {

			if (this.y <= 40 && this.y >= 0)
				spriteActual = erenTitanEspaldas1;
			else if (this.y <= 80 && this.y > 40)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 120 && this.y > 80)
				spriteActual = erenTitanEspaldas3;
			else if (this.y <= 160 && this.y > 120)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 200 && this.y > 160)
				spriteActual = erenTitanEspaldas1;
			else if (this.y <= 240 && this.y > 200)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 280 && this.y > 240)
				spriteActual = erenTitanEspaldas3;
			else if (this.y <= 320 && this.y > 280)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 360 && this.y > 320)
				spriteActual = erenTitanEspaldas1;
			else if (this.y <= 400 && this.y > 360)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 440 && this.y > 400)
				spriteActual = erenTitanEspaldas3;
			else if (this.y <= 480 && this.y > 440)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 520 && this.y > 480)
				spriteActual = erenTitanEspaldas1;
			else if (this.y <= 560 && this.y > 520)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 600 && this.y > 560)
				spriteActual = erenTitanEspaldas3;
			else if (this.y <= 640 && this.y > 600)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 680 && this.y > 640)
				spriteActual = erenTitanEspaldas1;
			else if (this.y <= 720 && this.y > 680)
				spriteActual = erenTitanEspaldas2;
			else if (this.y <= 760 && this.y > 720)
				spriteActual = erenTitanEspaldas3;
			else if (this.y <= 800 && this.y > 760)
				spriteActual = erenTitanEspaldas2;
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

	public boolean getErenTitan() {
		return this.erenTitan;
	}

	public void setErenTitan(boolean estado) {
		this.erenTitan = estado;
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
