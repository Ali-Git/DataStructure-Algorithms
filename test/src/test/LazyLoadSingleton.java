package test;

public class LazyLoadSingleton {
	
	private static LazyLoadSingleton ob;
	
	public LazyLoadSingleton() {
		System.out.println("LazyLoadSingleton const()");
	}
	
	static {
		System.out.println("Static Block");
	}
	
	{
		System.out.println("IIB");
	}
	
	class Inner{
		// We can't declare any field static inside inner class unless it is a static inner class like below one.
		//static int g;
		//static {
			//System.out.println("Inner");
		//}
		
	}
	
	static class StaticInner{
		
		private static final LazyLoadSingleton INSTANCE = new LazyLoadSingleton();
		
		static {
			System.out.println("StaticInner SIB");
		}
		
		{
			System.out.println("StaticInner IIB");
		}
		
		static void callMe() {
			System.out.println("StaticInner callme()");
		}
		
		static LazyLoadSingleton getSingleton(){
			return StaticInner.INSTANCE;
		}
	}

	public static void main(String[] args) {
		LazyLoadSingleton ob = new LazyLoadSingleton();
		StaticInner.callMe();

	}

}
