package q004;

import java.util.stream.IntStream;

/**
 * Q004 ソートアルゴリズム
 *
 * ListManagerクラスをnewして、小さい順に並び変えた上でcheckResult()を呼び出してください。
 *
 * 実装イメージ:
 * ListManager data = new ListManager();
 * // TODO 並び換え
 * data.checkResult();
 *
 * - ListManagerクラスを修正してはいけません
 * - ListManagerクラスの dataList を直接変更してはいけません
 * - ListManagerクラスの比較 compare と入れ替え exchange を使って実現してください
 */
public class Q004 {

  public static void main(final String[] args) {

    final ListManager data = new ListManager();

    // for文で書いてみたけどStreamで挑戦してみたら以外にスッキリした
    IntStream.range(0, data.size())
        .flatMap(i -> IntStream.range(0, data.size() - 1 - i))
        .filter(j -> data.compare(j, j + 1) == 1)
        .forEach(j -> data.exchange(j, j + 1));

    data.checkResult();
  }
}
// 完成までの時間: xx時間 40分
/**
 * 実行結果
 * > Task :Q004.main()
 * ソートOK: 比較=4950, 入れ替え=2683
 */

