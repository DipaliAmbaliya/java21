//javac --release 21 --enable-preview Main.java
// java --enable-preview Main
public class Pattern {
  public static void main(String[] args) {
    record Name(String fName, String lName, int age) {};
    record Address(String Add) {};
    record Person(Name name, Address address) {};
    Name host = new Name("William","Michael", 37);
    Address address = new Address("xyz");
    Person person = new Person(host, address);
  // switch case with record
    String printName = switch(person){
      case Person(var name, var add) -> name + ", " + add + " " ;
    };
    System.out.println(printName);


  // use match the patterns directly instead of checking the conditions
    // before java21
//    if(host instanceof Name) {
//      printName = host.lName + ", " + host.fName + " age: " + host.age;
//      System.out.println(printName);
//    }
    // java21
    if(host instanceof Name(String fName, String lName, int age)) {
       printName = lName + ", " + fName + " age: " + age;
      System.out.println(printName);
    }

  }

}