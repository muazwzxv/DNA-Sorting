
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DNA {

  private static List<String> input = new LinkedList<String>();
  private static List<Integer> mn = new LinkedList<Integer>();
  private static HashMap<Integer, Solved> result = new HashMap<Integer, Solved>();

  public static void main(String[] args) {
    readFromInput();

    System.out.println("input");
    for (String i : input) {
      String[] slice = i.split("");
      String original = String.join("", slice);

      System.out.println(original);
      // Sort string
      selectionSort(slice);

      // Find transition
      int diff = check(slice, i.split(""));
      Solved data = new Solved(original, String.join("", slice), diff);

      result.put(diff, data);
    }

    System.out.println("\nSorted");
    for (Solved ele : result.values()) {
      System.out.println(ele.original);
    }
  }

  public static void selectionSort(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int pointer = i;
      for (int j = i + 1; j < arr.length; j++) {

        // int data1 = map.get((arr[j]).charAt(0));
        // int data2 = map.get((arr[pointer]).charAt(0));
        char data1 = arr[j].charAt(0);
        char data2 = arr[pointer].charAt(0);

        // System.out.println("Compare " + data1 + " and " + data2);
        if (Character.compare(data1, data2) <= 0)
          pointer = j;
      }
      String smol = arr[pointer];

      arr[pointer] = arr[i];

      arr[i] = smol;
    }
  }

  public static int check(String[] sorted, String[] unsorted) {
    int count = 0;
    for (int i = 0; i < sorted.length; i++) {
      if (!sorted[i].equalsIgnoreCase(unsorted[i]))
        count++;
    }
    return count;
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

          mn = key;
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