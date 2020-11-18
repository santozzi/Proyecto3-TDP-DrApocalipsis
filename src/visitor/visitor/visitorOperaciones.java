package visitor.visitor;

public class visitorOperaciones implements Visitor{

	@Override
	public float area(Circulo c,float radio) {
		
		return (float)(Math.PI*Math.pow(radio,2));
	}

	@Override
	public float area(Triangulo t,float base, float altura) {
		// TODO Auto-generated method stub
		return (base*altura)/2;
	}

	@Override
	public float area(Cuadrado c, float base) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lados(Circulo c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lados(Cuadrado c) {
		
		return 4;
	}

	@Override
	public int lados(Triangulo t) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public float perimetro(Circulo c, float radio) {
		
		return (float)(2*Math.PI*radio);
	}

	@Override
	public float perimetro(Cuadrado c,float lado) {
		// TODO Auto-generated method stub
		return 4*lado;
	}

	@Override
	public float perimetro(Triangulo c,float l1, float l2, float l3) {
		// TODO Auto-generated method stub
		return l1+l2+l3;
	}

}
