package test;

/**
 * 
 * Run this command to see the converted class of enum into java -> javap -p -c Enum
 * @author Ali
 *
 */
enum Abc {
	
	INSTANCE;
	Qwerty obj;
	public Qwerty getQwerty(){
		return null;
	}
}

class Qwerty{
	
}

public class EnumTest {
	public static void main(String[] args) {
		Abc en1 = Abc.INSTANCE;
		Abc en2 = Abc.INSTANCE;
		System.out.println(en1.hashCode());
		System.out.println(en2.hashCode());
	}
}

