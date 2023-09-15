package org.example;

import java.math.BigDecimal;

/**
 * Treasure chest that is defined by the amount of gold coins that are stored in it.
 * <p>
 * In this class we assume that each coins is a Twenty-dollar Liberty Gold Coin.
 * This assumption combined with the knowledge of the gold price and the amount of gold
 * in each coin allows us to calculate the dollar value of the treasure chest.
 */

public class TreasureChest {
  /**
   * Price of an ounce of gold.
   */
  private static final BigDecimal GOLD_REP_COIN = new BigDecimal("0.9675");
  
  /**
   * Amount of gold coin measured in ounces.
   **/
  private static BigDecimal goldPrice;
  
  /**
   * Number of gold coins.
   */
  private int gold;
  
  /**
   * Initializes a newly created TreasureChest with the specified number of gold coins.
   *
   * @param goldCoins the number of gold coins in the newly created treasure chest.
   * @throws IllegalArgumentException if <code>goldCoins</code> is negative.
   */
  public TreasureChest(int goldCoins) {
    if (goldCoins < 0) {
      throw new IllegalArgumentException("goldCoins must not be a negative number");
    }
    
    this.gold = goldCoins;
  }
  
  /**
   * @return the price of one ounce of gold
   */
  public static BigDecimal getGoldPrice() {
    return TreasureChest.goldPrice;
  }
  
  /**
   * Updates the price of gold with the <codc>goldPrice</codc> provided.
   *
   * @param goldPrice the goldPrice to set
   * @throws IllegalArgumentException if the is negative.
   */
  public static void setGoldPrice(BigDecimal goldPrice) {
    if (goldPrice.compareTo(BigDecimal.ZERO) == -1){
      throw new IllegalArgumentException("The goldPrice should not be a negative number");
    }
    
    TreasureChest.goldPrice = goldPrice;
  }
  
  /**
   * @return the amount of gold in this treasure chest
   */
  public int getGold() {
    return this.gold;
  }
  
  /**
   * Adds the specified number of coins to this treasure chest.
   *
   * @param number0fCoins number of coins to be added
   * @throws IllegalArgumentException if the <code>numberOfCoins</code> is negative
   */
  public void addGold(int number0fCoins) {
    if (number0fCoins < 0) {
      throw new IllegalArgumentException("numberOfCoins to add should not be a negative number");
    }
    
    this.gold += number0fCoins;
  }
  
  /**
   * Removes the specified number of coins from this treasure chest.
   *
   * @param numberOfCoins number of coins to be removed
   * @return the number of gold coins left in the treasure chest
   * @throws IllegalArgumentException if the <code>number0fCoins</code> is negative
   */
  public int removeGold(int numberOfCoins) {
    if (numberOfCoins < 0) {
      throw new IllegalArgumentException("Number of coins to remove should be a positive number");
    }
    
    if (numberOfCoins > this.gold) {
      throw new IllegalArgumentException(
              "Number of coins to remove should be less than or equals to the number coins in the treasure");
    }
    
    this.gold -= numberOfCoins;
    
    return this.gold;
  }
  
  /** Calculates the dollar value of all the gold coins in the treasure chest.
   * <p>
   * @return the dollar value of the treasure chest
   */
  public BigDecimal valueInDollars() {
    return null;
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * Returns a string of the following format: <br/>
   * [ COINS = {gold} ] <br/>
   * where {gold} is replaced with the number of gold coins in this treasure chest.
   */
  @Override
  public String toString() {
    return "[ COINS = " + this.gold + " ]";
  }
}
