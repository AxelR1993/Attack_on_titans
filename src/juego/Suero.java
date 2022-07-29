package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Suero {
	
	private double x;
	private double y;
	private Image suero;
	
	public Suero (double x, double y) {
		this.x = x;
		this.y = y;
		this.suero = Herramientas.cargarImagen("imagenes/vacuna.png");
	}
	
	void dibujarSuero(Entorno entorno) {
		
		Color color = new Color(0,0,255,0);
		entorno.dibujarImagen(suero, this.x, this.y, 0, 0.60);
		entorno.dibujarRectangulo(this.x, this.y, 40, 40, 0, color);
	}
	
	
	
	public double getXderecha() {
		return this.x + 50;
	}
	
	public double getXizquierda() {
		return this.x - 50;
	}
	
	public double getYarriba() {
		return this.y - 50;
	}
	
	public double getYabajo() {
		return this.y + 50;
	}

}
