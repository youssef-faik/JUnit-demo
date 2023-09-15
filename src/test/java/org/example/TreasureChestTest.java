package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class TreasureChestTest {
  TreasureChest underTest;
  
  @BeforeEach
  void setUp() {
    underTest = new TreasureChest(10);
  }
  
  @Test
  void testValueInDollars() {
    // Given
    
    // When
    
    // Then
    
    fail("Not yet implemented");
  }
  
  @Nested
  @DisplayName("Test cases for setGoldPrice() method")
  class setGoldPriceTests {
    
    @Test
    void setGoldPrice_PositiveGoldPrice_SetGoldPrice() {
      // Given
      BigDecimal goldPrice = BigDecimal.valueOf(997);
      
      // When
      TreasureChest.setGoldPrice(goldPrice);
      
      // Then
      assertEquals(goldPrice, TreasureChest.getGoldPrice(), () -> "Should return " + goldPrice);
    }
    
    @Test
    void setGoldPrice_GoldPriceIsZero_SetGoldPrice() {
      // When
      TreasureChest.setGoldPrice(BigDecimal.ZERO);
      
      // Then
      assertEquals(BigDecimal.ZERO, TreasureChest.getGoldPrice(), () -> "Should return 0");
    }
    
    @Test
    void setGoldPrice_NegativeGoldPrice_ThrowIllegalArgumentException() {
      // Given
      BigDecimal goldPrice = BigDecimal.valueOf(-1);
      
      // When and Then
      IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                                                                       () -> TreasureChest.setGoldPrice(goldPrice),
                                                                       () -> "Should throw an IllegalArgumentException if the given gold price is a negative number"
      );
      
      assertEquals("The goldPrice should not be a negative number",
                   illegalArgumentException.getMessage(),
                   () -> "Exception message should be \"The goldPrice should not be a negative number\""
      );
    }
  }
  
  @Nested
  @DisplayName("Test cases for removeGold() method")
  class removeGoldTests {
    @ParameterizedTest
    @CsvSource(
            {"4, 6",
             "6, 4",
             "10, 0",
             "0, 10"
            }
    )
    void removeGold_PositiveNumberOfCoins_DecrementNumberOfCoins(int numberOfCoins, int expected) {
      // When
      underTest.removeGold(numberOfCoins);
      
      // Then
      assertEquals(
              expected,
              underTest.getGold(),
              () -> "Number of coins left should be " + expected + " after removing " +
                      numberOfCoins + " from " + underTest.getGold()
      );
      
    }
    
    @ParameterizedTest
    @CsvSource(
            {"4, 6",
             "6, 4",
             "10, 0",
             "0, 10"
            }
    )
    void removeGold_PositiveNumberOfCoins_ReturnNumberOfCoinsLeft(int numberOfCoins, int expected) {
      // When and Then
      assertEquals(
              expected,
              underTest.removeGold(numberOfCoins),
              () -> "Number of coins left should be " + expected + " after removing " +
                      numberOfCoins + " from " + underTest.getGold()
      );
      
    }
    
    
    @Test
    void removeGold_NegativeNumberOfCoins_ThrowsIllegalArgumentException() {
      // When and Then
      IllegalArgumentException illegalArgumentException = assertThrows(
              IllegalArgumentException.class,
              () -> underTest.removeGold(-1),
              () -> "should raise exception if the given number of coin to remove is negative"
      );
      
      assertEquals(
              illegalArgumentException.getMessage(),
              "Number of coins to remove should be a positive number",
              () -> "Should raise the exception message for removing negative number of coins"
      );
      
    }
    
    @Test
    void removeGold_NumberOfCoinsExceedsAvailableGold_ThrowsIllegalArgumentException() {
      // When and Then
      IllegalArgumentException illegalArgumentException = assertThrows(
              IllegalArgumentException.class,
              () -> underTest.removeGold(underTest.getGold() + 1),
              () -> "should raise exception if the given number of coin to remove exceeds available gold"
      );
      
      assertEquals(
              illegalArgumentException.getMessage(),
              "Number of coins to remove should be less than or equals to the number coins in the treasure",
              () -> "Should raise the exception message for number of coins to remove exceeds available gold"
      );
      
    }
  }
  
  @Nested
  @DisplayName("Test cases for the constructor")
  class testConstructor {
    @ParameterizedTest
    @ValueSource(
            strings = {"0",
                       "10"
            }
    )
    void treasureChest_PositiveNumberOfCoins_InstantiateInstanceWithGivenGoldCoins(int goldCoins) {
      // Given
      TreasureChest treasureChest = new TreasureChest(goldCoins);
      
      // When and Then
      assertEquals(goldCoins,
                   treasureChest.getGold(),
                   () -> "constructor should Instance an instance with " + goldCoins + " gold coins."
      );
    }
    
    @Test
    void treasureChest_NegativeNumberOfCoins_ThrowsIllegalArgumentException() {
      // When and Then
      IllegalArgumentException illegalArgumentException = assertThrows(
              IllegalArgumentException.class,
              () -> new TreasureChest(-10),
              () -> "constructor should raise illegalArgumentExceptionClass"
      );
      
      assertEquals("goldCoins must not be a negative number",
                   illegalArgumentException.getMessage(),
                   () -> "should raise an exception with the message \"goldCoins must not be a negative number\""
      );
    }
  }
  
  @Nested
  @DisplayName("Test cases for toString() method")
  class testAddGold {
    @ParameterizedTest
    @CsvSource(
            {"0, 10",
             "5, 15"
            }
    )
    void addGold_PositiveNumberOfCoins_IncrementNumberOfCoins(int number0fCoins, int expected) {
      // When
      underTest.addGold(number0fCoins);
      
      // Then
      assertEquals(expected, underTest.getGold(), () -> "number of coins should be: " + expected);
      
    }
    
    @Test
    void addGold_NegativeNumberOfCoins_ThrowIllegalArgumentException() {
      // When and Then
      IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                                                                       () -> underTest.addGold(-1),
                                                                       () -> "should thrown IllegalArgumentException when trying to add negative number of coins"
      );
      
      assertEquals(
              "numberOfCoins to add should not be a negative number",
              illegalArgumentException.getMessage(),
              () -> "should raise an exception with the message \"numberOfCoins to add should not be a negative number\""
      );
      
    }
  }
  
  @Nested
  @DisplayName("ToString tests")
  class testToString {
    @Test
    void testToString_PositiveNumberOfCoins_ReturnNumberOfCoinsInBrackets() {
      assertEquals(
              "[ COINS = 10 ]",
              underTest.toString(),
              () -> ("Should return: " + "[ COINS = 10 ]")
      );
    }
    
    @Test
    void testToString_ZeroNumberOfCoins_ReturnNumberZeroCoinsInBrackets() {
      // Given
      TreasureChest treasureChest = new TreasureChest(0);
      
      // When and Assert
      assertEquals(
              "[ COINS = 0 ]",
              treasureChest.toString(),
              () -> ("Should return: " + "[ COINS = 0 ]")
      );
    }
  }
  
  
}