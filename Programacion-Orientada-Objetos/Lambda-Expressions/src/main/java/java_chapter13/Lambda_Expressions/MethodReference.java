package java_chapter13.Lambda_Expressions;

public class MethodReference {
	public static void main (String[] args) {
		testMethod (Math::sqrt);
	}

	private static void testMethod(DoubleColonInterface testObjectIn) {
		System.out.println(testObjectIn.test(25));
	}
}
