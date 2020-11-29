package entidades.proyectiles.proyectiljugador;
import logica.Juego;
import entidades.personajes.jugador.Jugador;
import logica.ColeccionDeImagenes;
import visitor.VisitanteProyectilSanitario;
import visitor.Visitor;

public class ProyectilSanitario extends ProyectilJugador{

	
	protected Jugador jugador;
	//constructor crear un vector con los datos, recibe a juego
	
	public ProyectilSanitario(Juego juego) {
	    super(juego);
		vector.setModulo(9);
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("proyectilSanitario");
		v = new VisitanteProyectilSanitario(this);
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarProyectilSanitario(this);
	}

	@Override
	public void impacto(int letalidad) {
		// TODO Auto-generated method stub
		
	}



}
