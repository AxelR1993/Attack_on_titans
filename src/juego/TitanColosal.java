package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class TitanColosal {

	private double x;
	private double y;
	private double velocidad;
	private double ancho;
	private double alto;
	private double contador;
	private double escala;

	private Image titanFrente1 = Herramientas.cargarImagen("imagenesTitan/erenFrente1.png");
	private Image titanFrente2 = Herramientas.cargarImagen("imagenesTitan/erenFrente2.png");
	private Image titanFrente3 = Herramientas.cargarImagen("imagenesTitan/erenFrente3.png");
	private Image titanFrente4 = Herramientas.cargarImagen("imagenesTitan/erenFrente2.png");
	private Image titanIzquierda1 = Herramientas.cargarImagen("imagenesTitan/erenIzquierda1.png");
	private Image titanIzquierda2 = Herramientas.cargarImagen("imagenesTitan/erenIzquierda2.png");
	private Image titanIzquierda3 = Herramientas.cargarImagen("imagenesTitan/erenIzquierda3.png");
	private Image titanIzquierda4 = Herramientas.cargarImagen("imagenesTitan/erenIzquierda2.png");
	private Image titanDerecha1 = Herramientas.cargarImagen("imagenesTitan/erenDerecha1.png");
	private Image titanDerecha2 = Herramientas.cargarImagen("imagenesTitan/erenDerecha2.png");
	private Image titanDerecha3 = Herramientas.cargarImagen("imagenesTitan/erenDerecha3.png");
	private Image titanDerecha4 = Herramientas.cargarImagen("imagenesTitan/erenDerecha2.png");
	private Image titanEspaldas1 = Herramientas.cargarImagen("imagenesTitan/erenEspaldas1.png");
	private Image titanEspaldas2 = Herramientas.cargarImagen("imagenesTitan/erenEspaldas2.png");
	private Image titanEspaldas3 = Herramientas.cargarImagen("imagenesTitan/erenEspaldas3.png");
	private Image titanEspaldas4 = Herramientas.cargarImagen("imagenesTitan/erenEspaldas2.png");
	private Image explosion1 = Herramientas.cargarImagen("imagenesTitan/explosion1.png");
	private Image explosion5 = Herramientas.cargarImagen("imagenesTitan/explosion5.png");
	private Image spriteActual = titanFrente1;
	private int vidas;

	public TitanColosal(double x, double y, double ancho, double alto, double velocidad, 
			double escala, int vidas) {

		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.escala = escala;
		this.vidas = vidas;

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

		return this.contador += 0.2;
	}

	public double getContador() {

		return this.contador;
	}

	void dibujarTitan(Entorno entorno) {

		Color color = new Color(0, 255, 0, 0);
		entorno.dibujarImagen(spriteActual, this.x, this.y, 0, this.escala);

		entorno.dibujarRectangulo(this.x, this.y, 90, 190, 0, color);

	}

	void dibujarExplosion(Entorno entorno) {

		entorno.dibujarImagen(explosion1, this.x, this.y, 0, this.escala);
	}

	void explotar(Entorno entorno) {
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

	public int getVidas() {
		return this.vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public void restarVidas() {
		this.vidas -= 1;
	}

}