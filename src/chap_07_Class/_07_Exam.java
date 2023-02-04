package chap_07_Class;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class _07_Exam {
  public int channel;
  public void channelUp() {
    channel++;
  }
  public void channelDown() {
    channel--;
  }
  public String printChannel() {
    return "현재 채널은 " + channel + "번 입니다.";
  }

  public _07_Exam(int channel) {
    this.channel = channel;
  }

  public static void main(String[] args) {
    _07_Exam tv1 = new _07_Exam(10);
    tv1.channelDown();
    String nowChannel = tv1.printChannel();
    tv1.channelDown();
    System.out.println(nowChannel);

    _07_Exam[] tvArr = new _07_Exam[5];
    Arrays.fill(tvArr, new _07_Exam(0));
    System.out.println(tvArr[1].channel);

    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    System.out.println(list);
  }
}
