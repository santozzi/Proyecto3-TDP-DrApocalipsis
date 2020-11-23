package entidades.proyectiles;

import entidades.Vector;
import entidades.personajes.infectados.Infectado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.Visitor;

public class Particula extends Proyectil{
	protected Infectado infectado;
	protected int velocidad;
	protected int rangoParticula;
	public Particula(Juego juego,Infectado infectado) {
		vector = new Vector(0,1,8);
		vector.getPosicion().x= infectado.getVector().getPosicion().x;
		vector.getPosicion().y= infectado.getVector().getPosicion().y+100;
		//	System.out.println("En particula: ("+vector.getPosicion().x+";"+vector.getPosicion().y+")");
		this.juego = juego;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("particula");
		//v = new VisitanteParticula(this);	
		juego.agregarAEntidadesParaAgregar(this);
		rangoParticula= 0;
		this.infectado = infectado;
		this.letalidad = 2;
	}

	@Override
	public void accept(Visitor v) {
		v.visitarParticula(this);
	}

	@Override
	public void desplazarse() {
		/*int y = this.vector.getY();


		while(y!= 1000) {
			vector.setY(++y);
		//this.vector.setY(++y);
		 */
		if(rangoParticula==infectado.getRango()) {
			rangoParticula=0;
			vector.getPosicion().x = infectado.getVector().getPosicion().x+
					(infectado.getImagen().getIconWidth()/4);
			vector.getPosicion().y = infectado.getVector().getPosicion().y+10;
		}else {
			rangoParticula++;
		}
		detectarColisiones();  
		vector.desplazarse();
	}
}
