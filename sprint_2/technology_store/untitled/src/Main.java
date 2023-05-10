import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;

public class Main {


    public static void main(String []arg){
//      Set<Integer> set = new TreeSet<>();
//        String ta = "A ";
//        String z = ta;
//        ta = ta.concat("B ");
//        System.out.println(z.equals(ta));
//
//        String tb = "C ";
//        ta = ta.concat(tb);
//
//        String l = ta;
//        ta.replace('C','D');
//        System.out.println(l.equals(ta));
//
//        ta = ta.concat(tb);
//        System.out.println(ta);
//        StringBuilder sb = new StringBuilder(5);
//        String s = "";
//        if(sb.equals(s)) {
//            System.out.println("1");
//        }else if(sb.toString().equals(s.toString())) {
//            System.out.println("2");
//        }else {
//            System.out.println("3");
//        }
//
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("2008-05-08"));
//
//        LocalDate now = LocalDate.now();
//        List<Person> result = new ArrayList<>();
//        for (Person person : personList) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDate birthDate = LocalDate.parse(person.getDateOfBirth(),formatter);
//            if (Period.between(birthDate, now).getYears() >= 15) {
//                result.add(person);
//            }
//        }
//        result.forEach(e -> System.out.println(e.getDateOfBirth()));
        int[] arr = {9, 5, 7, 2, 9, 1, 10, 9, 10, 5};
        int thirdLargest = findThirdLargest(arr);
        System.out.println("Số lớn thứ 3 trong mảng là: " + thirdLargest);
    }

    public static int findThirdLargest(int[] arr) {
        if (arr.length < 3) {
            throw new IllegalArgumentException("Mảng phải có ít nhất 3 phần tử");
        }

        int first = Integer.MIN_VALUE;  // Số lớn nhất
        int second = Integer.MIN_VALUE; // Số lớn thứ hai
        int third = Integer.MIN_VALUE;  // Số lớn thứ ba

        for (int j : arr) {
            if (j > first) {
                third = second;
                second = first;
                first = j;
            } else if (j > second && j < first) {
                third = second;
                second = j;
            } else if (j > third && j < second) {
                third = j;
            }
        }

        return third;
    }

    public static boolean check(String input) {
        char[] open = {'[','{','('};
        char[] close = {']','}',')'};
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < open.length; j++) {
                if((input.charAt(i) == open[j] && input.charAt(++i) == close[j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkValid(String input) {
        return input.matches("\\(\\)||\\{\\}||\\[\\]");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }


}

