package week2Homework;

public class LessonManager {
	
	public void add(Lesson lesson) {
		System.out.println("Lesson saved : " + lesson.lessonName);
	}
	
	public void delete(Lesson lesson) {
		System.out.println("Lesson deleted : " + lesson.lessonName);
	}

}
