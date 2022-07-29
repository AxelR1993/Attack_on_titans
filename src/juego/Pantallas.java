package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Pantallas {

	int x;
	int y;
	private double contador;
	private Image inicio1 = Herramientas.cargarImagen("imagenesPantallas/portada1.png");
	private Image inicio5 = Herramientas.cargarImagen("imagenesPantallas/portada5.png");
	private Image inicio9 = Herramientas.cargarImagen("imagenesPantallas/portada9.png");
	private Image inicio11 = Herramientas.cargarImagen("imagenesPantallas/portada11.png");
	private Image gameover0 = Herramientas.cargarImagen("imagenesPantallas/gameover0.png");
	private Image gameover4 = Herramientas.cargarImagen("imagenesPantallas/gameover4.png");
	private Image gameover8 = Herramientas.cargarImagen("imagenesPantallas/gameover8.png");
	private Image gameover10 = Herramientas.cargarImagen("imagenesPantallas/gameover10.png");
	private Image izquierda0 = Herramientas.cargarImagen("imagenesSeleccion/1000.png");
	private Image izquierda4 = Herramientas.cargarImagen("imagenesSeleccion/1040.png");
	private Image izquierda8 = Herramientas.cargarImagen("imagenesSeleccion/1080.png");
	private Image izquierda10 = Herramientas.cargarImagen("imagenesSeleccion/1100.png");
	private Image derecha0 = Herramientas.cargarImagen("imagenesSeleccion/2000.png");
	private Image derecha4 = Herramientas.cargarImagen("imagenesSeleccion/2040.png");
	private Image derecha8 = Herramientas.cargarImagen("imagenesSeleccion/2080.png");
	private Image derecha10 = Herramientas.cargarImagen("imagenesSeleccion/2100.png");
	private Image gameOverEren0 = Herramientas.cargarImagen("imagenesPantallas/gameovereren0.png");
	private Image gameOverEren4 = Herramientas.cargarImagen("imagenesPantallas/gameovereren40.png");
	private Image gameOverEren8 = Herramientas.cargarImagen("imagenesPantallas/gameovereren80.png");
	private Image gameOverEren10 = Herramientas.cargarImagen("imagenesPantallas/gameovereren100.png");
	private Image facil00 = Herramientas.cargarImagen("dificultad/facil00.png");
	private Image facil40 = Herramientas.cargarImagen("dificultad/facil40.png");
	private Image facil80 = Herramientas.cargarImagen("dificultad/facil60.png");
	private Image facil100 = Herramientas.cargarImagen("dificultad/facil100.png");
	private Image normal00 = Herramientas.cargarImagen("dificultad/normal00.png");
	private Image normal40 = Herramientas.cargarImagen("dificultad/normal40.png");
	private Image normal80 = Herramientas.cargarImagen("dificultad/normal80.png");
	private Image normal100 = Herramientas.cargarImagen("dificultad/normal100.png");
	private Image dificil00 = Herramientas.cargarImagen("dificultad/dificil00.png");
	private Image dificil40 = Herramientas.cargarImagen("dificultad/dificil40.png");
	private Image dificil80 = Herramientas.cargarImagen("dificultad/dificil80.png");
	private Image dificil100 = Herramientas.cargarImagen("dificultad/dificil100.png");
	private Image ending00 = Herramientas.cargarImagen("imagenesPantallas/ending00.png");
	private Image ending40 = Herramientas.cargarImagen("imagenesPantallas/ending40.png");
	private Image ending80 = Herramientas.cargarImagen("imagenesPantallas/ending80.png");
	private Image ending100 = Herramientas.cargarImagen("imagenesPantallas/ending100.png");

	public Pantallas(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void dibujarPantallaInicio(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(inicio1, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(inicio5, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(inicio9, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(inicio11, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public void dibujarPantallaGameOver(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(gameover0, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(gameover4, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(gameover8, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(gameover10, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public void dibujarPantallaGameOverEren(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(gameOverEren0, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(gameOverEren4, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(gameOverEren8, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(gameOverEren10, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public void seleccionIzquierda(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(izquierda0, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(izquierda4, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(izquierda8, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(izquierda10, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public void seleccionDerecha(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(derecha0, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(derecha4, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(derecha8, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(derecha10, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public void facil(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(facil00, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(facil40, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(facil80, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(facil100, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public void normal(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(normal00, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(normal40, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(normal80, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(normal100, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public void dificil(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(dificil00, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(dificil40, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(dificil80, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(dificil100, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public void ending(Entorno entorno) {

		if (contador > 0 && contador < 5)
			entorno.dibujarImagen(ending00, 400, 400, 0);
		if (contador >= 5 && contador < 10)
			entorno.dibujarImagen(ending40, 400, 400, 0);
		if (contador >= 10 && contador < 15)
			entorno.dibujarImagen(ending80, 400, 400, 0);
		if (contador >= 15 && contador < 20)
			entorno.dibujarImagen(ending100, 400, 400, 0);
		if (contador > 20)
			contador = 0;

	}

	public double contar() {

		return this.contador += 1;
	}

	public double getContador() {

		return this.contador;
	}

}
