package journals;

public class Journal021318 {
	public static void main(String[] args) {
		System.out.print("SSN: ");
		java.util.Scanner keyboard = new java.util.Scanner(System.in);
		String ssn = keyboard.nextLine();
		if (validateSSN(ssn)) {
			System.out.println("The SSN is valid.");
		} else {
			System.out.println("The SSN is invalid.");
		}
		keyboard.close();
	}

	public static boolean validateSSN(String ssn) {
		if (ssn.length() == 11) {
			return false;
		}
		for (int i = 0; i < 11; i++) {
			if (i == 3 || i == 6) {
				if (ssn.charAt(i) != '-') {
					return false;
				}
			} else {
				if (!Character.isDigit(ssn.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}
}