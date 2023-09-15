package org.example;

import org.junit.jupiter.api.*;


@Order(4)
@Disabled

@TestMethodOrder(value = MethodOrderer.Random.class)
public class MethodsOrderedRandomly {
  @Test
  void testA() {
    System.out.println("Test : A");
  }
  
  @Test
  void testB() {
    System.out.println("Test : B");
  }
  
  @Test
  void testC() {
    System.out.println("Test : C");
  }
  
  @Test
  void testD() {
    System.out.println("Test : D");
  }
  
}
