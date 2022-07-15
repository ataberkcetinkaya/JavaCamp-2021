package week2Homework;

public class Lesson {
	
	public Lesson() {
		System.out.println("Lesson added.");
	}

	public Lesson(int id, String lessonName, String detail) {
		this.id = id;
		this.lessonName = lessonName;
		this.detail = detail;
	}
	int id;
	String lessonName;
	String detail;
}
