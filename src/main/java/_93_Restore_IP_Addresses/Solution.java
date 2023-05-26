package _93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private List<String> ans = new ArrayList<>();
  private List<String> ips = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
    dfs(s, 0);

    return ans;
  }

  private void dfs(String s, int start) {
    if (start == s.length() && ips.size() == 4) {
      ans.add(String.join(".", ips));
      return;
    }
    if (start >= s.length() && ips.size() < 4) {
      return;
    }
    if (start < s.length() && ips.size() >= 4) {
      return;
    }
    for (int j = 1; j <= 3 && start + j <= s.length(); j++) {
      String ip = s.substring(start, start + j);
      if (isValidIpSegment(ip)) {
        ips.add(ip);
        dfs(s, start + j);
        ips.remove(ips.size() - 1);
      }
    }

  }

  private boolean isValidIpSegment(String ip) {
    if (ip.length() > 1 && ip.startsWith("0")) {
      return false;
    }
    int ipNum = Integer.parseInt(ip);
    return ipNum >= 0 && ipNum <= 255;
  }
}