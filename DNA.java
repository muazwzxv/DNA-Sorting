
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DNA {

  private static List<String> input = new LinkedList<String>();
  private static List<Integer> mn = new LinkedList<Integer>();
  private static List<Solved> result = new LinkedList<Solved>();

  public static void main(String[] args) {
    readFromInput();

    for (String i : input) {
      String[] slice = i.split("");
      String original = String.join("", slice);

      // Sort string
      selectionSort(slice);

      // Find transition
      int diff = check(slice, i.split(""));

      Solved data = new Solved(original, String.join("", slice), diff);
      result.add(data);
    }

    System.out.println("Sorted \n");
    for (Solved ele : result)
      System.out.println(ele.toString());
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

  // public static void DivideAndConquer(String[] data) {
  // if (data.length < 2)
  // return;

  // int mid = data.length / 2;
  // String[] l = new String[mid];
  // String[] r = new String[data.length - mid];

  // for (int i = 0; i < mid; i++)
  // l[i] = data[i];
  // for (int i = mid; i < data.length; i++)
  // r[i - mid] = data[i];

  // DivideAndConquer(l);
  // DivideAndConquer(r);

  // merge(data, l, r, mid, data.length - mid);
  // }

  // public static void merge(String arr[], String left[], String right[], int l,
  // int r) {
  // int lpoint = 0;
  // int rpoint = 0;
  // int mpoint = 0;

  // while (lpoint < l && rpoint < r) {
  // // int ldata = map.get((left[lpoint]).charAt(0));
  // // int rdata = map.get((right[rpoint]).charAt(0));

  // char data1 = left[lpoint].charAt(0);
  // char data2 = right[rpoint].charAt(0);
  // if (Character.compare(data1, data2) <= 0)
  // arr[mpoint++] = left[lpoint++];
  // else
  // arr[mpoint++] = right[rpoint++];
  // // if (ldata <= rdata)
  // // arr[mpoint++] = left[lpoint++];
  // // else
  // // arr[mpoint++] = right[rpoint++];
  // }

  // while (lpoint < l)
  // arr[rpoint++] = left[lpoint++];
  // while (rpoint < r)
  // arr[mpoint++] = right[rpoint++];
  // }
}