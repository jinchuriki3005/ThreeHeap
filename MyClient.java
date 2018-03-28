//Max Tran, CSE 373 Winter 2017, HW#2
//test file for threeHeap.java

import java.util.List;
import java.util.ArrayList;
public class MyClient {
   public static void main(String[]args) {
      ThreeHeap example = new ThreeHeap();
      example.insert(7);
      example.insert(3);
      example.insert(9);
      example.insert(2);
      example.insert(1);
      example.insert(4);
      example.insert(5);
      example.insert(6);
      example.insert(12);
      example.insert(13);
      example.insert(10);
      example.insert(9);
      example.insert(14);
      example.insert(8);
      example.insert(15);
      example.insert(5);
      example.insert(3);
      example.insert(1);
      System.out.println("Min = " +example.findMin());
      System.out.println(example.toString());
      System.out.println("Delete = " + example.deleteMin());
      System.out.println(example.toString());
      System.out.println("Min = " + example.findMin());
     
      System.out.println(example.toString());
      example.insert(3);
      example.insert(3);
      example.insert(6);
      example.insert(7);
      System.out.println(example.toString());
      System.out.println("Delete = " + example.deleteMin());
      System.out.println(example.toString());
      System.out.println("Delete = " + example.deleteMin());
      System.out.println(example.toString());
      System.out.println(example.isEmpty());
      example.makeEmpty();
      System.out.println(example.isEmpty());
      List<Double> list = new ArrayList<Double>(10);
      list.add(30.0); //0 index, doesn't matter
      list.add(5.6);
      list.add(6.4);
      list.add(4.3);
      list.add(3.2);
      list.add(1.8);
      list.add(2.4);
      list.add(5.6);
      list.add(6.8);
      list.add(2.1);
      list.add(1.8);
      list.add(3.2);

      System.out.println(example.toString());
      example.buildQueue(list);
      System.out.println(example.toString());
      System.out.println("size " + example.size());
      System.out.println("delete " + example.deleteMin());
      System.out.println(example.toString());

   }
}
