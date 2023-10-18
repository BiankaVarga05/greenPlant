package GFA;

public class Person {
    protected String name;
    protected int age;
    protected String gender;
    public static int createdPersons = 0;

//    public Person(){
//        System.out.println("Person is created");
//    }

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
        createdPersons++;
    }

    public void introduce(){
        System.out.println("Hi, I'm " + name + " , a " + age + " years old " + gender);
    }

    public void work(){
        System.out.println("I work form 9 to 5");
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        if(newName.length() >= 3){
            name = newName;
        } else {
            throw new IllegalArgumentException("Name must be at least 3 character");
        }
    }
}
