import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }
    public void changeHamletToLeon(){
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletData);
        String replacementText = "Leon";
       // String matchedText;
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()){
          //  matchedText = matcher.group();
            matcher.appendReplacement(stringBuilder, replacementText);
        }
        matcher.appendTail(stringBuilder);


        pattern = Pattern.compile("HAMLET");
        matcher = pattern.matcher(hamletData);
        String replacementText2 = "LEON";
        // String matchedText;
        stringBuilder = new StringBuilder();
        while (matcher.find()){
            //  matchedText = matcher.group();
            matcher.appendReplacement(stringBuilder, replacementText2);
        }
        matcher.appendTail(stringBuilder);
    }

    public void changeHoratioToTariq() {
    }

    public int findHoratio() {
        return 0;
    }

    public int findHamlet() {
        return 0;
    }
}
