package visitor.visitor;

public class Cliente {

	public static void main(String[] args) {
		//Area del circulo
		Visitor v1 = new visitorOperaciones();
		Poligono c1 = new Circulo();
		System.out.println(c1.area(v1));
		

	}

}
