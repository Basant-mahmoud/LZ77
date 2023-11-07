import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("enter , code");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        lz77algorithim obj = new lz77algorithim();
            obj.compression(str);
        ArrayList<tages> tage = new ArrayList<tages>();
        tages mytages;
        int n;
        Scanner input = new Scanner(System.in);
        n=input.nextInt();
        for(int i=0;i<n;i++)
        {
            int pos =input.nextInt() ;
            int len =input.nextInt();
            char s = input.next().charAt(0);
            mytages  = new tages(pos,len,s);
            tage.add(mytages);
        }
        obj.decompression(tage);

        }
    }