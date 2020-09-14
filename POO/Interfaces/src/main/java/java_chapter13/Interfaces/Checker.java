package java_chapter13.Interfaces;

public class Checker {
	public static void main(String[] args) {
		// create two oblongs
		CheckableOblong oblong1 = new CheckableOblong(10, 8); // valid
		CheckableOblong oblong2 = new CheckableOblong(0, 8); // invalid argument
		
		// create thre bank accounts
		
		CheckableBankAccount account1 = new CheckableBankAccount("12345678", "Smith"); //valid
		CheckableBankAccount account2 = new CheckableBankAccount("S1234567", "Phatel"); // invalid account number
		CheckableBankAccount account3 = new CheckableBankAccount("1234567", "Adewale"); //invalid account number
		
		System.out.println("oblong1 is " + checkValidity(oblong1)); // recieves checkable object
		System.out.println("oblong2 is " + checkValidity(oblong2));
		System.out.println("account1 is " + checkValidity(account1));
		System.out.println("account2 is " + checkValidity(account2));
		System.out.println("account3 is " + checkValidity(account3));
	}

	private static String checkValidity(Checkable objectIn) { // recieves checkable object
		if (objectIn.check()) {
			return "valid";
		} else {
		return "invalid";
		}
	}
}























