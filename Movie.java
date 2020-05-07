import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
public class Movie {

    // Movie attributes
    private String title;
    private int length;
    private char[] letters;
    private static Random generator = new Random();

    //method to choose a random string from a list
    public static String randomChoice(List<String> list){
        int randomIndex = generator.nextInt(list.size()); 
        return list.get(randomIndex);
    }

    // Movie constructor
    public Movie() throws IOException {
        Path moviePath = Paths.get("movielist.txt");
        
        try {
            //populate list with all movies from file
            //randomly choose one to instantiate Movie object
            List<String> lines = Files.readAllLines(moviePath);
            
            // populate attributes
            title = randomChoice(lines);
            length = title.length();
            letters = title.toCharArray();

        } catch (IOException e) {
            System.out.println("File can't be read.");
        }
    } // end of constructor

    //Setters and getters for attributes
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }


} //end of Movie class