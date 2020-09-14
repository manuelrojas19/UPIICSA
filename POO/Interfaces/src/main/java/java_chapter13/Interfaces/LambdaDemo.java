package java_chapter13.Interfaces;

public class LambdaDemo {
	public static void main(String[] args) {
		// create a test oblong
		Oblong testOblong = new Oblong(8, 8);
		
		// this checks that the sides are greather than zero
		System.out.println("oblong is " + checkValidity(
				() -> {
					return testOblong.getLength() > 0 && testOblong.getHeight() > 0;
				}
		));		
		
		// this checks that the length and height are not equal
		System.out.println("oblong is " + checkValidity( 
				() -> {
					return testOblong.getLength() != testOblong.getHeight();
				} 
		));

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
