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
        change("Hamlet", "Leon");
    }

    public void changeHoratioToTariq() {
        change("Horatio", "Tariq");
    }
    public void change(String name1,String name2){
        Pattern pattern = Pattern.compile(name1);
        Matcher matcher = pattern.matcher(hamletData);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()){
            matcher.appendReplacement(stringBuilder, name2);
        }
        matcher.appendTail(stringBuilder);
        hamletData = stringBuilder.toString();

        pattern = Pattern.compile(name1.toUpperCase());
        matcher = pattern.matcher(hamletData);
        stringBuilder = new StringBuilder();
        while (matcher.find()){
            matcher.appendReplacement(stringBuilder, name2.toUpperCase());
        }
        matcher.appendTail(stringBuilder);
        hamletData = stringBuilder.toString();
    }

    public int findHoratio() {
        return find("Horatio");
    }

    public int findHamlet() {
        return find("Hamlet");
    }
    public int find(String name){
        int count = 0;
        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        while (matcher.find()){
            count++;
        }
        return count;
    }
}
