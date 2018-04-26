package unit11;

public class Grade {
	private double value;

	public Grade() {
		setGrade(0);
	}

	public Grade(double grade) {
		setGrade(grade);
	}

	public void setGrade(double grade) {
		value = grade;
	}

	public double getNumericGrade() {
		return value;
	}

	public String getLetterGrade() {
		if (value >= 90) {
			return "A";
		} else if (value >= 80) {
			return "B";
		} else if (value >= 70) {
			return "C";
		} else if (value >= 60) {
			return "D";
		} else {
			return "F";
		}
	}

	public String toString() {
		return String.format("%f\n%s", getNumericGrade(), getLetterGrade());
	}
}
