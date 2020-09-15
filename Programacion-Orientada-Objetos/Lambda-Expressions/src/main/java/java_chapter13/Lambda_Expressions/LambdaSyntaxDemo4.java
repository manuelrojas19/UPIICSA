package java_chapter13.Lambda_Expressions;

public class LambdaSyntaxDemo4 {
	public static void main(String[] args) {
		testMethod((x, y) -> {
			System.out.println("The sum is " + (x + y));
		});
	}

	private static void testMethod(TestInterfaceThree object) {
		// TODO Auto-generated method stub
		object.test(10, 5);
	}
}
