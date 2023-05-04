import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {


    public static void main(String []arg){
//        int n = 5;
//        for (int i = 0; i < n ; i++) {
//            for (int j = n - i; j > 0 ; j--) {
//                System.out.print(" ");
//            }
//            for (int k = 0; k < 2*i + 1; k++) {
//                System.out.print("*");
//            }
//
//            System.out.println();
//        }

//        int[] array = {1,4,5,2};
//        TreeSet<Integer> set = new TreeSet<Integer>();
//        for (int i = 0; i < array.length; i++) {
//            set.add(array[i]);
//        }
//        System.out.println(set.toArray()[set.size() -2]);
        HocSinh hocSinh = new HocSinh("John Doe", 30);
        try {
            FileOutputStream fileOut = new FileOutputStream("person.csv");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(hocSinh);
            objectOut.close();
            System.out.println("Đã lưu đối tượng vào file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }

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

