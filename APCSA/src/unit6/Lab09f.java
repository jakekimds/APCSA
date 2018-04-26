package unit6;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
public class Lab09f {
	public static void main(String args[]) {
		LetterRemover remove = new LetterRemover();
		remove.setRemover("I am Sam I am", 'a');
		System.out.println(remove);
		remove.setRemover("ssssssssxssssesssssesss", 's');
		System.out.println(remove);
		remove.setRemover("qwertyqwertyqwerty", 'a');
		System.out.println(remove);
		remove.setRemover("abababababa", 'b');
		System.out.println(remove);
		remove.setRemover("abaababababa", 'x');
		System.out.println(remove);
	}
}