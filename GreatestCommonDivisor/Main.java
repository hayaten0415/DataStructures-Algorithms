import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.println(gcd(a, b));
  }
  public static int gcd(int a, int b) {
    int smaller = Math.min(a, b);
    int bigger = Math.max(a, b);
    int surplus = bigger % smaller;
    if (surplus == 0) return smaller;
    surplus = gcd(smaller, surplus);
    return surplus;
  }
}