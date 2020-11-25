package entidades.personajes.infectados;



import entidades.Vector;
<<<<<<< HEAD
import entidades.premios.Premio;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.ParticulaAlpha;
import entidades.proyectiles.ParticulaBeta;
import entidades.proyectiles.Proyectil;
import entidades.Entidad;
import logica.ColeccionDeImagenes;
=======

>>>>>>> a51f6a8fb36937cbdb6f6c9960a62c8b2393a320
import logica.Juego;
import visitor.VisitanteInfectadoBeta;
import visitor.Visitor;

/**
 * Este infectado tiene mayor resistencia
 * @author 
 *
 */
public class InfectadoBeta extends Infectado{
	
	public InfectadoBeta(Juego juego) {
		this.juego = juego;
		this.vector = new Vector(0, -1, 5);
		this.cargaViral = 100;
		this.rango = 100;
		//particula = new ParticulaAlpha(juego,this);
		this.claveImagen = new String("InfectadoBeta");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		tirarParticula();
		particula.desplazarse();
    	v = new VisitanteInfectadoBeta(this);
	}
	
	public void accept(Visitor v) {
		v.visitarInfectadoBeta(this);
	}
	
	public void actuar() {
		// TODO Auto-generated method stub
		
	}
	
	public void tirarParticula() {
    	this.particula= new ParticulaBeta(juego,this);
    }
	
	public void desinfectar() {
		this.cargaViral = this.cargaViral -20;
		if (this.cargaViral <= 0) {
           this.desaparecer();
           Random n = new Random(2);
           int nro = n.nextInt();
           //if (nro == 0)
        	   //tirarPremio();
		}
	}
	
	public void desplazarse() {
		
	}
	
	
}
