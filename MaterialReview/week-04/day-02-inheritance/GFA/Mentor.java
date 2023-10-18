package GFA;

import java.util.ArrayList;

public class Mentor extends GFMember {
    private ArrayList<String> assignedClasses;

//    public Mentor(){
//        System.out.println("Mentor is created");
//    }

    public Mentor(String name, int age, String gender, int chipCode, ArrayList<String> assignedClasses){
        super(name, age, gender, chipCode);
        this.assignedClasses = assignedClasses;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("I'm mentoring in the following classes: " + assignedClasses);
    }

    @Override
    public void work(){
        System.out.println("I work from 9 to 6");
    }

    public void work(int start, int end){
        System.out.println("I work from " + start + " to " + end);
    }

}
