package com.coderanch.beginner.exercise;

import static com.coderanch.beginner.exercise.MinMax.min;
 
public class MinMaxManualTest {
 
   public static void main(String[] args) {
      MinMaxManualTest tests = new MinMaxManualTest();
      tests.runAll();
 
      System.out.println("All tests passed.");
   }
 
   private void runAll() {
      testMin();
 
      // ... will add more later. For now, focus on min()
   }
 
   private void testMin() {
      testAllPositiveNumbers();
      testSomeNegativeNumbers();
      testAllNegativeNumbers();
   }       
 
   private void testAllPositiveNumbers() {
//      assertEquals(1, min(arrayOf(4, 1, 10, 99)));
   }

   private static int[] arrayOf(int... numbers) {
      return numbers;
   }

   private void testSomeNegativeNumbers() {
      assertEquals(-4, min(arrayOf(1, -4, 10, -3, 2)));
   }
 
   private void testAllNegativeNumbers() {
//      assertEquals(-10, min(arrayOf(-1, -3, -10, -4 )));
   }
 
   private void assertEquals(int expected, int actual) {
      if (expected != actual) {
         throw new RuntimeException(String.format("Test failed: expected %d but got %d instead", expected, actual));
      }
   }
}