import java.util.*;

public class Main {


    public static void main(String []arg){
        List<HocSinh> danhSachHocSinh = new ArrayList<>();
        danhSachHocSinh.add(new HocSinh("Hoang", 8));
        danhSachHocSinh.add(new HocSinh("Tien", 9));
        danhSachHocSinh.add(new HocSinh("Nhan", 7));
        danhSachHocSinh.sort(new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return o2.getDiem() - o1.getDiem();
            }
        });

        for (HocSinh hs : danhSachHocSinh) {
            System.out.println(hs.getTen() + " - " + hs.getDiem());
        }

        int[] arr = {3,1,2};
        Arrays.sort(arr);
        int min = arr[0];
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(min);
        System.out.println(sum);

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

