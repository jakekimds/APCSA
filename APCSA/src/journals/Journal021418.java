package journals;

public class Journal021418 {
	public static void main(String[] args) {
		System.out.println(genPlate());
	}

	public static String genPlate() {
		String num = "";
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digit = "1234567890";
		java.util.Random rand = new java.util.Random();
		int randNum;
		for (int i = 0; i < 3; i++) {
			randNum = rand.nextInt(26);
			num += alpha.charAt(randNum);
		}
		for (int i = 0; i < 4; i++) {
			randNum = rand.nextInt(10);
			num += digit.charAt(randNum);
		}
		return num;
	}
}