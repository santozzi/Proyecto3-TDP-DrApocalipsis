package logica.contabilidad;

import java.util.HashMap;
import java.util.Map;

public class Contabilidad {
   protected Map<String,Item> items;
   protected int score;
   public Contabilidad() {
	   items = new HashMap<String, Item>();
	   this.score= 0;
   }
   public void agregarItem(String clave, int score) {
	   Item valor = items.get(clave);
	   if(valor==null) {
		   items.put(clave, new Item(clave,score,1));
	   }else {
		   int puntos = valor.getScore();
		   int cantidad = valor.getCantidad();
		   valor.setScore(puntos+score);
		   valor.setCantidad(cantidad+1);
		   items.put(clave,valor);
	   }
	   this.score +=score;
	   
   }
public String toString() {
	String resultado = "";
	for(Item item:items.values()) {
		resultado += item+"\n";
	}
	
	return resultado;
}
public int getScore() {
	return this.score;
}
}
