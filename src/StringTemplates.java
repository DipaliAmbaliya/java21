import static java.lang.StringTemplate.RAW;
import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;

public class StringTemplates {
  public static void main(String[] args) {
    String name = "Alex";
    String message = STR."Greetings \{name}!";
    System.out.println(message);


    message = FMT."Greetings %-12s\{name}";
    System.out.println(message);

    StringTemplate st = RAW."Greetings \{name}.";
    message = STR.process(st);
    System.out.println(message);
  }
}
