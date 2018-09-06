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
        // Creates file instance for reviews
        File reviewFile = new File("movieReviews.txt");
        
        // Boolean that initializes the while loop 
        boolean continueInput = true;
        // while loop that continues to iterate as long as the boolean is true 
        while (continueInput) {
        
       
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
                while(reviewScanner.hasNext()){
                    
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
        //System.out.println("The program has ended.");
        System.out.println("Please enter a file name: ");
    
        // Declares a new scanner to grab a user provided file
        Scanner inputFile = new Scanner(System.in);
        File userFile = new File(inputFile.nextLine());
    
        Scanner listOfWordsScanner = new Scanner(userFile);
        
        int overallWordTotal = 0;
        int wordTotal = 0;
        
        double wordValue = 0;
        double totalWordScore = 0;
        
        // overall total score
        double overAllTotalScore = 0.0;
        int reviewScore;
        
        
        
        String reviewText;
        
    
        while(listOfWordsScanner.hasNext()) {
            
            wordValue = 0;
            totalWordScore = 0; 
            wordTotal = 0;
            reviewScore = 0;
      
           // Grabs word from user provided file
            String wordFromList = listOfWordsScanner.nextLine();
            Scanner reviewScanner2 = new Scanner(reviewFile);
            
            
            while(reviewScanner2.hasNext()){
                    
                    // Read the numeric movie rating
                    reviewScore = reviewScanner2.nextInt();
                    // Read the text of the verbal review
                    reviewText = reviewScanner2.nextLine();
        
                    // If the review contains the word the user entered, print the 
                    // rating and the review and continue; if it does not, process the
                    // next review. Your program will do more than this, of course!!
                    if(reviewText.contains(wordFromList)){
                                //System.out.println("Score: "+reviewScore);
                                //System.out.println("Text: "+reviewText);
                                wordTotal += 1;
                                totalWordScore += reviewScore;
                                wordValue = ((double)totalWordScore /(double) wordTotal);
                                
                    }
                    
                    
                    
                    
                    
            }
         
            System.out.println("Word: " + wordFromList + " was found " +wordTotal + " times: " +wordValue);;
            overAllTotalScore += wordValue;
            overallWordTotal += 1;
            System.out.println("Word total: " + " " + overallWordTotal);
           
            
           

        }
        double listAverage = overAllTotalScore / (double)overallWordTotal;
        System.out.println("The average score of words in: " + userFile + " is " + listAverage);
        String sentiment = "";
        if (listAverage > 2.01) {
            sentiment = "positive";
        } 
        else if (listAverage < 1.99) {
            sentiment = "negative";
        }
        else {
            sentiment = "average";
        }
        System.out.println("The overall sentiment of " + userFile + " is " + sentiment);
        
    } 
    
  
}
