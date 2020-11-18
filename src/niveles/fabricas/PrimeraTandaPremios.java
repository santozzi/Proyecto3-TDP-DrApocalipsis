package niveles.fabricas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.infectados.Infectado;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.jugador.Jugador;
import entidades.premios.temporales.Cuarentena;
import logica.Juego;

public class PrimeraTandaPremios extends PrimerTanda{
    protected Juego juego; 
	protected List<Entidad> entidades;
	public PrimeraTandaPremios(Juego juego) {
     this.juego= juego;
     entidades = new LinkedList<Entidad>();
	}
	public void generar() {
	  int cantidad = 50;
	  Random r1 = new Random();
	  int azar1 = r1.nextInt();
	  for(int i=0;i<cantidad/2;i++) {
		  //setear la posicion en el mapa
	
		  Infectado nuevoInfectado =new InfectadoAlpha(juego);
		  nuevoInfectado.getPosicion().x= r1.nextInt(Juego.ANCHO_DE_COMBATE-50)+Juego.DECORADO_IZQUIERDO;
		  nuevoInfectado.getPosicion().y=r1.nextInt(Juego.ANCHO_DE_COMBATE+1);
		//  nuevoInfectado.getVector().setModulo(500);
		  	  if(i==2) {
			  nuevoInfectado.getVector().setModulo(5);
		  }  
		  entidades.add(nuevoInfectado);
		  
	  }
	  
	}
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
    
}
