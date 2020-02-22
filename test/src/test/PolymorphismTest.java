package test;

class A{
	
	public void m() {
		System.out.println("A m()");
	}
}

class B extends A{
	
	public void m() {
		System.out.println("B m()");
	}
	
	public void n() {
		System.out.println("B n()");
	}
}

public class PolymorphismTest {

	public static void main(String[] args) {
		
		A ob = new B();
		ob.m();
		B b = (B)ob;
		b.n();
	}

}
