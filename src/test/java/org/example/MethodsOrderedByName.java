package org.example;

import org.junit.jupiter.api.*;

@Order(3)
@Disabled

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodsOrderedByName {
   @Test
  void testB() {
    System.out.println("Test : B");
  }
  
  @Test
  void testD() {
    System.out.println("Test : D");
  }
  
  @Test
  void testC() {
    System.out.println("Test : C");
  }
  
  @Test
  void testA() {
    System.out.println("Test : A");
  }
  
}
