public class BubbleSort {

  public static void main(final String[] args) {

    final int[] a = {66, 12, 10, 43, 45, 52, 73, 65, 2, 39, 97, 76, 83, 11, 57, 63};
    // aの内容を表示
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

    // バブルソート
    for (int e = a.length; e >= 2; e--) {
      // 先頭から順に隣接する逆順要素を交換する
      for (int i = 1; i < e; i++) {
        if (a[i - 1] > a[i]) {
          // a[i]とa[i-1]を交換
          final int w = a[i];
          a[i] = a[i - 1];
          a[i - 1] = w;
        }
      }
      // aの内容を表示
      for (int i = 0; i < a.length; i++) {
        System.out.print(a[i] + " ");
      }
      System.out.println();
    }
  }
}