package entidades.proyectiles;

import entidades.personajes.infectados.Infectado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteParticulaAlpha;
import visitor.Visitor;

<<<<<<< HEAD
public class ParticulaAlpha extends Proyectil{
	
	protected Infectado infectado;
    protected int rangoParticula;
	
=======
public class ParticulaAlpha extends Particula{

>>>>>>> a51f6a8fb36937cbdb6f6c9960a62c8b2393a320
	public ParticulaAlpha(Juego juego,Infectado infectado) {
	    super(juego,infectado);
		vector.setModulo(8);
        this.letalidad = 5;
        rangoParticula= 0;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("particula");
		v = new VisitanteParticulaAlpha(this);	
	}


	public void accept(Visitor v) {
		v.visitarParticulaAlpha(this);
	}

<<<<<<< HEAD
	
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
		juego.actualizarEntidad(this);
	}

=======
>>>>>>> a51f6a8fb36937cbdb6f6c9960a62c8b2393a320


	
}
