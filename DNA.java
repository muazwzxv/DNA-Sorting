
import java.util.*;

public class DNA {

  private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

  public static void main(String[] args) {
    setup();

    for (Character i : map.keySet()) {
      System.out.println(i);
    }
  }

  public static void setup() {
    map.put('A', 1);
    map.put('C', 2);
    map.put('G', 3);
    map.put('T', 4);
  }
}
