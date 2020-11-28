package niveles.fabricas;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.infectados.Infectado;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBossAlpha;
import entidades.personajes.infectados.InfectadoBossBeta;
import logica.Juego;
import niveles.Nivel;

public abstract class FabricaDeTandas {

	protected Juego juego;
	protected Nivel nivel;

	abstract public void crearTanda(int cantidadJefesInfectados);
	abstract public void losJefes(int cantidadJefesInfectados);
	
	protected void crearTanda(int cantidadInfectados, String tipoInfectado) {

		if(tipoInfectado.equals("Alpha") || tipoInfectado.equals("Beta") || tipoInfectado.equals("Mixto") ||
			tipoInfectado.equals("JefeAlpha") || tipoInfectado.equals("JefeBeta") || tipoInfectado.equals("JefeMixto")) {
			
			Point posicion;
			Infectado nuevoInfectado = null;//new InfectadoAlpha(this.juego);
			Random random = new Random();
			List<Point> posiciones = new LinkedList<Point>();
			List<Entidad> compositeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();
			int randomInt;

			for(int i=0 ; i<cantidadInfectados ; i++) {

				if(tipoInfectado.startsWith("Jefe")) {
					if(tipoInfectado.endsWith("Alpha"))
						nuevoInfectado = new InfectadoBossAlpha(this.juego);

					else if(tipoInfectado.endsWith("Beta"))
						nuevoInfectado = new InfectadoBossBeta(this.juego);

					else if(tipoInfectado.endsWith("Mixto")) {
						randomInt = random.nextInt(1);
						if(randomInt==0)
							nuevoInfectado = new InfectadoBossAlpha(this.juego);
						else if(randomInt==1)
							nuevoInfectado = new InfectadoBossBeta(this.juego);
					}
				}
				else {
					if(tipoInfectado.equals("Alpha"))
						nuevoInfectado = new InfectadoAlpha(this.juego);

					else if(tipoInfectado.equals("Beta"))
						nuevoInfectado = new InfectadoBeta(this.juego);

					else if(tipoInfectado.equals("Mixto")) {
						randomInt = random.nextInt(1);
						if(randomInt==0)
							nuevoInfectado = new InfectadoAlpha(this.juego);
						else if(randomInt==1)
							nuevoInfectado = new InfectadoBeta(this.juego);
					}
				}

				posicion = asignarPosicion(
						posiciones,
						nuevoInfectado.getImagen().getIconWidth(),
						nuevoInfectado.getImagen().getIconHeight(),
						random.nextInt(Juego.ANCHO_DE_COMBATE-nuevoInfectado.getImagen().getIconWidth()),
						random.nextInt(Juego.ALTO_DE_COMBATE),
						random);
				
				posiciones.add(posicion);
				
				if(juego.getLimite().y>=posicion.y)
					juego.getLimite().y = posicion.y - nuevoInfectado.getImagen().getIconHeight();
				
				nuevoInfectado.setPosicion(posicion.x, - posicion.y - nuevoInfectado.getImagen().getIconHeight());
				nuevoInfectado.getVector().setModulo(3);
				compositeInfectados.add(nuevoInfectado);
			}
		}
		else
			System.out.println(tipoInfectado+" no es un tipo de infectado");
	}
	
	protected Point asignarPosicion(List<Point> posiciones, int anchoInfectado, int altoInfectado, int x, int y, Random random) {
		Iterator<Point> itPosiciones;
		Point aRetornar;
		Point elem;
		boolean estaInsertado = false;
		itPosiciones = posiciones.iterator();

		while(itPosiciones.hasNext() && !estaInsertado) {
			elem = itPosiciones.next();
			estaInsertado = (x <= (elem.x + anchoInfectado) && x >= (elem.x - anchoInfectado))
					&& (y <= (elem.y + altoInfectado) && y >= (elem.y - altoInfectado));
		}

		if(estaInsertado)
			aRetornar = asignarPosicion(posiciones, anchoInfectado, altoInfectado, random.nextInt(Juego.ANCHO_DE_COMBATE-anchoInfectado), random.nextInt(Juego.ALTO_DE_COMBATE), random);
		else
			aRetornar = new Point(x, y);

		return aRetornar;
	}
	
	/*
	protected void crearTanda(int cantidadInfectados, String tipoInfectado) {

		if(tipoInfectado.equals("Alpha") || tipoInfectado.equals("Beta") || tipoInfectado.equals("Mixto")) {
			Point posicion;
			Infectado nuevoInfectado = null;//new InfectadoAlpha(this.juego);
			Random random = new Random();
			List<Point> posiciones = new LinkedList<Point>();
			List<Entidad> compositeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();
			int randomInt;

			for(int i=0 ; i<cantidadInfectados ; i++) {

				if(tipoInfectado.equals("Alpha"))
					nuevoInfectado = new InfectadoAlpha(this.juego);

				else if(tipoInfectado.equals("Beta"))
					nuevoInfectado = new InfectadoBeta(this.juego);

				else if(tipoInfectado.equals("Mixto")) {
					randomInt = random.nextInt(1);
					if(randomInt==0)
						nuevoInfectado = new InfectadoAlpha(this.juego);
					else if(randomInt==1)
						nuevoInfectado = new InfectadoBeta(this.juego);
				}

				posicion = asignarPosicion(
						posiciones,
						nuevoInfectado.getImagen().getIconWidth(),
						nuevoInfectado.getImagen().getIconHeight(),
						random.nextInt(Juego.ANCHO_DE_COMBATE-nuevoInfectado.getImagen().getIconWidth()),
						random.nextInt(Juego.ALTO_DE_COMBATE),
						random);
				posiciones.add(posicion);
				if(juego.getLimite().y>=posicion.y)
					juego.getLimite().y = posicion.y - nuevoInfectado.getImagen().getIconHeight();
				//nuevoInfectado.getVector().getDireccion().y=1;
				//nuevoInfectado.getVector().getDireccion().x=1;
 			//nuevoInfectado.getVector().getPosicion().x = posicion.x;
			//nuevoInfectado.getVector().getPosicion().y = - posicion.y - nuevoInfectado.getImagen().getIconHeight();
			//nuevoInfectado.tirarParticula();
				nuevoInfectado.setPosicion(posicion.x, - posicion.y - nuevoInfectado.getImagen().getIconHeight());
				nuevoInfectado.getVector().setModulo(3);
				//nuevoInfectado.getVector().cambioDeSentido();
				compositeInfectados.add(nuevoInfectado);
			}
		}
		else
			System.out.println(tipoInfectado+" no es un tipo de infectado");
	}

	protected void  elJefe(int cantidadJefesInfectados, String tipoJefeInfectado) {

		if(tipoJefeInfectado.equals("Alpha") || tipoJefeInfectado.equals("Beta") || tipoJefeInfectado.equals("Mixto")) {
			List<Entidad> compositeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();
			List<Point> posiciones = new LinkedList<Point>();
			Point posicion;
			Random random = new Random();
			InfectadoBoss jefe = null;
			int randomInt;

			if(tipoJefeInfectado.equals("Alpha"))
				jefe = new InfectadoBossAlpha(this.juego);

			else if(tipoJefeInfectado.equals("Beta"))
				jefe = new InfectadoBossBeta(this.juego);

			else if(tipoJefeInfectado.equals("Mixto")) {
				randomInt = random.nextInt(1);
				if(randomInt==0)
					jefe = new InfectadoBossAlpha(this.juego);
				else if(randomInt==1)
					jefe = new InfectadoBossBeta(this.juego);
			}

			posicion = asignarPosicion(
					posiciones,
					jefe.getImagen().getIconWidth(),
					jefe.getImagen().getIconHeight(),
					random.nextInt(Juego.ANCHO_DE_COMBATE-jefe.getImagen().getIconWidth()),
					random.nextInt(Juego.ALTO_DE_COMBATE),
					random);
			posiciones.add(posicion);

			jefe.setPosicion(posicion.x, - posicion.y - jefe.getImagen().getIconHeight());
			jefe.getVector().setModulo(3);

			compositeInfectados.add(jefe);
		}
		else
			System.out.println(tipoJefeInfectado+" no es un tipo de infectado");
	}
	*/
}
