package visitor.visitor;

public class Cuadrado implements Poligono{
	
	private Visitor v;
	private float lado;
	
	public Cuadrado() {
		
		lado = 2;
	}
	


	@Override
	public float area(Visitor v) {
		// TODO Auto-generated method stub
		return v.area(this, lado);
	}

	@Override
	public float perimetro(Visitor v) {
		// TODO Auto-generated method stub
		return v.perimetro(this,lado);
	}

	@Override
	public int lados(Visitor v) {
		// TODO Auto-generated method stub
		return v.lados(this);
	}

}
