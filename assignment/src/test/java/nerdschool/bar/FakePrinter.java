package nerdschool.bar;

public class FakePrinter implements Printer {
  private String drink;
  private boolean student;
  private int amount;
  private int totalPrice;

  @Override
  public void print(String drink, boolean student, int amount, int totalPrice) {
    this.drink = drink;
    this.student = student;
    this.amount = amount;
    this.totalPrice = totalPrice;
  }

  public String getDrink() {
    return drink;
  }

  public boolean isStudent() {
    return student;
  }

  public int getAmount() {
    return amount;
  }

  public int getTotalPrice() {
    return totalPrice;
  }
}
