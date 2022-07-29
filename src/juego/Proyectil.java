package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Proyectil {
	
	double x;
	double y;
	double orientacion;
	double escala;
	private Image proyectilArriba = Herramientas.cargarImagen("imagenes/balaup.png");
	private Image proyectilAbajo = Herramientas.cargarImagen("imagenes/baladown.png");
	private Image proyectilDerecha = Herramientas.cargarImagen("imagenes/balarigth.png");
	private Image proyectilIzquierda = Herramientas.cargarImagen("imagenes/balaleft.png");
	private Image proyectilActual = proyectilArriba;
	
	public Proyectil (double x, double y, double orientacion, double escala) {
		
		this.x = x;
		this.y = y;
		this.orientacion = orientacion;
		this.escala = escala;
	}
	
	void dibujarProyectil(Entorno entorno) {
		
		Color color = new Color(0,0,255,0);
		entorno.dibujarImagen(proyectilActual, this.x, this.y, this.orientacion, this.escala);
		entorno.dibujarRectangulo(this.x, this.y, 10, 10, 0, color);
		
	}
	
	void borrarProyectil(Entorno entorno) {
		entorno.dibujarImagen(proyectilActual, this.x, this.y, this.orientacion, 0);
	}
	
	
	public void orientacionProyectil(double orientacionProyectil) {
		
		if(orientacionProyectil == 0) 
		proyectilActual = proyectilAbajo;
		if(orientacionProyectil == 3 )
		proyectilActual = proyectilDerecha;
		if(orientacionProyectil == 2 )
		proyectilActual = proyectilArriba;
		if(orientacionProyectil == 1 )
		proyectilActual = proyectilIzquierda;
			
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public void setY(double y) {
		this.y += y;
	}
	
	public void setX(double x) {
		this.x += x;
	}

}
