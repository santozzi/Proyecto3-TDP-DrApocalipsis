package visitor.visitor;
public interface Visitor {
public float area(Circulo c,float radio);
public float area(Triangulo t,float base, float altura);
public float area(Cuadrado c,float lado);
public int lados(Circulo c);
public int lados(Cuadrado c);
public int lados(Triangulo t);
public float perimetro(Circulo c,float radio);
public float perimetro(Cuadrado c,float lado);
public float perimetro(Triangulo c,float l1, float l2, float l3);
}
