
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DNA {

  private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

  private static List<String> input = new LinkedList<String>();
  private static List<Integer> in = new LinkedList<Integer>();

  public static void main(String[] args) {
    setup();

    // for (Character i : map.keySet()) {
    // System.out.println(i);
    // }

    readFromInput();

    for (Integer i : in) {
      System.out.println(i);
    }

    for (String i : input) {
      System.out.println(i);
    }
  }

  public static void DivideAndConquer() {

  }

  public static void BruteForce() {

  }

  public static void setup() {
    map.put('A', 1);
    map.put('C', 2);
    map.put('G', 3);
    map.put('T', 4);
  }

  public static void readFromInput() {
    try {
      boolean isFirst = true;
      String read;
      BufferedReader infile = new BufferedReader(new FileReader("input.txt"));

      while ((read = infile.readLine()) != null) {
        // Read First line
        if (isFirst) {
          List<Integer> key = Collections.list(new StringTokenizer(read, " ")).stream()
              .map(token -> Integer.parseInt((String) token)).collect(Collectors.toList());

          in = key;
          isFirst = false;
          continue;
        }

        // Not first line
        List<String> val = Collections.list(new StringTokenizer(read)).stream().map(token -> (String) token)
            .collect(Collectors.toList());
        input.addAll(val);
      }

      infile.close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
