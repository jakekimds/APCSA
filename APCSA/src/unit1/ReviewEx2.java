package unit1;

public class ReviewEx2 {

	public static void main(String[] args) {
		String str = "Hello World!";
		str = str.replace("e", "###$$%%RPL%%$$###");
		str = str.replace("o", "e");
		str = str.replace("###$$%%RPL%%$$###", "o");
		System.out.println(str);
	}

}