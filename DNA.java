
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DNA {

  private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

  private static List<String> input = new LinkedList<String>();
  private static List<Integer> in = new LinkedList<Integer>();

  private static HashMap<String, Integer> solved = new HashMap<String, Integer>();

  public static void main(String[] args) {
    setup();
    readFromInput();
    String[] slice;
    for (String i : input) {
      slice = i.split("");
      DivideAndConquer(slice);
      int diff = check(slice, i.split(""));
      solved.put(String.join("", slice), diff);
    }
    System.out.println(solved);
  }

  public static int check(String[] sorted, String[] unsorted) {
    int count = 0;
    for (int i = 0; i < sorted.length; i++) {
      if (sorted[i] != unsorted[i])
        count++;
    }
    return count;
  }

  public static void sort() {
    for (String i : input) {
      DivideAndConquer(i.split(""));
      break;
    }
  }

  public static void DivideAndConquer(String[] data) {
    if (data.length < 2)
      return;

    int mid = data.length / 2;
    String[] l = new String[mid];
    String[] r = new String[data.length - mid];

    for (int i = 0; i < mid; i++)
      l[i] = data[i];
    for (int i = mid; i < data.length; i++)
      r[i - mid] = data[i];

    DivideAndConquer(l);
    DivideAndConquer(r);

    merge(data, l, r, mid, data.length - mid);
  }

  public static void merge(String arr[], String left[], String right[], int l, int r) {
    int lpoint = 0;
    int rpoint = 0;
    int mpoint = 0;

    while (lpoint < l && rpoint < r) {
      int ldata = map.get((left[lpoint]).charAt(0));
      int rdata = map.get((right[rpoint]).charAt(0));
      if (ldata <= rdata)
        arr[mpoint++] = left[lpoint++];
      else
        arr[mpoint++] = right[rpoint++];
    }

    while (lpoint < l)
      arr[rpoint++] = left[lpoint++];
    while (rpoint < r)
      arr[mpoint++] = right[rpoint++];
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
