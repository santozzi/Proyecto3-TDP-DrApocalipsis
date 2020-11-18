package visitor.visitor;

public interface Poligono {
	
	public float area(Visitor v);
	public float perimetro(Visitor v);
	public int lados(Visitor v);

}
