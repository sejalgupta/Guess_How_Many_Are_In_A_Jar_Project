import java.util.Random;
import java.io.Console;

public class Jar {
  private String mItemsInJar;
  private int mMaxAmountItems;
  private int mSomeNumber;
  private int mNumberOfGuesses;
  
  public Jar() {
    Console console = System.console();
    System.out.println("ADMINISTRATOR SETUP" + "=========================");
    String itemsInJar = console.readLine("Enter the name of items in the jar:  ");
    mItemsInJar = itemsInJar;
    String maximumAmount = console.readLine("Enter the MAXIMUM number of %s in the jar:  ", itemsInJar);
    mMaxAmountItems = Integer.parseInt(maximumAmount);
  }
  public void fill() { 
    Random random = new Random();
    int someNumber = random.nextInt(mMaxAmountItems);
    mSomeNumber = someNumber;
  }
  
  public void letsPlay() {
    Console console = System.console();
    System.out.println("PLAYER" + "=========================");
    System.out.format("Your goal is to guess how many %s are in the jar. Guess between 1 through %d. Ready.%n", mItemsInJar, mMaxAmountItems);
    int numberOfGuesses = 0;
    String inputGuess = console.readLine("Guess:  ");
    int guess = Integer.parseInt(inputGuess);
    
    if (guess > mMaxAmountItems) {
      System.out.format("Guess was not applicable because it was not in the range. Guess between 1 through %d.%n", mMaxAmountItems);
      inputGuess = console.readLine("Guess:  ");
      guess = Integer.parseInt(inputGuess);
      numberOfGuesses += 1;
    }
    
    else {
      numberOfGuesses += 1;
    }
    
    while (guess != mSomeNumber) {
      
      if(guess > mMaxAmountItems) {
        System.out.format("Guess was not applicable because it was not in the range. Guess between 1 through %d.%n", mMaxAmountItems);
        inputGuess = console.readLine("Guess:  ");
        guess = Integer.parseInt(inputGuess);
        numberOfGuesses += 1;
      }
      
      else if(guess >= mSomeNumber) {
        System.out.println("Oops your guess was too HIGH. Try Again.");
        inputGuess = console.readLine("Guess:  ");
        guess = Integer.parseInt(inputGuess);
        numberOfGuesses += 1;
      }
      
      else {
        System.out.println("Oops your guess was too LOW. Try Again.");
        inputGuess = console.readLine("Guess:  ");
        guess = Integer.parseInt(inputGuess);
        numberOfGuesses += 1;
      }
      
    }
    mNumberOfGuesses = numberOfGuesses;
  }  
    public void Ending() {
      Console console = System.console();
      System.out.format("Congratulations! You got the number of %s correct! The correct answer was %d. You got it right in %s attempt(s).%n", mItemsInJar, mSomeNumber, mNumberOfGuesses);
   }
}