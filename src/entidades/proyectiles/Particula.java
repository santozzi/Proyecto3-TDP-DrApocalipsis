package entidades.proyectiles;

import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.infectados.Infectado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.Visitor;

public class Particula extends Proyectil{

	protected int velocidad;
	
	public Particula(Juego juego,Infectado infectado) {
		vector = new Vector(0,1,infectado.getVector().getModulo());
		vector.getPosicion().x= infectado.getVector().getPosicion().x;
		vector.getPosicion().y= infectado.getVector().getPosicion().y;
		
        this.juego = juego;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("particula");
		//v = new VisitanteParticula(this);	
		juego.agregarAEntidadesParaAgregar(this);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitarProyectil(this);
	}

	@Override
	public void desplazarse() {
		/*int y = this.vector.getY();
		
		
		while(y!= 1000) {
			vector.setY(++y);
		//this.vector.setY(++y);
		*/
		vector.desplazarse();
		}
	

	@Override
	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return imagen;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

    public void accionar() {
		// TODO Auto-generated method stub
		
	}

	public Vector getVector() {
		return this.vector;
	}

	@Override
	public Point getPosicion() {
		// TODO Auto-generated method stub
		return posicion;
	}

	@Override
	public void detenerse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hayColision(Entidad entidad) {
		// TODO Auto-generated method stub
		return false;
	}

}
