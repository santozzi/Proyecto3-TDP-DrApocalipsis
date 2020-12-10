package entidades;

import logica.HiloSecundario;
import logica.Juego;
import visitor.VisitanteCuadroDeDialogo;
import visitor.Visitor;
/**
 *Cuadro de dialogo
 *Es lo que dice el Humano cuandro entrega a el premio 
 *
 */
public class CuadroDeDialogo extends Entidad {

	public CuadroDeDialogo(Juego j) {
		super(j);
		this.v = new VisitanteCuadroDeDialogo(this);
	}

	@Override
	public void desplazarse() {
		this.vector.desplazarse();
		if(this.vector.getPosicion().y >= Juego.ALTO_DE_COMBATE)
			this.desaparecer();
	}

	@Override
	public void accept(Visitor v) {
		v.visitarCuadroDeDialogo(this);

	}

	public void actuar() {
		int vueltasAEsperar;
		int velocidad = vector.getModulo();
		vueltasAEsperar =HiloSecundario.LATENCIA_MAXIMA-velocidad;
		if(vueltasAEsperar>0&&vueltasAEsperar<HiloSecundario.LATENCIA_MAXIMA) {
			if(latencia>=vueltasAEsperar) {
				desplazarse();
				juego.actualizarEntidad(this);
				accionar();
				latencia= 1;
			}else {
				latencia++;
			}
		}

	}

	@Override
	public void impacto(int letalidad) {

	}

}
