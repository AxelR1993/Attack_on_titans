package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Botiquin {
	
	private double x;
	private double y;
	private Image botiquin;
	
	public Botiquin (double x, double y) {
		this.x = x;
		this.y = y;
		this.botiquin = Herramientas.cargarImagen("imagenes/botiquin.png");
	}
	
	void dibujarBotiquin(Entorno entorno) {
		
		Color color = new Color(0,0,255,0);
		entorno.dibujarImagen(botiquin, this.x, this.y, 0, 0.10);
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
