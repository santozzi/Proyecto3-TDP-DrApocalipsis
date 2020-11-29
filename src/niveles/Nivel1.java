package niveles;

import java.util.List;

import entidades.Entidad;
import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;
import niveles.fabricas.Nivel1InfectadosAlpha;

public class Nivel1 extends Nivel{

	public Nivel1(Juego juego) {
		this.juego = juego;
		compInf = new CompositeInfectado();
		this.claveDer= "fondoDerecha";
		this.claveIzq= "fondoIzquierda";
		this.claveFondo= "nivel1";
	}

	@Override
	public List<Entidad> primeraTanda() {
		FabricaDeTandas  fdt =  new Nivel1InfectadosAlpha(juego, this); 
		fdt.primeraTanda();
		return this.compInf.getListaDeInfectados();
	}
	@Override
	public List<Entidad> segundaTanda() {
		FabricaDeTandas  fdt = new Nivel1InfectadosAlpha(juego, this); 
		fdt.segundaTanda();
		return this.compInf.getListaDeInfectados();
	}
	@Override
	public List<Entidad> elJefe(){
		FabricaDeTandas  fdt = new Nivel1InfectadosAlpha(juego, this);
		fdt.elJefe();
		return this.compInf.getListaDeInfectados();
	}
}
