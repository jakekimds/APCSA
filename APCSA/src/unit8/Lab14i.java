package unit8;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
import static java.lang.System.*;

public class Lab14i {
	public static void main(String args[]) {
		RomanNumeral test = new RomanNumeral();
		test.setNumber(10);
		System.out.println(test);
		test.setNumber(100);
		System.out.println(test);
		test.setNumber(1000);
		System.out.println(test);
		test.setNumber(2500);
		System.out.println(test);
		test = new RomanNumeral(1500);
		System.out.println(test);
		test.setNumber(23);
		System.out.println(test);
		test.setNumber(38);
		System.out.println(test);
		test.setNumber(49);
		System.out.println(test);
		test.setRoman("LXXVII");
		System.out.println(test);
		test.setRoman("XLIX");
		System.out.println(test);
		test.setRoman("XX");
		System.out.println(test);
		test.setRoman("XXXVIII");
		System.out.println(test);
	}
}