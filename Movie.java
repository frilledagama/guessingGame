import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Movie {

    // Movie attributes
    private String title;
    private int length;
    private char[] letters;

    // Movie constructor
    public Movie(URI file) throws IOException {
        try {
            // calculate numb of Movie titles present in the file
            int numOfLines = (int) Files.lines(Paths.get(file)).count();

            // choose a random line
            // you might have to doand then math.ran +1 to not get zero or smthing
            int chosenMovieLine = (int) Math.round(numOfLines * Math.random());

            // populate attributes
            title = Files.readAllLines(Paths.get(file)).get(chosenMovieLine);
            length = title.length();
            letters = title.toCharArray();

        } catch (IOException e) {
            System.out.println("File can't be used to choose a movie!");
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