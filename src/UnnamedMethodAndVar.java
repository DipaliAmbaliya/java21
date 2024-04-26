import java.util.ArrayList;
import java.util.List;

public class UnnamedMethodAndVar {
  public static void main(String[] args) {
    record Name(String fName, String lName, int age) {};
    Name host = new Name("William","Michael", 37);
    //Unnamed Patterns
    if(host instanceof Name(String fName, String lName, _)) {
      System.out.printf("lName %s fName %s ",lName,fName);
    }
    System.out.println();
//Unnamed Variables
    List arr = new ArrayList();
    arr.add(2);
    arr.add(1);
    for (int i = 0, _ = runOnce(); i < arr.size(); i++) {

      System.out.println(i);
    }
  }
  private static int runOnce() {
    System.out.println("run once");
    return 1;
  }
}
