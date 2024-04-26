import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logger {
  public static void main(String[] args) throws IOException {
    System.Logger logger = System.getLogger("java.lang.ProcessBuilder");
    ProcessBuilder processBuilder = new ProcessBuilder();
    processBuilder.command("ping", "www.google.com");
    Process process = processBuilder.start();
    logger.log(System.Logger.Level.INFO, "Starting process...");
    logger.log(System.Logger.Level.INFO, process.info());
    getInfoTest();
  }

  public static void getInfoTest() throws IOException {
    ProcessBuilder pb = new ProcessBuilder("echo", "Hello World!");
    String na = "<not available>";
    Process p = pb.start();
    ProcessHandle.Info info = p.info();
    System.out.printf("Process ID: %s%n", p.pid());
    System.out.printf("Command name: %s%n", info.command().orElse(na));
    System.out.printf("Command line: %s%n", info.commandLine().orElse(na));

    System.out.printf("Start time: %s%n",
      info.startInstant().map((Instant i) -> i
          .atZone(ZoneId.systemDefault()).toLocalDateTime().toString())
        .orElse(na));

    System.out.printf("Arguments: %s%n",
      info.arguments().map(
          (String[] a) -> Stream.of(a).collect(Collectors.joining(" ")))
        .orElse(na));

    System.out.printf("User: %s%n", info.user().orElse(na));
  }
}
