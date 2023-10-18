// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLeftRotation {
    public static void rotateOnce(List<Integer> a) {
        Integer firstElem = a.remove(0);
        a.add(firstElem);
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        for (int i = 0; i < d; i++) {
            rotateOnce(a);
        }

        return a;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println(rotLeft(l, 3));
    }
}