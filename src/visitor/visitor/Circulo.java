package visitor.visitor;

public class Circulo implements Poligono {
	
	private Visitor v;
	private float radio;
	
	public Circulo() {
	
		radio = 4;
	}



	@Override
	public float area(Visitor v) {
		// TODO Auto-generated method stub
		return v.area(this, radio);
	}

	@Override
	public float perimetro(Visitor v) {
		// TODO Auto-generated method stub
		return v.perimetro(this, radio);
	}

	@Override
	public int lados(Visitor v) {
		// TODO Auto-generated method stub
		return v.lados(this);
	}
}
