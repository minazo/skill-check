package q006.value;

import java.math.BigDecimal;
import java.util.Stack;

public class MultiplyValue implements IValue {

  @Override
  public void execute(final Stack<BigDecimal> values) {
    // スタックから2つの値を抜き出し、掛け算した結果をスタックに積む
    final BigDecimal right = values.pop();
    final BigDecimal left = values.pop();
    values.push(left.multiply(right));
  }
}
