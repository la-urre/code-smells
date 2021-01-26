package nerdschool.bar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PubTest {

  private Pub pub;
  private FakePrinter fakePrinter;

  @BeforeEach
  void setUp() {
    // ARRANGE | GIVEN
    fakePrinter = new FakePrinter();
    pub = new Pub(fakePrinter);
  }

  @Test
  void it_should_print_the_receipt() {
    // ACT | WHEN
    pub.printReceipt("hansa", false, 1);

    // ASSERT | THEN
    assertThat(fakePrinter.getAmount()).isEqualTo(1);
    assertThat(fakePrinter.getDrink()).isEqualTo("hansa");
    assertThat(fakePrinter.getTotalPrice()).isEqualTo(74);
    assertThat(fakePrinter.isStudent()).isFalse();
  }

  @Test
  void it_should_cost_74_for_one_beer() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("hansa", false, 1);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(74);
  }

  @Test
  void it_should_cost_103_for_one_cider() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("grans", false, 1);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(103);
  }

  @Test
  void it_should_cost_110_for_one_proper_cider() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("strongbow", false, 1);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(110);
  }

  @Test
  void it_should_cost_115_for_one_gt() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("gt", false, 1);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(115);
  }

  @Test
  void it_should_cost_127_for_one_bacardi_special() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("bacardi_special", false, 1);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(127);
  }

  @Test
  void it_should_throw_an_error_when_ordering_3_bacardi_special() {
    // ACT | WHEN
    Throwable error = catchThrowable(() -> pub.printReceipt("bacardi_special", false, 3));

    // ASSERT | THEN
    assertThat(error)
      .isInstanceOf(RuntimeException.class)
      .hasMessage("Too many drinks, max 2.");
  }

  @Test
  void it_should_throw_an_error_when_ordering_3_gt() {
    // ACT | WHEN
    Throwable error = catchThrowable(() -> pub.printReceipt("gt", false, 3));

    // ASSERT | THEN
    assertThat(error)
      .isInstanceOf(RuntimeException.class)
      .hasMessage("Too many drinks, max 2.");
  }

  @Test
  void it_should_throw_an_error_when_drink_unknown() {
    // ACT | WHEN
    Throwable error = catchThrowable(() -> pub.printReceipt("eguzki", false, 1));

    // ASSERT | THEN
    assertThat(error)
      .isInstanceOf(RuntimeException.class)
      .hasMessage("No such drink exists");
  }

  @Test
  void it_should_cost_148_for_two_beers() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("hansa", false, 2);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(148);
  }

  @Test
  void it_should_cost_minus_10_percent_for_students_for_cider() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("grans", true, 1);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(93);
  }

  @Test
  void it_should_cost_minus_10_percent_for_students_for_beer() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("hansa", true, 1);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(67);
  }

  @Test
  void it_should_cost_minus_10_percent_for_students_for_proper_cider() {
    // ACT | WHEN
    int totalAmount = pub.printReceipt("strongbow", true, 1);

    // ASSERT | THEN
    assertThat(totalAmount).isEqualTo(99);
  }

}
