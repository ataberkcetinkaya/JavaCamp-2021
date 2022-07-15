package week3Homework;

public class Instructor extends User{
    private int instructorId;
    private double instructorRate;
    private int courses;

    public Instructor(){

    }
    public Instructor(int instructorId, double instructorRate, int courses){
        super();
    this.instructorId= instructorId;
    this.courses= courses;
    this.instructorRate = instructorRate;


    }
    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public double getInstructorRate() {
        return instructorRate;
    }

    public void setInstructorRate(double instructorRate) {
        this.instructorRate = instructorRate;
    }

    public int getCourses() {
        return courses;
    }

    public void setCourses(int courses) {
        this.courses = courses;
    }



}