public class MathUtil {
    public Integer add(Integer a, Integer b) {
        if(a == null || b == null){
            throw new IllegalArgumentException();
        }
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

}
