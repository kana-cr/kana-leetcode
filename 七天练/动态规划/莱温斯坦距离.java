package 七天练.动态规划;

public class 莱温斯坦距离 {

private char[] a = "mitcmu".toCharArray();
private char[] b = "mtacnu".toCharArray();
private int n = 6;
private int m = 6;
private int minDist = Integer.MAX_VALUE; // 存储结果
// 回溯法
// 调用方式 lwstBT(0, 0, 0);
public void lwstBT(int i, int j, int edist) {
  if (i == n || j == m) {
    if (i < n) edist += (n - i);
    if (j < m) edist += (m - j);
    if (edist < minDist) minDist = edist;
    return;
  }
  if (a[i] == b[j]) { // 两个字符匹配
    lwstBT(i+1, j+1, edist);
  } else { // 两个字符不匹配
    lwstBT(i + 1, j, edist + 1); // 删除a[i]或者b[j]前添加一个字符
    lwstBT(i, j + 1, edist + 1); // 删除b[j]或者a[i]前添加一个字符
    lwstBT(i + 1, j + 1, edist + 1); // 将a[i]和b[j]替换为相同字符
  }
}

public int lwstDP(char[] a, int n, char[] b, int m) {
    int[][] minDist = new int[n][m];
    for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
      if (a[0] == b[j]) minDist[0][j] = j;
      else if (j != 0) minDist[0][j] = minDist[0][j-1]+1;
      else minDist[0][j] = 1;
    }
    for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
      if (a[i] == b[0]) minDist[i][0] = i;
      else if (i != 0) minDist[i][0] = minDist[i-1][0]+1;
      else minDist[i][0] = 1;
    }
    for (int i = 1; i < n; ++i) { // 按行填表
      for (int j = 1; j < m; ++j) {
        if (a[i] == b[j]) minDist[i][j] = min(
            minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]);
        else minDist[i][j] = min(
            minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]+1);
      }
    }
    return minDist[n-1][m-1];
  }
  private int min(int x, int y, int z) {
    int minv = Integer.MAX_VALUE;
    if (x < minv) minv = x;
    if (y < minv) minv = y;
    if (z < minv) minv = z;
    return minv;
  }


}