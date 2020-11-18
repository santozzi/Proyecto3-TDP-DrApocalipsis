package niveles;

import java.util.List;

import entidades.Entidad;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;
import niveles.fabricas.PrimeraTandaPremios;

public class Nivel1 extends Nivel{
    protected Juego juego;
    
    
	public Nivel1(Juego juego) {
		this.juego = juego;
		
	}

	@Override
	public List<Entidad> primeraTanda() {
		FabricaDeTandas  fdt = new PrimeraTandaPremios( juego); 
		fdt.generar();
	//	this.entidades = fdt.getEntidades();
		return fdt.getEntidades();
	}

	@Override
	public List<Entidad> segundaTanda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearTanda() {
		// TODO Auto-generated method stub
		
	}
	

}
