package week3Homework;

public class Student extends User{

	   private int studentId;
	    private int purchasedCourses;

	    public Student(){

	    }
	    public Student(int studentId,int purchasedCourses){
	        super();
	        this.studentId = studentId;
	        this.purchasedCourses = purchasedCourses;


	    }
	    public int getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(int studentId) {
	        this.studentId = studentId;
	    }

	    public int getPurchasedCourses() {
	        return purchasedCourses;
	    }

	    public void setPurchasedCourses(int purchasedCourses) {
	        this.purchasedCourses = purchasedCourses;
	    }



	}