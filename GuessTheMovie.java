//Java program to play a guessing game
//with movie names
//Started: 2020-05-07

//import statements
import java.io.IOException;


public class GuessTheMovie {
    public static void main(String args[]) {
        try {
            String file = ("C:\\Users\\Maya\\Documents\\School\\Udacity\\udacity-oop-course\\movielist.txt");
            
            //play the game

            playGame(file);

        } catch (IOException e){
            System.out.println("File not found");
        }
    }//end of main

    public static void playGame(String file) throws IOException {
        System.out.println("Let's play a guessing game");
        //create movie to guess
        Movie newMovie = chooseMovie(file);
        //hide the title from players but show # of letters
        char[] hiddenTitle = makeHiddenTitle(newMovie.getLetters());
        int wrongGuess = 0;
        gameText(hiddenTitle, wrongGuess);
        System.out.println("THe movie is: " + newMovie.getTitle());


    }//end of playGame
    
    //randomly choose movie to guess from given list 
    private static Movie chooseMovie(String file) throws IOException {
        Movie newMovie = new Movie(file);
        return newMovie;
    } //end of chooseMovie

    //create blanks for the numb of letters in the movie
    private static char[] makeHiddenTitle(char[] letters){
        char[] hiddenTitle = new char[letters.length];

        for (int i = 0; i < hiddenTitle.length; i++){
            //just put a space if it's a whitespace
            if (letters[i] == ' ') {
                hiddenTitle[i] = ' ';
            } else {
            hiddenTitle[i] = '_';
            }
      }   
        return hiddenTitle;
    }//end of makeHiddenTitle

    private static void gameText(char[] hiddenTitle, int wrongGuesses){
        System.out.println("You are guessing: "  + String.valueOf(hiddenTitle) + " | " + hiddenTitle.length + " characters");
        System.out.println("You have guessed " + wrongGuesses + " wrong letters");
        System.out.println("Guess a letter: ");        
    }//end of gameText


}//end of class