package niveles;

import java.util.List;

import entidades.Entidad;
import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;
import niveles.fabricas.Nivel1InfectadosAlpha;
import niveles.fabricas.Nivel2InfectadosBeta;
import niveles.fabricas.Nivel3InfectadosMixto;

public class Nivel1 extends Nivel{
    protected Juego juego;
    
	public Nivel1(Juego juego) {
		this.juego = juego;
		compInf = new CompositeInfectado();
	}

	@Override
	public List<Entidad> primeraTanda() {
		FabricaDeTandas  fdt =  new Nivel2InfectadosBeta(juego); 
	     fdt.primeraTanda();
		return this.compInf.getListaDeInfectados();
	}

	@Override
	public List<Entidad> segundaTanda() {
		FabricaDeTandas  fdt = new Nivel1InfectadosAlpha(juego, this); 

	//	this.entidades = fdt.getEntidades();
		return this.compInf.getListaDeInfectados();
	}

	@Override
	public void crearTanda() {
		// TODO Auto-generated method stub
		
	}
	

}
