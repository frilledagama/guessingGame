//Java program to play a guessing game
//with pokemon names
//players get 10 guesses (this should be change-able)
//Started: 2020-05-07

//import statements
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class GuessTheMovie {
    public static void main(String args[]) {
        try {
            String file = ("C:\\Users\\Maya\\Documents\\School\\Udacity\\udacity-oop-course\\pkmnlist.txt");

            // play the game

            playGame(file);

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }// end of main

    // Method to start the game
    public static void playGame(String file) throws IOException {
        
        System.out.println("Let's play a pkmn guessing game. You have 10 guesses");
        
        // create movie to guess
        Movie newMovie = chooseMovie(file);
        
        // hide the title from players but show # of letters
        char[] hiddenTitle = makeHiddenTitle(newMovie.getLetters());
        
        //create empty list for wrong guesses
        List wrongGuessList = new LinkedList<Character>();

        //show game text (guess, curr guesses, wrong guesses etc.)
        gameText(hiddenTitle, wrongGuessList);

        //get the guess as input
        char guess = makeGuess(newMovie.getTitle(), hiddenTitle);

        //check if guess is a match
        checkGuess(guess, newMovie.getLetters(), hiddenTitle, wrongGuessList);
        
        //gameText(hiddenTitle, wrongGuessList);
        //System.out.println("The movie is: " + newMovie.getTitle());

    }// end of playGame

    // randomly choose movie to guess from given list
    private static Movie chooseMovie(String file) throws IOException {
        Movie newMovie = new Movie(file);
        return newMovie;
    } // end of chooseMovie

    // Method makeHiddenTitle
    // create blanks for the numb of letters in the movie
    private static char[] makeHiddenTitle(char[] letters) {
        char[] hiddenTitle = new char[letters.length];

        for (int i = 0; i < hiddenTitle.length; i++) {
            // put a space if it's a whitespace
            if (letters[i] == ' ') {
                hiddenTitle[i] = ' ';
            } else {
                hiddenTitle[i] = '_';
            }
        }
        return hiddenTitle;
    }// end of makeHiddenTitle

     //method that takes and validates player's guesses
    //returns the guess as a char or finishes the game 
    private static char makeGuess(String title, char[] letters) {

        // get char input from player
        Scanner input = new Scanner(System.in);
        String guess = input.nextLine();

        // get character/letter guess
        while (guess.length() != 1) {
            if (guess.equalsIgnoreCase(title)) {
                // TODO: call the you win method (make you win method)
                // break
            }
            System.out.println("Please input a single character or guess the full title.");
            guess = input.nextLine();
        }

        // read the scanner input as a char
        char letterGuess = guess.charAt(0);

        //close scanner
        input.close();

        return letterGuess;
    }

    // Method to print the text that appears when playing
    private static void gameText(char[] hiddenTitle, List wrongGuessList) {
        System.out.println(
                "You are guessing: " + String.valueOf(hiddenTitle) + " | " + hiddenTitle.length + " characters");
        System.out.println("You have guessed " + wrongGuessList.size() + " wrong letters:" + Arrays.toString(wrongGuessList.toArray()));
        System.out.print("Guess a letter: ");
    }// end of gameText

    //method to check if the guess matches a character
    private static void checkGuess(char guess, char[] letters, char[] hiddenTitle, List wrongGuessList){
        int correctGuess = 0;
        for (int i = 0; i < letters.length; i++){
            if (guess == letters[i]){
                hiddenTitle[i] = letters[i];
                correctGuess++;
            }
        }

        //update wrong Guesses
        if (correctGuess == 0){
            wrongGuessList.add(guess);
        }
    }

}// end of class