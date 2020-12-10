package entidades.proyectiles.proyectil_jugador;
import logica.Juego;
import entidades.personajes.jugador.Jugador;
import visitor.VisitanteProyectilSanitario;
import visitor.Visitor;
/**
 * ProyectilSanitario
 * Una especialización de projectilJugador
 */
public class ProyectilSanitario extends ProyectilJugador{

	
	protected Jugador jugador;
	/**
	 * ProyectilSanitario
	 * @param juego
	 */
	public ProyectilSanitario(Juego juego) {
	    super(juego);
		vector.setModulo(9);
		this.letalidad = 10;
		v = new VisitanteProyectilSanitario(this);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitarProyectilSanitario(this);
	}

	@Override
	public void impacto(int letalidad) {
	}
}
