package nerdschool.bar;

public class USBPrinter implements Printer {
    private final String port;

    public USBPrinter(String port) {
        this.port = port;
    }

    public void print(String drink, boolean student, int amount, int totalPrice) {
        printLine("You ordered " + amount + " " + drink);
        if (student) {
            printLine("You benefit from the student discount! Congratz");
        }
        printLine("This will be a total of " + totalPrice);
        printLine("Thanks for drinking with us ! See you soon !");
    }

    private void printLine(String line) {
        // low level implementation ...
    }
}
