package entidades.proyectiles;

import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.infectados.Infectado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteParticulaAlpha;
import visitor.Visitor;

public class ParticulaAlpha extends Proyectil{
	protected Infectado infectado;
	protected int velocidad;
	protected int rangoParticula;
	public ParticulaAlpha(Juego juego,Infectado infectado) {
		vector = new Vector(0,1,8);
		vector.getPosicion().x= infectado.getVector().getPosicion().x;
		vector.getPosicion().y= infectado.getVector().getPosicion().y+100;
		//	System.out.println("En particula: ("+vector.getPosicion().x+";"+vector.getPosicion().y+")");
		this.juego = juego;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("particula");
		v = new VisitanteParticulaAlpha(this);	
		juego.agregarAEntidadesParaAgregar(this);
		rangoParticula= 0;
		this.infectado = infectado;
		this.letalidad = 5;
	}

	@Override
	public void accept(Visitor v) {
		v.visitarParticulaAlpha(this);
	}

	@Override
	public void desplazarse() {
		/*int y = this.vector.getY();


		while(y!= 1000) {
			vector.setY(++y);
		//this.vector.setY(++y);
		 */
		if(rangoParticula==infectado.getRango()) {
		   reiniciarParticula();
		}else {
			rangoParticula++;
		}
		accionar();  
		vector.desplazarse();
	}
	
	
	public void reiniciarParticula() {
		rangoParticula=0;
		vector.getPosicion().x = infectado.getVector().getPosicion().x+
				(infectado.getImagen().getIconWidth()/4);
		vector.getPosicion().y = infectado.getVector().getPosicion().y+10;
	}
	public boolean hayColision(Entidad entidad) {
		// entidad.getEntorno() this.entorno
		//entorno = [x;x+anchoEntidad]
		//entornoEnY= [[y;y+anchoEntidad]
		int posEntidadActualX =this.vector.getPosicion().x;
		int posEntidadActualY =this.vector.getPosicion().y;
		int posEntidadParametroX =entidad.getVector().getPosicion().x;
		int posEntidadConAnchoX= posEntidadParametroX+entidad.getImagen().getIconWidth();

		int posEntidadParametroY =entidad.getVector().getPosicion().y ;
		int posEntidadConAltoY= posEntidadParametroY +entidad.getImagen().getIconHeight();

		boolean colisionEnX = (posEntidadActualX<= posEntidadConAnchoX) && (posEntidadActualX >= posEntidadParametroX-10);
		boolean colisionEnY = (posEntidadActualY+this.getImagen().getIconHeight()==posEntidadParametroY);// && (+this.getPosicion().y<=posEntidadParametroY);


		return colisionEnX &&colisionEnY;
		/*	
				(
				this.vector.getPosicion().y <= 
			(entidad.getVector().getPosicion().y+entidad.getImagen().getIconHeight())&&
						this.vector.getPosicion().y >= (entidad.getVector().getPosicion().y));
		 */
	}
	
}
