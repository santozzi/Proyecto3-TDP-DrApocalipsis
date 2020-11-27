package niveles;

import java.util.List;

import entidades.Entidad;
import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;
import niveles.fabricas.Nivel1InfectadosAlpha;
import niveles.fabricas.Nivel2InfectadosBeta;
import niveles.fabricas.Nivel3InfectadosBeta;

public class Nivel2 extends Nivel {
    public Nivel2(Juego juego) {
		this.juego = juego;
		compInf = new CompositeInfectado();
		this.claveDer= "fondoDerecha";
		this.claveIzq= "fondoIzquierda";
		this.claveFondo= "nivel2";
		
	}


	@Override
	public void crearTanda() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entidad> primeraTanda() {
		FabricaDeTandas  fdt =  new Nivel3InfectadosBeta(juego, this); 
	     fdt.primeraTanda();
		return this.compInf.getListaDeInfectados();
	}

	@Override
	public List<Entidad> segundaTanda() {
		FabricaDeTandas  fdt = new Nivel3InfectadosBeta(juego, this); 
		fdt.segundaTanda();
		return this.compInf.getListaDeInfectados();
	}
	 public List<Entidad> elJefe(){
	    	FabricaDeTandas  fdt = new Nivel3InfectadosBeta(juego, this);
	    	fdt.elJefe();
	    	return this.compInf.getListaDeInfectados();
	    }

}
