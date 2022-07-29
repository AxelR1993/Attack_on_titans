package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Titan {

	private double x;
	private double y;
	private double velocidad;
	private double ancho;
	private double alto;
	private double contador;
	private double escala;

	private Image titanFrente1 = Herramientas.cargarImagen("imagenesTitan/frente1.png");
	private Image titanFrente2 = Herramientas.cargarImagen("imagenesTitan/frente2.png");
	private Image titanFrente3 = Herramientas.cargarImagen("imagenesTitan/frente3.png");
	private Image titanFrente4 = Herramientas.cargarImagen("imagenesTitan/frente4.png");
	private Image titanIzquierda1 = Herramientas.cargarImagen("imagenesTitan/izquierda1.png");
	private Image titanIzquierda2 = Herramientas.cargarImagen("imagenesTitan/izquierda2.png");
	private Image titanIzquierda3 = Herramientas.cargarImagen("imagenesTitan/izquierda3.png");
	private Image titanIzquierda4 = Herramientas.cargarImagen("imagenesTitan/izquierda4.png");
	private Image titanDerecha1 = Herramientas.cargarImagen("imagenesTitan/derecha1.png");
	private Image titanDerecha2 = Herramientas.cargarImagen("imagenesTitan/derecha2.png");
	private Image titanDerecha3 = Herramientas.cargarImagen("imagenesTitan/derecha3.png");
	private Image titanDerecha4 = Herramientas.cargarImagen("imagenesTitan/derecha4.png");
	private Image titanEspaldas1 = Herramientas.cargarImagen("imagenesTitan/espaldas1.png");
	private Image titanEspaldas2 = Herramientas.cargarImagen("imagenesTitan/espaldas2.png");
	private Image titanEspaldas3 = Herramientas.cargarImagen("imagenesTitan/espaldas3.png");
	private Image titanEspaldas4 = Herramientas.cargarImagen("imagenesTitan/espaldas4.png");
	private Image explosion5 = Herramientas.cargarImagen("imagenesTitan/explosion5.png");
	private Image spriteActual = titanFrente1;

	public Titan(double x, double y, double ancho, double alto, double velocidad, double escala) {

		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.escala = escala;

	}

	void animaciónFrente() {

		if (contador > 0 && contador < 200)
			spriteActual = titanFrente1;
		if (contador >= 200 && contador < 400)
			spriteActual = titanFrente2;
		if (contador >= 400 && contador < 600)
			spriteActual = titanFrente3;
		if (contador >= 600 && contador < 800)
			spriteActual = titanFrente4;
		if (contador > 800)
			contador = 0;
	}

	void animaciónIzquierda() {

		if (contador > 0 && contador < 200)
			spriteActual = titanIzquierda1;
		if (contador >= 200 && contador < 400)
			spriteActual = titanIzquierda2;
		if (contador >= 400 && contador < 600)
			spriteActual = titanIzquierda3;
		if (contador >= 600 && contador < 800)
			spriteActual = titanIzquierda4;
		if (contador > 800)
			contador = 0;
	}

	void animaciónDerecha() {

		if (contador > 0 && contador < 200)
			spriteActual = titanDerecha1;
		if (contador >= 200 && contador < 400)
			spriteActual = titanDerecha2;
		if (contador >= 400 && contador < 600)
			spriteActual = titanDerecha3;
		if (contador >= 600 && contador < 800)
			spriteActual = titanDerecha4;
		if (contador > 800)
			contador = 0;
	}

	void animaciónEspaldas() {

		if (contador > 0 && contador < 200)
			spriteActual = titanEspaldas1;
		if (contador >= 200 && contador < 400)
			spriteActual = titanEspaldas2;
		if (contador >= 400 && contador < 600)
			spriteActual = titanEspaldas3;
		if (contador >= 600 && contador < 800)
			spriteActual = titanEspaldas4;
		if (contador > 800)
			contador = 0;
	}

	public double contar() {

		return this.contador += 1;
	}

	public double getContador() {

		return this.contador;
	}

	void dibujarTitan(Entorno entorno) {

		Color color = new Color(0, 255, 0, 0);
		entorno.dibujarImagen(spriteActual, this.x, this.y, 0, this.escala);

		entorno.dibujarRectangulo(this.x, this.y, 70, 100, 0, color);

	}

	void dibujarExplosion(Entorno entorno) {

		entorno.dibujarImagen(explosion5, this.x, this.y, 0, this.escala);

	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
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

	public void moverX(double x) {
		this.x += x;
	}

	public void moverY(double y) {
		this.y += y;
	}

	public double getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad += velocidad;
	}

	public void velocidadInicial(double velocidad) {
		this.velocidad = velocidad;
	}

}
