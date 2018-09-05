import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * CSCI 221, Fall 2018, Programming HW 2
 * Levi Briggs 
 *
 * This program analyzes movie review data to determine if words have a 
 * negative or positive meaning. If a word is used more often in positive 
 * reviews, it is assumed that the word is positive, and vice versa.
 * Currently, it reads review data line by line - each line is a single review in teh form:
 * <integer rating of movie> <Verbal review - text supporting the rating> <newline>
 * 
 * <Add additional comments to further the purpose of this program.>
 */
public class HW2 
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        // Boolean that initializes the while loop 
        boolean continueInput = true;
        // while loop that continues to iterate as long as the boolean is true 
        while (continueInput) {
        // Create file instance for input
        File reviewFile = new File("movieReviews.txt");
        // This scanner instance will read from the aforementioned file, which
        // must be in your BlueJ project directory for it to find it.
        Scanner reviewScanner = new Scanner(reviewFile);
        // This scanner instance reads from the keyboard
        Scanner keyboard = new Scanner(System.in);

        int reviewScore;
        int totalScore = 0;
        int wordTotal = 0; 
        double scoreAverage = 0;
        
        String reviewText;
        String userWord;
        // catch words to stop or continue the program 
        String stopWord = "no";
        String continueWord = "yes";
        

        // Ask the user to enter a word
        System.out.println("Enter a word.");
        userWord = keyboard.nextLine();
        
      
        // This loop iterates as long as there is text in the file      
        while(reviewScanner.hasNext())
        {
            
            // Read the numeric movie rating
            reviewScore = reviewScanner.nextInt();
            // Read the text of the verbal review
            reviewText = reviewScanner.nextLine();

            // If the review contains the word the user entered, print the 
            // rating and the review and continue; if it does not, process the
            // next review. Your program will do more than this, of course!!
            if(reviewText.contains(userWord))
            {
                        //System.out.println("Score: "+reviewScore);
                        //System.out.println("Text: "+reviewText);
                        wordTotal += 1;
                        totalScore += reviewScore;
                        scoreAverage = ((double)totalScore /(double) wordTotal);
                        //System.out.println(" " + wordTotal);
            }
        }
        System.out.println(userWord + " was found " + wordTotal + " times ");
        System.out.println("Total review score: " + totalScore);
        
        System.out.println("Average review score for the word " + userWord + " " +  scoreAverage);
        System.out.println("Would you like to continue?");
        userWord = keyboard.nextLine();
        
        if(userWord.equalsIgnoreCase(continueWord)){
            continueInput = true;
        }
        
       
        
        if(userWord.equalsIgnoreCase(stopWord)) {
            continueInput = false;
        }
       
        
       
        
    }
    System.out.println("The program has ended.");
}


}
