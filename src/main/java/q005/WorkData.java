package q005;

/**
 * 作業時間管理クラス
 * 自由に修正してかまいません
 */
public class WorkData {

  /** 社員番号 */
  private final String number;

  /** 部署 */
  private final String department;

  /** 役職 */
  private final String position;

  /** Pコード */
  private final String pCode;

  /** 作業時間(分) */
  private final int workTime;

  public WorkData(final String[] strings) {
    this.number = strings[0];
    this.department = strings[1];
    this.position = strings[2];
    this.pCode = strings[3];
    this.workTime = Integer.parseInt(strings[4]);
  }

  public String getNumber() {
    return number;
  }

  public String getDepartment() {
    return department;
  }

  public String getPosition() {
    return position;
  }

  public String getPCode() {
    return pCode;
  }

  public int getWorkTime() {
    return workTime;
  }
}
