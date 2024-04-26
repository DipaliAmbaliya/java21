import java.io.IOException;
import java.util.OptionalInt;

public class Emoji {
  public static void main(String[] args) {
    String welcomeMsg = "Hey Java Developers! 🙋🏻‍️";

    OptionalInt emojiOptional = welcomeMsg.codePoints().filter(Character::isEmoji).findFirst();

    if (emojiOptional.isPresent()) {
      int emojiCodePoint = emojiOptional.getAsInt();
      if (Character.isEmojiModifierBase(emojiCodePoint)) {
        System.out.println("Emoji can be modified");
        if (Character.isEmojiModifier(emojiCodePoint)) {
          System.out.println("Emoji is modified");
        } else {
          System.out.println("Emoji has not been modified");
        }
      } else {
        System.out.println("Emoji cannot be modified");
      }
    } else {
      System.out.println("No emoji");
    }

//JDK 21 has added methods to ‘java.lang.StringBuilder’ and ‘java.lang.StringBuffer’.--sb2.repeat
    StringBuilder sb2 = new StringBuilder();
    sb2.repeat("-=", 20); // Appends "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" to sb2
    sb2.append("\n");
    sb2.repeat(emojiOptional.getAsInt(), 20);
    System.out.println(sb2);
  }
}
