	package juego;

	import java.awt.Color;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

	public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	private Obstaculo casa1 = new Obstaculo(50, 150, 130, 330);
	private Obstaculo casa2 = new Obstaculo(285, 120, 370, 240);
	private Obstaculo farol1 = new Obstaculo(165, 255, 100, 50);
	private Obstaculo casa3 = new Obstaculo(710, 180, 180, 360);
	private Obstaculo casa4 = new Obstaculo(700, 700, 200, 200);
	private Obstaculo casa5 = new Obstaculo(570, 770, 75, 60);
	private Obstaculo casa6 = new Obstaculo(160, 800, 330, 300);
	private Obstaculo casa7 = new Obstaculo(40, 590, 90, 130);
	private Obstaculo estatua = new Obstaculo(400, 450, 50, 80);
	private boolean pantallaInicio;
	private Pantallas inicio;
	private boolean gameover;
	private Sonidos sonido;
	private boolean musicaIniciada;
	private Personaje mikasa;
	private Eren eren;
	private Proyectil bala;
	private Proyectil balaEren;
	private boolean disparoActivado;
	private boolean disparoActivadoEren;
	private double direccionDisparo;
	private double direccionDisparoEren;
	private boolean sueroCreado = false;
	private Suero suero;
	private double velocidadTitanes;
	private int aleatorio;
	private boolean velocidadInicial;
	private boolean invencibilidad;
	private boolean invencibilidadEren;
	private boolean jugador2;
	private int inmunidad;
	private int inmunidadEren;
	private Botiquin botiquin;
	private boolean botiquinCreado;
	private TitanColosal colosal;
	private boolean titanColosalActivo;
	private boolean ending;
	private boolean seleccion;
	private boolean enterSeleccion;
	private double sueroX;
	private double sueroY;
	private double botiquinX;
	private double botiquinY;
	private int tiempo;
	private int segundos;
	private int minutos;
	private boolean erengameover;
	private boolean facil;
	private boolean normal;
	private boolean dificil;
	private boolean dificultad;
	private int cursorDificultad;
	private boolean esperar;
	Titan[] arregloTitanes = new Titan[6];
	Obstaculo[] obstaculos = { this.casa1, this.casa2, this.farol1, this.casa3, 
			this.casa4, this.casa5, this.casa6, this.casa7, this.estatua };

	public void tiempo() {

		this.segundos = (int) (this.tiempo / 100) % 60;
		this.minutos = (int) ((this.tiempo / (100 * 60)) % 60);

	}

	double randomX() {

		this.aleatorio = numeroAleatorioEnRango(1, 4);
		if (this.aleatorio == 1)
			return numeroAleatorioEnRango(510, 580);

		if (this.aleatorio == 2)
			return entorno.ancho() + 25;

		if (this.aleatorio == 3)
			return numeroAleatorioEnRango(360, 500);

		else
			return -25;
	}

	double randomY() {

		if (this.aleatorio == 1)
			return -25;

		if (this.aleatorio == 2)
			return numeroAleatorioEnRango(420, 550);

		if (this.aleatorio == 3)
			return entorno.alto() + 25;
		else
			return numeroAleatorioEnRango(370, 480);
	}

	public static int numeroAleatorioEnRango(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}

	public void crearTitanes() {

		for (int j = 0; j < arregloTitanes.length; j++) {

			if (velocidadInicial == true) {
				velocidadTitanes = 0;
				velocidadInicial = false;
			}

			if (arregloTitanes[j] == null) {
				arregloTitanes[j] = new Titan(randomX(), randomY(), 70, 105, 0.0050, 1);
				this.arregloTitanes[j].setVelocidad(velocidadTitanes);
				if (velocidadTitanes < 0.20) {
					velocidadTitanes += 0.005;
				}

			}
		}

	}

	public void esperar() {

		try {
			Thread.sleep(1000);// tiempo en ms
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// No se ejecuta nada, solo hacer que espere

			}
		}, 1000);// esperar 1000 ms antes de la accion

	}

	public void crearSuero() {

		this.aleatorio = numeroAleatorioEnRango(1, 4);

		if (this.aleatorio == 1) {
			this.sueroX = ThreadLocalRandom.current().nextInt(200, 300);
			this.sueroY = ThreadLocalRandom.current().nextInt(340, 500);
		}

		if (this.aleatorio == 2) {
			this.sueroX = ThreadLocalRandom.current().nextInt(200, 590);
			this.sueroY = ThreadLocalRandom.current().nextInt(340, 350);
		}

		if (this.aleatorio == 3) {
			this.sueroX = ThreadLocalRandom.current().nextInt(500, 550);
			this.sueroY = ThreadLocalRandom.current().nextInt(340, 540);
		}

		if (this.aleatorio == 4) {
			this.sueroX = ThreadLocalRandom.current().nextInt(200, 300);
			this.sueroY = ThreadLocalRandom.current().nextInt(580, 585);
		}

		this.suero = new Suero(sueroX, sueroY);
		sueroCreado = true;

	}

	public void crearBotiquin() {

		this.aleatorio = numeroAleatorioEnRango(1, 4);

		if (this.aleatorio == 1) {
			this.botiquinX = ThreadLocalRandom.current().nextInt(200, 300);
			this.botiquinY = ThreadLocalRandom.current().nextInt(340, 570);
		}

		if (this.aleatorio == 2) {
			this.botiquinX = ThreadLocalRandom.current().nextInt(200, 590);
			this.botiquinY = ThreadLocalRandom.current().nextInt(340, 350);
		}

		if (this.aleatorio == 3) {
			this.botiquinX = ThreadLocalRandom.current().nextInt(500, 550);
			this.botiquinY = ThreadLocalRandom.current().nextInt(340, 570);
		}

		if (this.aleatorio == 4) {
			this.botiquinX = ThreadLocalRandom.current().nextInt(200, 300);
			this.botiquinY = ThreadLocalRandom.current().nextInt(580, 590);
		}

		this.botiquin = new Botiquin(botiquinX, botiquinY);
		botiquinCreado = true;

	}

	public void musica() {

		if (sonido.getClip() != null)
			this.sonido.stop();

		if (this.pantallaInicio)
			this.sonido.startMenu();

		if (this.gameover == false && this.erengameover == false &&
				this.pantallaInicio == false && 
				this.titanColosalActivo == false && this.ending == false) {
			this.sonido.startBatalla();
		}

		if (this.titanColosalActivo && this.ending == false && 
				this.gameover == false && this.erengameover == false)
			this.sonido.startBoss();

		if (this.erengameover || this.gameover)
			this.sonido.startGameover();

		if (this.ending)
			this.sonido.startEnding();
	}

	public void inicializarJuego() {

		this.pantallaInicio = true;
		this.gameover = false;
		this.erengameover = false;
		this.titanColosalActivo = false;
		this.colosal = null;
		this.titanesMuertos = 0;
		this.sonido = new Sonidos();
		this.musicaIniciada = true;
		this.mikasa = new Personaje(550, 450, 40, 57, 0, 0.35, 0.75, false, 5);
		this.eren = new Eren(250, 450, 40, 57, 0, 0.35, 0.75, false, 5);
		this.disparoActivado = false;
		this.disparoActivadoEren = false;
		this.direccionDisparo = 0;
		this.direccionDisparoEren = 0;
		this.sueroCreado = false;
		this.velocidadInicial = true;
		this.invencibilidad = false;
		this.invencibilidadEren = false;
		this.jugador2 = false;
		this.inmunidad = 50;
		this.inmunidadEren = 50;
		this.ending = false;
		this.seleccion = false;
		this.enterSeleccion = false;
		this.tiempo = 9000;
		this.suero = null;
		this.botiquin = null;
		this.facil = false;
		this.normal = false;
		this.dificil = false;
		this.dificultad = false;
		this.cursorDificultad = 0;
		this.esperar = true;
		for (int i = 0; i < arregloTitanes.length; i++) {
			if (arregloTitanes[i] != null) {
				arregloTitanes[i] = null;
			}
		}

	}

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this,
				"Attack on Titan, Final Season - Grupo 11 ", 800, 800);

		// Inicializar lo que haga falta para el juego

		this.inicio = new Pantallas(400, 400);

		// Inicia el juego!
		this.entorno.iniciar();

		inicializarJuego();

	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */

	int titanesMuertos = 0;

	public void tick() {

		if (this.musicaIniciada) {
			musica();
			this.musicaIniciada = false;
		}

		/*******************************************************************
		 * 
		 * Activación Titan Colosal
		 * 
		 * /
		 *******************************************************************/

		if (this.facil) {
			if (titanesMuertos > 10 && this.titanColosalActivo == false) {
				this.colosal = new TitanColosal(randomX(), randomY(), 
						90, 190, 0, 1, 10);
				this.colosal.setVidas(10);
				this.titanColosalActivo = true;
				Herramientas.play("sonidos/colosal.wav");
				musica();
			}
		}

		if (this.normal) {
			if (titanesMuertos > 20 && this.titanColosalActivo == false) {
				this.colosal = new TitanColosal(randomX(), randomY(), 90, 190, 
						0, 1, 20);
				this.colosal.setVidas(20);
				this.titanColosalActivo = true;
				Herramientas.play("sonidos/colosal.wav");
				musica();
			}
		}

		if (this.dificil) {
			if (titanesMuertos > 30 && this.titanColosalActivo == false) {
				this.colosal = new TitanColosal(randomX(), randomY(), 90, 190, 
						0, 1, 30);
				this.colosal.setVidas(30);
				this.titanColosalActivo = true;
				Herramientas.play("sonidos/colosal.wav");
				musica();
			}
		}

		/*******************************************************************
		 * 
		 * Invencibilidad
		 * 
		 * /
		 *******************************************************************/

		if (this.invencibilidad) {
			this.inmunidad -= 1;
			if (inmunidad == 0) {
				this.invencibilidad = false;
				this.inmunidad = 50;
			}
		}

		if (this.invencibilidadEren && jugador2) {
			this.inmunidadEren -= 1;
			if (inmunidadEren == 0) {
				this.invencibilidadEren = false;
				this.inmunidadEren = 50;
			}
		}

		/*******************************************************************
		 * 
		 * Pantalla Inicio
		 * 
		 * /
		 *******************************************************************/

		if (this.pantallaInicio) {

			if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
				this.pantallaInicio = false;
				this.seleccion = true;

			}

			this.inicio.contar();
			Image background = Herramientas.cargarImagen("imagenesPantallas/"
					+ "portada1.png");
			entorno.dibujarImagen(background, 400, 400, 0);
			this.inicio.dibujarPantallaInicio(entorno);
		}

		/*******************************************************************
		 * 
		 * Pantalla Seleccion
		 * 
		 * /
		 *******************************************************************/

		if (seleccion) {

			this.inicio.contar();

			if (this.enterSeleccion == false) {
				Image background = Herramientas.cargarImagen("imagenesSeleccion/"
						+ "1100.png");
				entorno.dibujarImagen(background, 400, 400, 0);
				this.inicio.seleccionIzquierda(entorno);

				if (entorno.sePresiono(entorno.TECLA_ENTER)) {

					this.seleccion = false;
					this.dificultad = true;
					this.pantallaInicio = false;
				}

			}

			if (this.enterSeleccion) {

				Image background = Herramientas.cargarImagen("imagenesSeleccion/"
						+ "2100.png");
				entorno.dibujarImagen(background, 400, 400, 0);
				this.inicio.seleccionDerecha(entorno);

				if (entorno.sePresiono(entorno.TECLA_ENTER)) {
					this.jugador2 = true;
					this.eren.setX(350);
					this.eren.setY(550);
					this.seleccion = false;
					this.dificultad = true;
					this.pantallaInicio = false;
				}
			}

			if (entorno.sePresiono(entorno.TECLA_DERECHA)) {
				Herramientas.play("sonidos/seleccion.wav");
				this.enterSeleccion = true;
			}

			if (entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
				Herramientas.play("sonidos/seleccion.wav");
				this.enterSeleccion = false;

			}

		}

		/*******************************************************************
		 * 
		 * Pantalla Dificultad
		 * 
		 * /
		 *******************************************************************/

		if (this.dificultad && this.seleccion == false) {
			Image background = Herramientas.cargarImagen("dificultad/facil00.png");
			entorno.dibujarImagen(background, 400, 400, 0);
			this.inicio.contar();

			if (this.cursorDificultad == 0) {
				this.inicio.facil(entorno);

				if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {

					this.dificultad = false;
					this.facil = true;
					musicaIniciada = true;
				}

			}

			if (this.cursorDificultad == 1) {
				this.inicio.normal(entorno);

				if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {

					this.dificultad = false;
					this.normal = true;
					musicaIniciada = true;
				}

			}

			if (this.cursorDificultad == 2) {
				this.inicio.dificil(entorno);

				if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {

					this.dificultad = false;
					this.dificil = true;
					musicaIniciada = true;
				}

			}

			if (entorno.sePresiono(entorno.TECLA_ABAJO)) {
				Herramientas.play("sonidos/seleccion.wav");

				if (this.cursorDificultad < 2)
					this.cursorDificultad++;

			}

			if (entorno.sePresiono(entorno.TECLA_ARRIBA)) {
				Herramientas.play("sonidos/seleccion.wav");

				if (this.cursorDificultad > 0)
					this.cursorDificultad--;

			}

		}

		/*******************************************************************
		 * 
		 * Pantalla Game Over
		 * 
		 * /
		 *******************************************************************/

		if (this.gameover) {

			if (entorno.sePresiono(entorno.TECLA_SHIFT)) {
				if (sonido.getClip() != null)
					this.sonido.stop();

				inicializarJuego();
				for (int i = 0; i < arregloTitanes.length; i++) {
					if (arregloTitanes[i] != null) {
						arregloTitanes[i] = null;
					}
				}
			}
			this.inicio.contar();
			Image background = Herramientas.cargarImagen("imagenesPantallas/"
					+ "gameover0.png");
			entorno.dibujarImagen(background, 400, 400, 0);
			this.inicio.dibujarPantallaGameOver(entorno);
		}

		if (this.erengameover) {

			if (entorno.sePresiono(entorno.TECLA_SHIFT)) {
				if (sonido.getClip() != null)
					this.sonido.stop();

				inicializarJuego();
				for (int i = 0; i < arregloTitanes.length; i++) {
					if (arregloTitanes[i] != null) {
						arregloTitanes[i] = null;

					}
				}
			}
			this.inicio.contar();
			Image background = Herramientas.cargarImagen("imagenesPantallas/"
					+ "gameovereren100.png");
			entorno.dibujarImagen(background, 400, 400, 0);
			this.inicio.dibujarPantallaGameOverEren(entorno);

		}

		/*******************************************************************
		 * 
		 * Ending
		 * 
		 * /
		 *******************************************************************/

		if (this.ending) {

			if (this.esperar) {
				esperar();
				this.esperar = false;
			}

			this.inicio.contar();
			Image background = Herramientas.cargarImagen("imagenesPantallas/"
					+ "ending00.png");
			entorno.dibujarImagen(background, 400, 400, 0);
			this.inicio.ending(entorno);
			if (entorno.sePresiono(entorno.TECLA_SHIFT)) {
				if (sonido.getClip() != null)
					this.sonido.stop();
				inicializarJuego();
				this.ending = false;
				this.pantallaInicio = true;
			}

		}

		/*******************************************************************
		 * 
		 * Juego
		 * 
		 * /
		 *******************************************************************/

		if (pantallaInicio == false && this.gameover == false && 
				this.erengameover == false && this.ending == false
				&& this.seleccion == false && this.dificultad == false) {

			Image background;
			if (jugador2)
				background = Herramientas.cargarImagen("imagenes/background2.png");
			else
				background = Herramientas.cargarImagen("imagenes/background1.png");
			entorno.dibujarImagen(background, 400, 400, 0);
			this.casa1.dibujarObstaculo(entorno);
			this.casa2.dibujarObstaculo(entorno);
			this.estatua.dibujarObstaculo(entorno);
			this.casa3.dibujarObstaculo(entorno);
			this.casa4.dibujarObstaculo(entorno);
			this.farol1.dibujarObstaculo(entorno);
			this.casa5.dibujarObstaculo(entorno);
			this.casa6.dibujarObstaculo(entorno);
			this.casa7.dibujarObstaculo(entorno);
			this.mikasa.dibujarPersonaje(entorno);
			this.mikasa.dibujarVidas(entorno);

			if (jugador2) {
				this.eren.dibujarPersonaje(entorno);
				this.eren.dibujarVidas(entorno);
			}

			if (this.titanColosalActivo && this.colosal != null)
				this.colosal.dibujarTitan(entorno);

			/*******************************************************************
			 * 
			 * Contador titanes derrotados y tiempo restante
			 * 
			 * /
			 *******************************************************************/

			this.entorno.cambiarFont("Consolas", 50, Color.LIGHT_GRAY);
			this.entorno.escribirTexto(String.valueOf(titanesMuertos), 290, 90);
			this.tiempo--;
			tiempo();
			this.entorno.escribirTexto(String.valueOf(this.minutos), 650, 130);
			this.entorno.escribirTexto(String.valueOf(":"), 680, 130);
			this.entorno.escribirTexto(String.valueOf(this.segundos), 710, 130);

			if (this.tiempo == 0) {
				this.gameover = true;
				musica();
			}

			/*******************************************************************
			 * 
			 * Disparos Mikasa
			 * 
			 * /
			 *******************************************************************/

			if (this.entorno.sePresiono(this.entorno.TECLA_ENTER) && 
					disparoActivado == false) {

				Herramientas.play("sonidos/disparo.wav");

				if (this.mikasa.getOrientacion() == 0)
					this.bala = new Proyectil(this.mikasa.getX(), 
							this.mikasa.getY() + 30, 0, 0.20);

				if (this.mikasa.getOrientacion() == 3)
					this.bala = new Proyectil(this.mikasa.getX() + 30, 
							this.mikasa.getY(), 0, 0.20);

				if (this.mikasa.getOrientacion() == 2)
					this.bala = new Proyectil(this.mikasa.getX(), 
							this.mikasa.getY() - 50, 0, 0.20);

				if (this.mikasa.getOrientacion() == 1)
					this.bala = new Proyectil(this.mikasa.getX() - 30, 
							this.mikasa.getY(), 0, 0.20);

				this.bala.orientacionProyectil(this.mikasa.getOrientacion());
				this.direccionDisparo = this.mikasa.getOrientacion();
				disparoActivado = true;
			}

			if (this.direccionDisparo == 0 && disparoActivado == true && 
					this.bala.getY() < entorno.alto()) {

				this.bala.dibujarProyectil(entorno);
				this.bala.setY(6);
				if (this.bala.getY() >= entorno.alto())
					this.disparoActivado = false;
			}

			if (this.direccionDisparo == 3 && disparoActivado == true && 
					this.bala.getX() < entorno.ancho()) {

				this.bala.dibujarProyectil(entorno);
				this.bala.setX(6);
				if (this.bala.getX() >= entorno.ancho())
					this.disparoActivado = false;
			}

			if (this.direccionDisparo == 2 && disparoActivado == true && 
					this.bala.getY() > 0) {

				this.bala.dibujarProyectil(entorno);
				this.bala.setY(-6);
				if (this.bala.getY() <= 0)
					this.disparoActivado = false;
			}

			if (this.direccionDisparo == 1 && disparoActivado == true && 
					this.bala.getX() > 0) {

				this.bala.dibujarProyectil(entorno);
				this.bala.setX(-6);
				if (this.bala.getX() <= 0)
					this.disparoActivado = false;
			}

			/*******************************************************************
			 * 
			 * Disparos Eren
			 * 
			 * /
			 *******************************************************************/

			if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO) && 
					disparoActivadoEren == false && jugador2) {

				Herramientas.play("sonidos/disparo.wav");

				if (this.eren.getOrientacion() == 0)
					this.balaEren = new Proyectil(this.eren.getX(), 
							this.eren.getY() + 30, 0, 0.20);

				if (this.eren.getOrientacion() == 3)
					this.balaEren = new Proyectil(this.eren.getX() + 30, 
							this.eren.getY(), 0, 0.20);

				if (this.eren.getOrientacion() == 2)
					this.balaEren = new Proyectil(this.eren.getX(), 
							this.eren.getY() - 50, 0, 0.20);

				if (this.eren.getOrientacion() == 1)
					this.balaEren = new Proyectil(this.eren.getX() - 30, 
							this.eren.getY(), 0, 0.20);

				this.balaEren.orientacionProyectil(this.eren.getOrientacion());
				this.direccionDisparoEren = this.eren.getOrientacion();
				disparoActivadoEren = true;

			}

			if (this.direccionDisparoEren == 0 && disparoActivadoEren == true
					&& this.balaEren.getY() < entorno.alto()) {
				this.balaEren.dibujarProyectil(entorno);
				this.balaEren.setY(6);
				if (this.balaEren.getY() >= entorno.alto())
					this.disparoActivadoEren = false;
			}

			if (this.direccionDisparoEren == 3 && disparoActivadoEren == true
					&& this.balaEren.getX() < entorno.ancho()) {
				this.balaEren.dibujarProyectil(entorno);
				this.balaEren.setX(6);
				if (this.balaEren.getX() >= entorno.ancho())
					this.disparoActivadoEren = false;
			}

			if (this.direccionDisparoEren == 2 && disparoActivadoEren == true && 
					this.balaEren.getY() > 0) {
				this.balaEren.dibujarProyectil(entorno);
				this.balaEren.setY(-6);
				if (this.balaEren.getY() <= 0)
					this.disparoActivadoEren = false;
			}

			if (this.direccionDisparoEren == 1 && disparoActivadoEren == true && 
					this.balaEren.getX() > 0) {
				this.balaEren.dibujarProyectil(entorno);
				this.balaEren.setX(-6);
				if (this.balaEren.getX() <= 0)
					this.disparoActivadoEren = false;
			}

			/*******************************************************************
			 * 
			 * Movimientos Mikasa
			 * 
			 * /
			 *******************************************************************/

			if (this.entorno.sePresiono(this.entorno.TECLA_IZQUIERDA))
				this.mikasa.girarIzquierda();

			if (this.entorno.sePresiono(this.entorno.TECLA_DERECHA))
				this.mikasa.girarDerecha();

			if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) {

				if (this.mikasa.getX() >= 30 && this.mikasa.getX() <= 
						entorno.ancho() - 30 && this.mikasa.getY() >= 30
						&& this.mikasa.getY() <= entorno.alto() - 30) {

					for (int i = 0; i < this.obstaculos.length; i++) {
						if (this.mikasa.getYAbajo() < 
								obstaculos[i].getPosicionObstaculoYarriba()
								|| this.mikasa.getY() > 
						obstaculos[i].getPosicionObstaculoYabajo()
								|| this.mikasa.getXIzquierda() > 
						obstaculos[i].getPosicionObstaculoXderecha()
								|| this.mikasa.getXDerecha() < 
								obstaculos[i].getPosicionObstaculoXizquierda()) {

							this.mikasa.avanzar(this.mikasa.getVelocidad());

						} else {
							this.mikasa.girarDerecha();
							this.mikasa.girarDerecha();
							this.mikasa.avanzar(3);

						}
					}

				} else {
					if (this.mikasa.getY() > entorno.alto() - 30)
						this.mikasa.setY(765);
					else if (this.mikasa.getY() <= 30)
						this.mikasa.setY(30);
					else if (this.mikasa.getX() > entorno.ancho() - 30)
						this.mikasa.setX(entorno.ancho() - 30);
					else if (this.mikasa.getX() < 30)
						this.mikasa.setX(30);

				}
			}

			if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {

				if (this.mikasa.getX() >= 20 && this.mikasa.getX() <= 
						entorno.ancho() - 20 && this.mikasa.getY() >= 20
						&& this.mikasa.getY() <= entorno.alto() - 20) {

					for (int i = 0; i < obstaculos.length; i++) {
						if (this.mikasa.getYAbajo() <= 
								obstaculos[i].getPosicionObstaculoYarriba()
								|| this.mikasa.getY() >= 
								obstaculos[i].getPosicionObstaculoYabajo()
								|| this.mikasa.getXIzquierda() >= 
								obstaculos[i].getPosicionObstaculoXderecha()
								|| this.mikasa.getXDerecha() <= 
								obstaculos[i].getPosicionObstaculoXizquierda()) {

							this.mikasa.retroceder(this.mikasa.getVelocidad());

						} else {
							
							this.mikasa.girarDerecha();
							this.mikasa.girarDerecha();
							this.mikasa.retroceder(5);

						}
					}
				}
			}

			/*******************************************************************
			 * 
			 * Movimientos Eren
			 * 
			 * /
			 *******************************************************************/

			if (jugador2) {

				if (this.entorno.sePresiono('a'))
					this.eren.girarIzquierda();

				if (this.entorno.sePresiono('d'))
					this.eren.girarDerecha();

				if (this.entorno.estaPresionada('w')) {

					if (this.eren.getX() >= 30 && this.eren.getX() <= 770 && 
							this.eren.getY() >= 30
							&& this.eren.getY() <= 770) {

						for (int i = 0; i < this.obstaculos.length; i++) {
							if (this.eren.getYAbajo() < 
									obstaculos[i].getPosicionObstaculoYarriba()
									|| this.eren.getY() > 
							obstaculos[i].getPosicionObstaculoYabajo()
									|| this.eren.getXIzquierda() > 
							obstaculos[i].getPosicionObstaculoXderecha()
									|| this.eren.getXDerecha() < 
									obstaculos[i].getPosicionObstaculoXizquierda()) {

								this.eren.avanzar(this.eren.getVelocidad());

							} else {
								this.eren.girarDerecha();
								this.eren.girarDerecha();
								this.eren.avanzar(5);

							}
						}

					} else {
						if (this.eren.getY() > 770)
							this.eren.setY(765);
						else if (this.eren.getY() <= 30)
							this.eren.setY(35);
						else if (this.eren.getX() > 770)
							this.eren.setX(765);
						else if (this.eren.getX() < 30)
							this.eren.setX(35);

					}
				}

				if (this.entorno.estaPresionada('s')) {

					if (this.eren.getX() >= 20 && this.eren.getX() <= 
							entorno.ancho() - 20 && this.eren.getY() >= 20
							&& this.eren.getY() <= entorno.alto() - 20) {

						for (int i = 0; i < obstaculos.length; i++) {
							if (this.eren.getYAbajo() <= 
									obstaculos[i].getPosicionObstaculoYarriba()
									|| this.eren.getY() >= 
									obstaculos[i].getPosicionObstaculoYabajo()
									|| this.eren.getXIzquierda() >= 
									obstaculos[i].getPosicionObstaculoXderecha()
									|| this.eren.getXDerecha() <= 
									obstaculos[i].getPosicionObstaculoXizquierda()) {

								this.eren.retroceder(this.eren.getVelocidad());

							} else {
								this.eren.girarDerecha();
								this.eren.girarDerecha();
								this.eren.retroceder(5);
							}
						}
					}
				}

			}

			/*******************************************************************
			 * 
			 * Titanes
			 * 
			 * /
			 *******************************************************************/

			int contadorTitanes = 0;

			for (int j = 0; j < arregloTitanes.length; j++) {

				if (arregloTitanes[j] == null)
					contadorTitanes++;

				if (contadorTitanes == 5 && this.facil)
					crearTitanes();

				if (contadorTitanes == 3 && this.normal)
					crearTitanes();

				if (contadorTitanes == 1 && this.dificil)
					crearTitanes();

				for (int k = 0; k < arregloTitanes.length; k++) {

					if (j != k && arregloTitanes[j] != null && 
							arregloTitanes[k] != null) {

						if (arregloTitanes[j].getYAbajo() <= 
								arregloTitanes[k].getYAbajo()
								&& arregloTitanes[j].getYAbajo() >= 
								arregloTitanes[k].getYArriba()
								&& arregloTitanes[j].getXDerecha() >= 
								arregloTitanes[k].getXIzquierda()
								&& arregloTitanes[j].getXDerecha() <= 
								arregloTitanes[k].getXDerecha()) {

							arregloTitanes[j].moverY(-1);
							arregloTitanes[j].moverX(-1);
						}

						if (arregloTitanes[j].getYArriba() <= 
								arregloTitanes[k].getYAbajo()
								&& arregloTitanes[j].getYArriba() >= 
								arregloTitanes[k].getYArriba()
								&& arregloTitanes[j].getXDerecha() >= 
								arregloTitanes[k].getXIzquierda()
								&& arregloTitanes[j].getXDerecha() <= 
								arregloTitanes[k].getXDerecha()) {

							arregloTitanes[j].moverY(1);
							arregloTitanes[j].moverX(-1);
						}

						if (arregloTitanes[j].getYAbajo() <= 
								arregloTitanes[k].getYAbajo()
								&& arregloTitanes[j].getYAbajo() >= 
								arregloTitanes[k].getYArriba()
								&& arregloTitanes[j].getXIzquierda() <= 
								arregloTitanes[k].getXDerecha()
								&& arregloTitanes[j].getXIzquierda() >= 
								arregloTitanes[k].getXIzquierda()) {

							arregloTitanes[j].moverY(-1);
							arregloTitanes[j].moverX(1);
						}

						if (arregloTitanes[j].getYArriba() >= 
								arregloTitanes[k].getYArriba()
								&& arregloTitanes[j].getYArriba() <= 
								arregloTitanes[k].getYAbajo()
								&& arregloTitanes[j].getXIzquierda() <= 
								arregloTitanes[k].getXDerecha()
								&& arregloTitanes[j].getXIzquierda() >= 
								arregloTitanes[k].getXIzquierda()) {

							arregloTitanes[j].moverY(1);
							arregloTitanes[j].moverX(1);
						}

					}
				}

				/****************************************************************
				 * 
				 * Creacion objetos
				 * 
				 * /
				 ****************************************************************/

				if (this.facil) {

					if (titanesMuertos % 2 == 0 && titanesMuertos != 0 && 
							this.mikasa.getMikasaTitan() == false
							&& sueroCreado == false) {
						crearSuero();
						sueroCreado = true;

					}

					if (titanesMuertos % 3 == 0 && this.mikasa.getVidas() <= 
							4 && botiquinCreado == false) {
						crearBotiquin();
						botiquinCreado = true;

					}
				}

				if (this.normal) {

					if (titanesMuertos % 5 == 0 && titanesMuertos != 0 && 
							this.mikasa.getMikasaTitan() == false
							&& sueroCreado == false) {
						crearSuero();
						sueroCreado = true;

					}

					if (titanesMuertos % 6 == 0 && this.mikasa.getVidas() <= 3 &&
							botiquinCreado == false) {
						crearBotiquin();
						botiquinCreado = true;

					}
				}

				if (this.dificil) {

					if (titanesMuertos % 10 == 0 && titanesMuertos != 0 &&
							this.mikasa.getMikasaTitan() == false
							&& sueroCreado == false) {
						crearSuero();
						sueroCreado = true;

					}

					if (titanesMuertos % 12 == 0 && this.mikasa.getVidas() <= 1 &&
							botiquinCreado == false) {
						crearBotiquin();
						botiquinCreado = true;

					}
				}

				if (botiquinCreado && this.botiquin != null) {

					this.botiquin.dibujarBotiquin(entorno);

					/*******************************************************************
					 * 
					 * Curacion Mikasa
					 * 
					 * /
					 *******************************************************************/

					if (this.mikasa.getYAbajo() > this.botiquin.getYarriba()
							&& this.mikasa.getY() < this.botiquin.getYabajo()
							&& this.mikasa.getXIzquierda() > this.botiquin.getXizquierda()
							&& this.mikasa.getXDerecha() < this.botiquin.getXderecha()) {

						Herramientas.play("sonidos/curacion.wav");
						this.mikasa.sumarVidas(1);

						this.botiquin = null;
						botiquinCreado = false;

					}

				}

				/*******************************************************************
				 * 
				 * Curacion Eren
				 * 
				 * /
				 *******************************************************************/
				if (botiquinCreado && this.botiquin != null) {

					this.botiquin.dibujarBotiquin(entorno);

					if (jugador2 && this.eren.getYAbajo() > this.botiquin.getYarriba()
							&& this.eren.getY() < this.botiquin.getYabajo()
							&& this.eren.getXIzquierda() > this.botiquin.getXizquierda()
							&& this.eren.getXDerecha() < this.botiquin.getXderecha()) {

						Herramientas.play("sonidos/curacion.wav");
						this.eren.sumarVidas(1);
						this.botiquin = null;
						botiquinCreado = false;

					}
				}

				/*******************************************************************
				 * 
				 * Suero Mikasa
				 * 
				 * /
				 *******************************************************************/

				if (sueroCreado && this.suero != null) {

					this.suero.dibujarSuero(entorno);

					if (this.mikasa.getMikasaTitan() == false && 
							this.mikasa.getYAbajo() > this.suero.getYarriba()
							&& this.mikasa.getY() < this.suero.getYabajo()
							&& this.mikasa.getXIzquierda() > this.suero.getXizquierda()
							&& this.mikasa.getXDerecha() < this.suero.getXderecha()) {

						Herramientas.play("sonidos/transformacion.wav");
						this.mikasa.setAlto(100);
						this.mikasa.setMikasaTitan(true);
						this.suero = null;
						sueroCreado = false;

					}
				}

				/*******************************************************************
				 * 
				 * Suero Eren
				 * 
				 * /
				 *******************************************************************/

				if (sueroCreado && this.suero != null) {

					this.suero.dibujarSuero(entorno);

					if (jugador2 && this.eren.getErenTitan() == false && 
							this.eren.getYAbajo() > this.suero.getYarriba()
							&& this.eren.getY() < this.suero.getYabajo()
							&& this.eren.getXIzquierda() > this.suero.getXizquierda()
							&& this.eren.getXDerecha() < this.suero.getXderecha()) {

						Herramientas.play("sonidos/erenTransformacion.wav");
						this.eren.setAlto(100);
						this.eren.setErenTitan(true);
						this.suero = null;
						sueroCreado = false;
					}

				}

				/*******************************************************************
				 * 
				 * Transformaciones
				 * 
				 * /
				 *******************************************************************/

				if (this.mikasa.getMikasaTitan() == true && 
						this.mikasa.getEscala() < 1.00)

					this.mikasa.setEscala(0.0005);

				if (this.mikasa.getMikasaTitan() == false && 
						this.mikasa.getEscala() > 0.75) {

					this.mikasa.setAlto(57);
					this.mikasa.setEscala(-0.0005);

				}

				if (jugador2) {

					if (this.eren.getErenTitan() == true && 
							this.eren.getEscala() < 1.00)

						this.eren.setEscala(0.0005);

					if (this.eren.getErenTitan() == false && 
							this.eren.getEscala() > 0.75) {

						this.eren.setAlto(57);
						this.eren.setEscala(-0.0005);
					}
				}

				/*******************************************************************
				 * 
				 * Colision Mikasa
				 * 
				 * /
				 *******************************************************************/

				if (this.mikasa.getMikasaTitan() == true && arregloTitanes[j] != null
						&& this.mikasa.getYAbajo() > arregloTitanes[j].getYArriba()
						&& this.mikasa.getY() < arregloTitanes[j].getYAbajo()
						&& this.mikasa.getXIzquierda() > arregloTitanes[j].getXIzquierda()
						&& this.mikasa.getXDerecha() < arregloTitanes[j].getXDerecha()) {

					arregloTitanes[j].dibujarExplosion(entorno);
					arregloTitanes[j].dibujarExplosion(entorno);
					arregloTitanes[j].dibujarExplosion(entorno);
					Herramientas.play("sonidos/explosion.wav");
					Herramientas.play("sonidos/destranformacion.wav");
					arregloTitanes[j] = null;
					this.titanesMuertos++;
					this.mikasa.setMikasaTitan(false);

				}

				if (this.invencibilidad == false && this.mikasa.getMikasaTitan() == false && 
						arregloTitanes[j] != null
						&& this.mikasa.getYAbajo() >= arregloTitanes[j].getYArriba()
						&& this.mikasa.getYArriba() <= arregloTitanes[j].getYAbajo()
						&& this.mikasa.getXIzquierda() >= arregloTitanes[j].getXIzquierda()
						&& this.mikasa.getXDerecha() <= arregloTitanes[j].getXDerecha()) {

					this.mikasa.restarVidas();
					this.invencibilidad = true;
					if (this.mikasa.getVidas() >= 1)
						Herramientas.play("sonidos/danio.wav");

					if (this.mikasa.getVidas() == 0) {
						this.mikasa.setVidas(5);
						Herramientas.play("sonidos/muerte.wav");
						this.titanesMuertos = 0;
						this.mikasa.setVidas(5);
						this.gameover = true;
						this.musicaIniciada = true;
					}
				}

				/*******************************************************************
				 * 
				 * Colision Eren
				 * 
				 * /
				 *******************************************************************/

				if (jugador2 && this.eren.getErenTitan() == true && 
						arregloTitanes[j] != null
						&& this.eren.getYAbajo() > arregloTitanes[j].getYArriba()
						&& this.eren.getY() < arregloTitanes[j].getYAbajo()
						&& this.eren.getXIzquierda() > arregloTitanes[j].getXIzquierda()
						&& this.eren.getXDerecha() < arregloTitanes[j].getXDerecha()) {

					arregloTitanes[j].dibujarExplosion(entorno);
					arregloTitanes[j].dibujarExplosion(entorno);
					arregloTitanes[j].dibujarExplosion(entorno);
					Herramientas.play("sonidos/explosion.wav");
					Herramientas.play("sonidos/destranformacion.wav");
					arregloTitanes[j] = null;
					this.titanesMuertos++;
					this.eren.setErenTitan(false);

				}

				if (jugador2 && this.invencibilidadEren == false && 
						this.eren.getErenTitan() == false
						&& arregloTitanes[j] != null && 
						this.eren.getYAbajo() >= arregloTitanes[j].getYArriba()
						&& this.eren.getYArriba() <= arregloTitanes[j].getYAbajo()
						&& this.eren.getXIzquierda() >= arregloTitanes[j].getXIzquierda()
						&& this.eren.getXDerecha() <= arregloTitanes[j].getXDerecha()) {

					this.eren.restarVidas();
					this.invencibilidadEren = true;
					if (this.eren.getVidas() >= 1)
						Herramientas.play("sonidos/erendanio.wav");

					if (this.eren.getVidas() == 0) {
						this.eren.setVidas(5);
						Herramientas.play("sonidos/erenmuerto.wav");
						this.titanesMuertos = 0;
						this.eren.setVidas(5);
						this.erengameover = true;
						this.musicaIniciada = true;
					}
				}

				// Dibujar Titanes ya creados

				if (arregloTitanes[j] != null) {
					arregloTitanes[j].dibujarTitan(entorno);

					/*******************************************************************
					 * 
					 * Colision Disparos Mikasa
					 * 
					 * /
					 *******************************************************************/

					if (this.disparoActivado) {
						if (this.bala.getX() < arregloTitanes[j].getXDerecha()
								&& this.bala.getX() > arregloTitanes[j].getXIzquierda()
								&& this.bala.getY() > arregloTitanes[j].getYArriba()
								&& this.bala.getY() < arregloTitanes[j].getYAbajo()) {

							Herramientas.play("sonidos/explosion.wav");
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j] = null;
							this.titanesMuertos++;
							this.disparoActivado = false;
						}
					}

					for (int i = 0; i < obstaculos.length; i++) {

						if (this.disparoActivado) {
							if (this.bala.getX() < 
									obstaculos[i].getPosicionObstaculoXderecha()
									&& this.bala.getX() > 
							obstaculos[i].getPosicionObstaculoXizquierda()
									&& this.bala.getY() > 
							obstaculos[i].getPosicionObstaculoYarriba()
									&& this.bala.getY() < 
									obstaculos[i].getPosicionObstaculoYabajo())

								this.disparoActivado = false;
						}
					}
				}

				/*******************************************************************
				 * 
				 * Colision Disparos Eren
				 * 
				 * /
				 *******************************************************************/
				if (arregloTitanes[j] != null) {
					arregloTitanes[j].dibujarTitan(entorno);
					if (jugador2 && this.disparoActivadoEren) {
						if (this.balaEren.getX() < arregloTitanes[j].getXDerecha()
								&& this.balaEren.getX() > arregloTitanes[j].getXIzquierda()
								&& this.balaEren.getY() > arregloTitanes[j].getYArriba()
								&& this.balaEren.getY() < arregloTitanes[j].getYAbajo()) {

							Herramientas.play("sonidos/explosion.wav");
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j].dibujarExplosion(entorno);
							arregloTitanes[j] = null;
							this.titanesMuertos++;
							this.disparoActivadoEren = false;
						}

					}
				}

				for (int i = 0; i < obstaculos.length; i++) {

					if (this.disparoActivadoEren) {
						if (this.balaEren.getX() < 
								obstaculos[i].getPosicionObstaculoXderecha()
								&& this.balaEren.getX() > 
						obstaculos[i].getPosicionObstaculoXizquierda()
								&& this.balaEren.getY() > 
						obstaculos[i].getPosicionObstaculoYarriba()
								&& this.balaEren.getY() < 
								obstaculos[i].getPosicionObstaculoYabajo())

							this.disparoActivadoEren = false;

					}

					/*******************************************************************
					 * 
					 * Titan Colosal
					 * 
					 * /
					 *******************************************************************/

					if (this.titanColosalActivo && this.colosal != null) {

						if (this.colosal.getX() <= this.mikasa.getX() && 
								this.colosal.getY() > this.mikasa.getY()) {

							this.colosal.contar();
							this.colosal.animaciónEspaldas();
							this.colosal.moverX(0.01);
							this.colosal.moverY(-0.01);

						}

						if (this.colosal.getX() <= this.mikasa.getX() && 
								this.colosal.getY() < this.mikasa.getY()) {

							this.colosal.contar();
							this.colosal.animaciónDerecha();
							this.colosal.moverX(0.01);
							this.colosal.moverY(0.01);

						}

						if (this.colosal.getX() > this.mikasa.getX() && 
								this.colosal.getY() < this.mikasa.getY()) {

							this.colosal.contar();
							this.colosal.animaciónFrente();
							this.colosal.moverX(-0.01);
							this.colosal.moverY(0.01);

						}

						if (this.colosal.getX() > this.mikasa.getX() && 
								this.colosal.getY() > this.mikasa.getY()) {

							this.colosal.contar();
							this.colosal.animaciónIzquierda();
							this.colosal.moverX(-0.01);
							this.colosal.moverY(-0.01);

						}

						/*******************************************************************
						 * 
						 * Titan Colosal colision titanes
						 * 
						 * /
						 *******************************************************************/

						if (arregloTitanes[j] != null) {

							if (arregloTitanes[j].getYAbajo() <= 
									this.colosal.getYAbajo()
									&& arregloTitanes[j].getYAbajo() >= 
									this.colosal.getYArriba()
									&& arregloTitanes[j].getXDerecha() >= 
									this.colosal.getXIzquierda()
									&& arregloTitanes[j].getXDerecha() <= 
									this.colosal.getXDerecha()) {

								arregloTitanes[j].moverY(-1);
								arregloTitanes[j].moverX(-1);
							}

							if (arregloTitanes[j].getYArriba() <= 
									this.colosal.getYAbajo()
									&& arregloTitanes[j].getYArriba() >= 
									this.colosal.getYArriba()
									&& arregloTitanes[j].getXDerecha() >= 
									this.colosal.getXIzquierda()
									&& arregloTitanes[j].getXDerecha() <= 
									this.colosal.getXDerecha()) {

								arregloTitanes[j].moverY(1);
								arregloTitanes[j].moverX(-1);
							}

							if (arregloTitanes[j].getYAbajo() <= 
									this.colosal.getYAbajo()
									&& arregloTitanes[j].getYAbajo() >= 
									this.colosal.getYArriba()
									&& arregloTitanes[j].getXIzquierda() <= 
									this.colosal.getXDerecha()
									&& arregloTitanes[j].getXIzquierda() >= 
									this.colosal.getXIzquierda()) {

								arregloTitanes[j].moverY(-1);
								arregloTitanes[j].moverX(1);
							}

							if (arregloTitanes[j].getYArriba() >= 
									this.colosal.getYArriba()
									&& arregloTitanes[j].getYArriba() <= 
									this.colosal.getYAbajo()
									&& arregloTitanes[j].getXIzquierda() <= 
									this.colosal.getXDerecha()
									&& arregloTitanes[j].getXIzquierda() >= 
									this.colosal.getXIzquierda()) {

								arregloTitanes[j].moverY(1);
								arregloTitanes[j].moverX(1);
							}
						}

						/*******************************************************************
						 * 
						 * Titan Colosal Impacto Mikasa
						 * 
						 * /
						 *******************************************************************/

						if (this.invencibilidad == false && 
								this.mikasa.getMikasaTitan() == true

								&& this.mikasa.getYAbajo() >= this.colosal.getYArriba()
								&& this.mikasa.getYArriba() <= this.colosal.getYAbajo()
								&& this.mikasa.getXIzquierda() >= this.colosal.getXIzquierda()
								&& this.mikasa.getXDerecha() <= this.colosal.getXDerecha()) {

							this.colosal.dibujarExplosion(entorno);
							Herramientas.play("sonidos/explosion.wav");
							Herramientas.play("sonidos/destranformacion.wav");
							this.mikasa.setMikasaTitan(false);

							this.invencibilidad = true;

						}

						if (this.invencibilidad == false && 
								this.mikasa.getMikasaTitan() == false

								&& this.mikasa.getYAbajo() >= this.colosal.getYArriba()
								&& this.mikasa.getYArriba() <= this.colosal.getYAbajo()
								&& this.mikasa.getXIzquierda() >= this.colosal.getXIzquierda()
								&& this.mikasa.getXDerecha() <= this.colosal.getXDerecha()) {

							this.mikasa.restarVidas();
							this.invencibilidad = true;
							if (this.mikasa.getVidas() >= 1) {
								Herramientas.play("sonidos/danio.wav");
							}

							if (this.mikasa.getVidas() == 0) {
								this.mikasa.setVidas(5);
								Herramientas.play("sonidos/muerte.wav");
								this.titanesMuertos = 0;
								this.mikasa.setVidas(5);
								this.gameover = true;
								titanColosalActivo = false;
								this.musicaIniciada = true;
							}
						}

						/*******************************************************************
						 * 
						 * Titan Colosal Impacto Eren
						 * 
						 * /
						 *******************************************************************/

						if (this.invencibilidadEren == false && 
								this.eren.getErenTitan() == true

								&& this.eren.getYAbajo() >= this.colosal.getYArriba()
								&& this.eren.getYArriba() <= this.colosal.getYAbajo()
								&& this.eren.getXIzquierda() >= this.colosal.getXIzquierda()
								&& this.eren.getXDerecha() <= this.colosal.getXDerecha()) {

							this.colosal.dibujarExplosion(entorno);
							Herramientas.play("sonidos/explosion.wav");
							Herramientas.play("sonidos/destranformacion.wav");
							this.eren.setErenTitan(false);

							this.invencibilidadEren = true;

						}

						if (this.invencibilidadEren == false && 
								this.eren.getErenTitan() == false

								&& this.eren.getYAbajo() >= this.colosal.getYArriba()
								&& this.eren.getYArriba() <= this.colosal.getYAbajo()
								&& this.eren.getXIzquierda() >= this.colosal.getXIzquierda()
								&& this.eren.getXDerecha() <= this.colosal.getXDerecha()) {

							this.eren.restarVidas();
							this.invencibilidadEren = true;
							if (this.eren.getVidas() >= 1) {
								Herramientas.play("sonidos/erendanio.wav");
							}

							if (this.eren.getVidas() == 0) {
								this.eren.setVidas(5);
								Herramientas.play("sonidos/erenmuerto.wav");
								this.titanesMuertos = 0;
								this.eren.setVidas(5);
								this.erengameover = true;
								titanColosalActivo = false;
								this.musicaIniciada = true;
							}
						}

						/*******************************************************************
						 * 
						 * Titan Colosal Disparos Mikasa
						 * 
						 * /
						 *******************************************************************/

						if (this.disparoActivado && this.titanColosalActivo) {
							if (this.bala.getX() < this.colosal.getXDerecha()
									&& this.bala.getX() > this.colosal.getXIzquierda()
									&& this.bala.getY() > this.colosal.getYArriba()
									&& this.bala.getY() < this.colosal.getYAbajo()) {

								Herramientas.play("sonidos/explosion.wav");
								this.colosal.dibujarExplosion(entorno);
								this.colosal.dibujarExplosion(entorno);
								this.colosal.dibujarExplosion(entorno);
								this.colosal.dibujarExplosion(entorno);

								if (this.colosal.getVidas() <= 30 && 
										this.colosal.getVidas() > 0)
									this.colosal.restarVidas();
								if (this.colosal.getVidas() == 0) {
									this.colosal.explotar(entorno);
									this.colosal.explotar(entorno);
									this.colosal.explotar(entorno);
									this.colosal.explotar(entorno);
									this.colosal = null;
									titanColosalActivo = false;

									for (int l = 0; l < arregloTitanes.length; l++) {

										if (arregloTitanes[l] != null) {
											arregloTitanes[l].dibujarExplosion(entorno);
											arregloTitanes[l].dibujarExplosion(entorno);
											arregloTitanes[l].dibujarExplosion(entorno);
											arregloTitanes[l].dibujarExplosion(entorno);

											arregloTitanes[l] = null;

										}
									}
									if (sonido.getClip() != null)
										this.sonido.stop();
									this.titanColosalActivo = false;
									this.ending = true;

									musica();
								}
								this.disparoActivado = false;
							}
						}

						/*******************************************************************
						 * 
						 * Titan Colosal Disparos Eren
						 * 
						 * /
						 *******************************************************************/

						if (this.disparoActivadoEren && this.titanColosalActivo) {
							if (this.balaEren.getX() < this.colosal.getXDerecha()
									&& this.balaEren.getX() > this.colosal.getXIzquierda()
									&& this.balaEren.getY() > this.colosal.getYArriba()
									&& this.balaEren.getY() < this.colosal.getYAbajo()) {

								Herramientas.play("sonidos/explosion.wav");
								this.colosal.dibujarExplosion(entorno);
								this.colosal.dibujarExplosion(entorno);
								this.colosal.dibujarExplosion(entorno);
								this.colosal.dibujarExplosion(entorno);

								if (this.colosal.getVidas() <= 30 && 
										this.colosal.getVidas() > 0)
									this.colosal.restarVidas();
								if (this.colosal.getVidas() == 0) {
									this.colosal.explotar(entorno);
									this.colosal.explotar(entorno);
									this.colosal.explotar(entorno);
									this.colosal.explotar(entorno);
									this.colosal = null;
									titanColosalActivo = false;

									for (int l = 0; l < arregloTitanes.length; l++) {

										if (arregloTitanes[l] != null) {
											arregloTitanes[l].dibujarExplosion(entorno);
											arregloTitanes[l].dibujarExplosion(entorno);
											arregloTitanes[l].dibujarExplosion(entorno);
											arregloTitanes[l].dibujarExplosion(entorno);

											arregloTitanes[l] = null;

										}
									}

									if (sonido.getClip() != null)
										this.sonido.stop();
									this.titanColosalActivo = false;
									this.ending = true;
									musica();
								}
								this.disparoActivadoEren = false;
							}
						}

						/*******************************************************************
						 * 
						 * Movimiento Titan Colosal
						 * 
						 * /
						 *******************************************************************/

						if (this.colosal != null) {

							if (this.colosal.getY() >= 
									obstaculos[i].getPosicionObstaculoYabajo()
									|| this.colosal.getYAbajo() <= 
									obstaculos[i].getPosicionObstaculoYarriba()
									|| this.colosal.getXIzquierda() >= 
									obstaculos[i].getPosicionObstaculoXderecha()
									|| this.colosal.getXDerecha() <= 
									obstaculos[i].getPosicionObstaculoXizquierda()) {

								if (this.colosal.getX() <= this.mikasa.getX()
										&& this.colosal.getY() > this.mikasa.getY()) {

									this.colosal.contar();
									this.colosal.animaciónEspaldas();
									this.colosal.moverX(0.01);
									this.colosal.moverY(-0.01);

								}

								if (this.colosal.getX() <= this.mikasa.getX()
										&& this.colosal.getY() < this.mikasa.getY()) {
									this.colosal.contar();
									this.colosal.animaciónDerecha();
									this.colosal.moverX(0.01);
									this.colosal.moverY(0.01);

								}

								if (this.colosal.getX() > this.mikasa.getX()
										&& this.colosal.getY() < this.mikasa.getY()) {
									this.colosal.contar();
									this.colosal.animaciónFrente();
									this.colosal.moverX(-0.01);
									this.colosal.moverY(0.01);

								}

								if (this.colosal.getX() > this.mikasa.getX()
										&& this.colosal.getY() > this.mikasa.getY()) {
									this.colosal.contar();
									this.colosal.animaciónIzquierda();
									this.colosal.moverX(-0.01);
									this.colosal.moverY(-0.01);

								}

							} else {

								if (this.colosal.getXDerecha() >= 
										obstaculos[i].getPosicionObstaculoXizquierda()
										&& this.colosal.getXIzquierda() <= obstaculos[i]
												.getPosicionObstaculoXizquierda()) {

									this.colosal.moverX(-0.20);
									this.colosal.moverY(-0.20);
								}

								if (this.colosal.getXIzquierda() <= 
										obstaculos[i].getPosicionObstaculoXderecha()
										&& this.colosal.getXDerecha() >= 
										obstaculos[i].getPosicionObstaculoXderecha()) {

									this.colosal.moverX(0.20);
									this.colosal.moverY(0.20);
								}

								if (this.colosal.getYAbajo() >= 
										obstaculos[i].getPosicionObstaculoYarriba()
										&& this.colosal.getYArriba() <= 
										obstaculos[i].getPosicionObstaculoYarriba()) {

									this.colosal.moverY(-0.20);
								}

								if (this.colosal.getYAbajo() >= 
										obstaculos[i].getPosicionObstaculoYabajo()
										&& this.colosal.getYArriba() <= 
										obstaculos[i].getPosicionObstaculoYabajo()) {

									this.colosal.moverY(0.20);
								}

							}

						}

					}

					/*******************************************************************
					 * 
					 * Titanes Colision obstaculos
					 * 
					 * /
					 *******************************************************************/

					if (arregloTitanes[j] != null) {

						if (arregloTitanes[j].getY() >= 
								obstaculos[i].getPosicionObstaculoYabajo()
								|| arregloTitanes[j].getYAbajo() <= 
								obstaculos[i].getPosicionObstaculoYarriba()
								|| arregloTitanes[j].getXIzquierda() >= 
								obstaculos[i].getPosicionObstaculoXderecha()
								|| arregloTitanes[j].getXDerecha() <= 
								obstaculos[i].getPosicionObstaculoXizquierda()) {

							if (arregloTitanes[j].getX() <= this.mikasa.getX()
									&& arregloTitanes[j].getY() > this.mikasa.getY()) {

								arregloTitanes[j].contar();
								arregloTitanes[j].animaciónEspaldas();
								arregloTitanes[j].moverX(arregloTitanes[j].getVelocidad());
								arregloTitanes[j].moverY(arregloTitanes[j].getVelocidad() * -1);

							}

							if (arregloTitanes[j].getX() <= this.mikasa.getX()
									&& arregloTitanes[j].getY() < this.mikasa.getY()) {
								arregloTitanes[j].contar();
								arregloTitanes[j].animaciónDerecha();
								arregloTitanes[j].moverX(arregloTitanes[j].getVelocidad());
								arregloTitanes[j].moverY(arregloTitanes[j].getVelocidad());

							}

							if (arregloTitanes[j].getX() > this.mikasa.getX()
									&& arregloTitanes[j].getY() < this.mikasa.getY()) {
								arregloTitanes[j].contar();
								arregloTitanes[j].animaciónFrente();
								arregloTitanes[j].moverX(arregloTitanes[j].getVelocidad() * -1);
								arregloTitanes[j].moverY(arregloTitanes[j].getVelocidad());

							}

							if (arregloTitanes[j].getX() > this.mikasa.getX()
									&& arregloTitanes[j].getY() > this.mikasa.getY()) {
								arregloTitanes[j].contar();
								arregloTitanes[j].animaciónIzquierda();
								arregloTitanes[j].moverX(arregloTitanes[j].getVelocidad() * -1);
								arregloTitanes[j].moverY(arregloTitanes[j].getVelocidad() * -1);

							}

						} else {

							if (arregloTitanes[j].getXDerecha() >= 
									obstaculos[i].getPosicionObstaculoXizquierda()
									&& arregloTitanes[j].getXIzquierda() <= 
									obstaculos[i].getPosicionObstaculoXizquierda()) {

								arregloTitanes[j].moverX(-2);
								arregloTitanes[j].moverY(-2);
							}

							if (arregloTitanes[j].getXIzquierda() <= 
									obstaculos[i].getPosicionObstaculoXderecha()
									&& arregloTitanes[j].getXDerecha() >= obstaculos[i]
											.getPosicionObstaculoXderecha()) {

								arregloTitanes[j].moverX(2);
								arregloTitanes[j].moverY(2);
							}

							if (arregloTitanes[j].getYAbajo() >= 
									obstaculos[i].getPosicionObstaculoYarriba()
									&& arregloTitanes[j].getYArriba() <= 
									obstaculos[i].getPosicionObstaculoYarriba()) {

								arregloTitanes[j].moverY(-2);
							}

							if (arregloTitanes[j].getYAbajo() >= 
									obstaculos[i].getPosicionObstaculoYabajo()
									&& arregloTitanes[j].getYArriba() <= 
									obstaculos[i].getPosicionObstaculoYabajo()) {

								arregloTitanes[j].moverY(2);
							}

						}
					}

				}
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	}
