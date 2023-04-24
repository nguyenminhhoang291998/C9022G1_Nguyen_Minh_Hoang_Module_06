import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int h = (int) (a + Math.pow(2,0) * b);
            for (int j = 1; j <= n; j++) {
                System.out.println(h);
                h += b*Math.pow(2,j);
            }
        }
      
        in.close();
    }
}

