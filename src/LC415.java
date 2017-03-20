import java.util.ArrayList;
import java.util.List;

/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

 */
public class LC415 {
    public static void main(String[] args) {
        System.out.println(new LC415().fizzBuzz(15));
    }
    public List<String> fizzBuzz(int n) {
        List<String> l = new ArrayList<>(15);
        for(int i = 1; i <= n; i++){
            boolean d3 = i % 3 == 0;
            boolean d5 = i % 5 == 0;
            if(d3 && d5){
                l.add("FizzBuzz");
            } else if(d3) {
                l.add("Fizz");
            } else if(d5){
                l.add("Buzz");
            } else {
                l.add(String.valueOf(i));
            }
        }
        return l;
    }
}
