package juego;

import java.awt.Color;

import entorno.Entorno;

public class Obstaculo {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	public Obstaculo (int x, int y, int ancho, int alto) {
		
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		
	}
	
	void dibujarObstaculo(Entorno entorno) {
		
		Color color = new Color(255,0,0,0);
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, color);
	}
	
	
	public double getPosicionObstaculoXizquierda() {
		return this.x - (this.ancho/2);
	}
	
	public double getPosicionObstaculoXderecha() {
		return this.x + (this.ancho/2);
	}
	
	public double getPosicionObstaculoYarriba() {
		return this.y - (this.alto/2);
	}
	
	public double getPosicionObstaculoYabajo() {
		return this.y + (this.alto/2);
	}
}
