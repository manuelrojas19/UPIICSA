package java_chapter13.Lambda_Expressions;

public class LambdaSyntaxDemo3 {
	public static void main(String[] args) {
		testMethod (string -> {
			string = "Hello " + string;
			return string;
		});
	}

	private static void testMethod(TestInterface testObjectIn) {
		// TODO Auto-generated method stub
		String output = testObjectIn.test("world");
		System.out.println(output);
	}
}
