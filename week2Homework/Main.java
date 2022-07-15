package week2Homework;

public class Main {

	public static void main(String[] args) {
		
		Lesson lesson1 = new Lesson(1, "Java","Beginner");
		
		Lesson lesson2 = new Lesson(2, "Python", "Advanced");
		
		Lesson lesson3 = new Lesson(3, "Linux", "Expert");
		
		Lesson[] lessons = {lesson1, lesson2, lesson3};

		for (Lesson lesson : lessons) {
			System.out.println(lesson.lessonName);
		}
		
		System.out.println("-----------------------------------------------");
		
		Student student1 = new Student(1, "Berk", "He studies for Python");
		Student student2 = new Student(2, "Yeliz", "She studies for Linux");
		Student student3 = new Student(3, "Sena", "She studies for Java");
		
		Student[] students = {student1, student2, student3};
		
		for (Student student : students) {
			System.out.println(student.firstName);
		}
		
		StudentManager studentManager = new StudentManager();
		studentManager.add(student2);
		studentManager.delete(student3);
		
		System.out.println("---------------------------------------");
		
		LessonManager lessonManager = new LessonManager();
		
		lessonManager.add(lesson1);
		lessonManager.delete(lesson3);
	}

}
