package GFA;

public class Student extends GFMember {
    private String className;

//    public Student(){
//        System.out.println("Student is created");
//    }

    public Student(String name, int age, String gender, int chipCode, String className){
        super(name, age, gender, chipCode);
        this.className = className;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("I'm a student in the following class: " + className);
    }

    @Override
    public String toString(){
        return "Student: " + name;
    }

    @Override
    public void work(){
        System.out.println("I study from 12 to 12");
    }

    public String getClassName() {
        return className;
    }
}
