package org.example;

import org.junit.jupiter.api.*;

@Order(2)
@Disabled

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndex {
  StringBuilder completed = new StringBuilder();
  
  @BeforeAll
  static void beforeAll() {
  }
  
  @AfterAll
  void afterAll() {
  }
  
  
  @Test
  @Order(2)
  void testD() {
    System.out.println("Test : D");
    completed.append(2);
    System.out.println(completed);
  }
  
  @Test
  @Order(1)
  void testB() {
    System.out.println("Test : B");
    completed.append(1);
    System.out.println(completed);
  }
  
  @Test
  @Order(3)
  void testC() {
    System.out.println("Test : C");
    completed.append(3);
    System.out.println(completed);
  }
  
  @Test
  @Order(4)
  void testA() {
    System.out.println("Test : A");
    completed.append(4);
    System.out.println(completed);
  }
  
}
