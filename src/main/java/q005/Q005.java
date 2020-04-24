package q005;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Q005 データクラスと様々な集計
 *
 * 以下のファイルを読み込んで、WorkDataクラスのインスタンスを作成してください。
 * resources/q005/data.txt
 * (先頭行はタイトルなので読み取りをスキップする)
 *
 * 読み込んだデータを以下で集計して出力してください。
 * (1) 役職別の合計作業時間
 * (2) Pコード別の合計作業時間
 * (3) 社員番号別の合計作業時間
 * 上記項目内での出力順は問いません。
 *
 * 作業時間は "xx時間xx分" の形式にしてください。
 * また、WorkDataクラスは自由に修正してください。
 *
 [出力イメージ]
 部長: xx時間xx分
 課長: xx時間xx分
 一般: xx時間xx分
 Z-7-31100: xx時間xx分
 I-7-31100: xx時間xx分
 T-7-30002: xx時間xx分
 （省略）
 194033: xx時間xx分
 195052: xx時間xx分
 195066: xx時間xx分
 （省略）
 */
public class Q005 {

  public static void main(final String[] args) throws URISyntaxException, IOException {

    final List<WorkData> workDataList = getWorkDataList();
    summarizeInPosition(workDataList);
    summarizeInPCode(workDataList);
    summarizeInNumber(workDataList);
  }

  /**
   * 作業時間をWorkDataにマッピング
   */
  private static List<WorkData> getWorkDataList() throws URISyntaxException, IOException {

    final Path path = Paths.get(Q005.class.getResource("data.txt").toURI());
    try (final Stream<String> stream = Files.lines(path).skip(1)) {
      return stream
          .map(line -> new WorkData(line.split(",", -1)))
          .collect(Collectors.toList());
    } catch (final IOException ex) {
      ex.printStackTrace();
      throw ex;
    }
  }

  /**
   * 役職で集計して出力
   */
  private static void summarizeInPosition(final List<WorkData> workDataList) {

    final Map<String, Integer> summary = workDataList.stream()
        .collect(Collectors.groupingBy(
            WorkData::getPosition,
            Collectors.summingInt(WorkData::getWorkTime)));

    print(summary);
  }

  /**
   * Pコードで集計して出力
   */
  private static void summarizeInPCode(final List<WorkData> workDataList) {

    final Map<String, Integer> summary = workDataList.stream()
        .collect(Collectors.groupingBy(
            WorkData::getPCode,
            Collectors.summingInt(WorkData::getWorkTime)));

    print(summary);
  }

  /**
   * 社員番号で集計して出力
   */
  private static void summarizeInNumber(final List<WorkData> workDataList) {

    final Map<String, Integer> summary = workDataList.stream()
        .collect(Collectors.groupingBy(
            WorkData::getNumber,
            Collectors.summingInt(WorkData::getWorkTime)));

    print(summary);
  }

  private static void print(final Map<String, Integer> summary) {
    summary.forEach((key, value) -> System.out.println(
        String.format("%s: %d時間%d分", key, value / 60, value % 60)));
  }
}
// 完成までの時間: xx時間 20分
/**
 * 実行結果
 * > Task :Q005.main()
 * 課長: 357時間49分
 * 一般: 1615時間13分
 * 部長: 179時間35分
 * Z-7-31100: 210時間0分
 * T-7-32001: 600時間44分
 * I-7-31100: 1時間45分
 * T-7-30002: 924時間13分
 * T-7-30001: 1時間0分
 * T-7-31001: 414時間55分
 * 217006: 151時間33分
 * 217023: 144時間42分
 * 217031: 152時間4分
 * 207005: 144時間0分
 * 201179: 115時間6分
 * 200112: 164時間31分
 * 205159: 152時間48分
 * 203011: 144時間0分
 * 202164: 155時間0分
 * 195052: 193時間18分
 * 195066: 152時間0分
 * 194033: 179時間35分
 * 218119: 160時間0分
 * 215129: 144時間0分
 */