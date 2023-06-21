package _359_Logger_Rate_Limiter;

import java.util.HashMap;
import java.util.Map;

class Logger {

  private final Map<String, Long> msgLastTimeMap;
  public Logger() {
    msgLastTimeMap = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    Long lastTime = msgLastTimeMap.get(message);
    if (lastTime == null) {
      msgLastTimeMap.put(message, (long) timestamp);
      return true;
    } else {
      if (timestamp - lastTime >= 10) {
        msgLastTimeMap.put(message, (long) timestamp);
        return true;
      } else {
        return false;
      }
    }
  }
}
