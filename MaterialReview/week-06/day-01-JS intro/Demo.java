public class Demo {
    public static void main(String[] args){
        // static type
        Integer a = 1;
        /// ..
        a = 4;
        //a = "s"; // error

        // strongly typed
        // Long x = a; // error
        Long x = Long.valueOf(a);
    }
} 
