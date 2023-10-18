package GFA;

import GFA.Person;

public class GFMember extends Person {
    protected int chipCode;

//    public GFA.GFMember(){
//        System.out.println("GFA.GFMember is created");
//    }

    public GFMember(String name, int age, String gender, int chipCode){
        super(name, age, gender);
        this.chipCode = chipCode;
    }
    @Override
    public void introduce(){
        super.introduce();
        System.out.println("I'm a GFA member. My chip code is " + chipCode);
    }
}
