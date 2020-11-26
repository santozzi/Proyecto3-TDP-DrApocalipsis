package entidades.personajes.infectados;


import java.util.Random;
import entidades.Vector;
import entidades.premios.Premio;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.ParticulaAlpha;
import entidades.proyectiles.ParticulaBeta;
import entidades.proyectiles.Proyectil;
import entidades.Entidad;
import logica.ColeccionDeImagenes;
import logica.HiloSecundario;
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
		this.vector = new Vector(0, 1, 5);
		this.cargaViral = 100;
		this.rango = 100;
		//particula = new ParticulaAlpha(juego,this);
		this.claveImagen = new String("InfectadoBeta");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		tirarParticula();
		//particula.desplazarse();
    	v = new VisitanteInfectadoBeta(this);
	}
	
	public void accept(Visitor v) {
		v.visitarInfectadoBeta(this);
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
	
	public void accionar() {
		for(Entidad ent : detectarColisiones()) {
			ent.accept(v);
		}

	}

	@Override
	public void actuar() {
      int vueltasAEsperar;
		if(estadoTemporal) {
			vueltasAEsperar = tiempoDeEspera;
		}else {
			int velocidad = vector.getModulo();
			// {
				vueltasAEsperar =HiloSecundario.LATENCIA_MAXIMA-velocidad;
				
			
		}
		
   if(vueltasAEsperar>0) {
		if(latencia>=vueltasAEsperar) {
		   desplazarse();
		   juego.actualizarEntidad(this);
		   accionar();
		   latencia= 1;
		   estadoTemporal= false;
		}else {
		   latencia++;
		}
   }
	}
	
	
	
}
