package visitor.visitor;

public class Triangulo implements Poligono{
	
	private float lado_1;
	private float lado_2;
	private float lado_3;
	private float altura;
	
	
	public Triangulo() {
	
		lado_1 = 1;
		lado_2 = 2;
		lado_3 = 3;
		altura =5;
		
	}
	


	@Override
	public float area(Visitor v) {
		// TODO Auto-generated method stub
		return v.area(this, lado_1, altura);
	}

	@Override
	public float perimetro(Visitor v) {
		// TODO Auto-generated method stub
		return v.perimetro(this, lado_1,lado_2,lado_3);
	}

	@Override
	public int lados(Visitor v) {
		// TODO Auto-generated method stub
		return v.lados(this);
	}

}
