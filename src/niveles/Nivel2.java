package niveles;

import java.util.List;

import entidades.Entidad;
import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;
import niveles.fabricas.Nivel2InfectadosBeta;

public class Nivel2 extends Nivel {
    public Nivel2(Juego juego) {
		this.juego = juego;
		compInf = new CompositeInfectado();
		this.claveDer= "fondoDerecha_nivel2";
		this.claveIzq= "fondoIzquierda_nivel2";
		this.claveFondo= "nivel2";
		
	}

	@Override
	public List<Entidad> primeraTanda() {
		FabricaDeTandas  fdt =  new Nivel2InfectadosBeta(juego,this); 
	     fdt.primeraTanda();
		return this.compInf.getListaDeInfectados();
	}

	@Override
	public List<Entidad> segundaTanda() {
		FabricaDeTandas  fdt = new Nivel2InfectadosBeta(juego, this); 
		fdt.segundaTanda();
		return this.compInf.getListaDeInfectados();
	}
	 public List<Entidad> elJefe(){
	    	FabricaDeTandas  fdt = new Nivel2InfectadosBeta(juego, this);
	    	fdt.elJefe();
	    	return this.compInf.getListaDeInfectados();
	    }

}
