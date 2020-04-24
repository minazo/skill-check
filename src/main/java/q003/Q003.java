package q003;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
 [出力イメージ]
 （省略）
 highest=1
 I=3
 if=2
 ignorance=1
 （省略）
 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {

  public static void main(final String[] args) throws IOException {
    // guavaライブラリ使用。
    /*final ByteSource byteSource = new ByteSource() {
      @Override
      public InputStream openStream() {
        return openDataFile();
      }
    };
    final String sentence = byteSource.asCharSource(Charsets.UTF_8).read();*/

    // StringBuilder使用
    final String sentence = convertToString(openDataFile());

    final Map<String, Long> wordCountMap = Arrays.stream(sentence.split("[.,;]?\\s+"))
        .map(word -> !word.equals("I") ? word.toLowerCase() : word)
        .collect(groupingBy(word -> word, counting()));

    wordCountMap.entrySet().stream()
        .sorted(Entry.comparingByKey(String.CASE_INSENSITIVE_ORDER))
        .forEach(System.out::println);
  }

  /**
   * データファイルを開く resources/q003/data.txt
   */
  private static InputStream openDataFile() {
    return Q003.class.getResourceAsStream("data.txt");
  }

  private static String convertToString(final InputStream inputStream) throws IOException {

    final BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    final StringBuilder stringBuilder = new StringBuilder();
    String sentence;
    while ((sentence = bufferedReader.readLine()) != null) {
      stringBuilder.append(sentence);
    }

    return stringBuilder.toString();
  }
}
// 完成までの時間: xx時間 50分
/**
 * 実行結果
 * > Task :Q003.main()
 * a=5
 * about=2
 * against=1
 * all=1
 * although=1
 * always=2
 * backward=1
 * balance=1
 * begins=1
 * behind=1
 * bicycle=1
 * but=3
 * can=5
 * cannot=2
 * clouds=1
 * come=1
 * communication=1
 * conquer=1
 * courage=1
 * created=1
 * creating=1
 * darkness=2
 * dead-end=1
 * depends=1
 * detour=1
 * didn’t=1
 * do=5
 * doing=1
 * dream=1
 * dreams=1
 * drive=2
 * every=1
 * everyday=1
 * experience=1
 * fail=1
 * failing=1
 * failure=1
 * fear=1
 * finding=1
 * from=1
 * full=2
 * future=1
 * glory=1
 * great=1
 * greatest=1
 * growth=1
 * happens=2
 * happiness=1
 * haste=1
 * hate=2
 * have=1
 * hearing=1
 * highest=1
 * I=3
 * if=2
 * ignorance=1
 * important=1
 * in=3
 * increasing=1
 * is=14
 * isn't=1
 * isn’t=1
 * it=6
 * its=1
 * keep=2
 * kindness=1
 * kites=1
 * life=6
 * light=2
 * like=1
 * love=3
 * me=1
 * more=1
 * most=1
 * moving=1
 * must=1
 * my=3
 * never=2
 * not=5
 * of=3
 * often=1
 * one=1
 * only=2
 * our=1
 * ourselves=1
 * out=2
 * overcoming=1
 * painful=1
 * peace=1
 * please=1
 * process=1
 * pursue=1
 * rather=1
 * religion=1
 * rest=1
 * riding=1
 * rise=1
 * rising=1
 * said=1
 * scares=1
 * slowly=1
 * small=1
 * smile=1
 * so=1
 * speed=1
 * springs=1
 * starts=1
 * street=1
 * suffering=1
 * than=2
 * that=2
 * that.=1
 * the=8
 * them=1
 * there=2
 * thing=2
 * things=1
 * time=1
 * to=5
 * today=1
 * tomorrow=1
 * true=2
 * up=1
 * upon=1
 * walk=2
 * we=1
 * what=4
 * wind=1
 * with=4
 * without=2
 * world=2
 * you=8
 * your=2
 * yourself=3
 * –=1
 */