package pro1.example0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // TODO: Odkomentuj řádek a oprav kód
    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<100; i++)
        {
            var i2 = i;
            var t = new Thread(()->{
                System.out.println("Hodnota i je: " + i2);
            });
            t.start();
        }
        int[] nums = new int[]{5,6,7};
        for(int i=0; i<nums.length; i++) {
            var i3 = i;
            var r = Arrays
                    .stream(nums)
                    .filter(n -> n == i3)
                    .count();
            System.out.println(r);
        }
    }
}