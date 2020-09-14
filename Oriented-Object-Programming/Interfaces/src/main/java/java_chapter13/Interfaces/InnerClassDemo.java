package java_chapter13.Interfaces;

public class InnerClassDemo {
	public static void main(String[] args) {
		// inner class
		class InnerCheckableOblong extends Oblong implements Checkable {
			public InnerCheckableOblong(double lengthIn, double heightIn) {
				super(lengthIn, heightIn);
				// TODO Auto-generated constructor stub
			}

			@Override
			public boolean check() {
				// TODO Auto-generated method stub
				return getLength() > 0 && getHeight() > 0;
			}	
		}
		
		Checkable oblong1 = new InnerCheckableOblong(5, 0);
		 //invalid
		Checkable oblong2 = new InnerCheckableOblong(5, 6);
		 // valid
		System.out.println("oblong1 is " + checkValidity(oblong1));
		System.out.println("oblong2 is " + checkValidity(oblong2));

	}

	private static String checkValidity(Checkable objectIn) {
		// TODO Auto-generated method stub
		if (objectIn.check()) {
			return "valid";
		} else {
			return "invalid";
		}
	}
	
}
