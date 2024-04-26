import java.util.concurrent.StructuredTaskScope;

import static java.lang.StringTemplate.STR;

public class ScopedValueTest {
  private static final ScopedValue<String> CONTEXT = ScopedValue.newInstance();

  public static void main(String[] args) {

    ScopedValue.runWhere(CONTEXT, "TestValue", () -> {

      doSomething();

      try (var scope = new StructuredTaskScope<String>()) {

        scope.fork(() -> doSomethingInChildThread());

        try {
          scope.join();
        } catch (InterruptedException ex) {
          //...
        }

      }
    });
  }

  static void doSomething() {
    System.out.println(STR."Scoped Value in doSomething(): \{CONTEXT.get()}");
  }

  static String doSomethingInChildThread() {
    System.out.println(STR."Scoped Value in insideChildThread(): \{CONTEXT.get()}");
    return CONTEXT.get();
  }
}
