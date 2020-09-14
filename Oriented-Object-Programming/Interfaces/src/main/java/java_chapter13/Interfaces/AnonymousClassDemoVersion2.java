package java_chapter13.Interfaces;

public class AnonymousClassDemoVersion2 {
	public static void main(String[] args) {
		Oblong oblong = new Oblong(8,8);
		
		// this checks that the sides are greater tha zero
		System.out.println("Oblong is" + checkValidity(new Checkable() {
			@Override
			public boolean check() {
				// TODO Auto-generated method stub
				return oblong.getLength() > 0 && oblong.getHeight() > 0;
			}
			
		}));
		
		// this checks that the length and height are not equal
		System.out.println("Oblong is " + checkValidity(new Checkable() {
			@Override
			public boolean check() {
				// TODO Auto-generated method stub
				return oblong.getLength() != oblong.getHeight();
			}
		}));
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
