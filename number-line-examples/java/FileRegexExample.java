import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FileRegexExample {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    try(Stream<String> stream = Files.lines(Paths.get("../test.txt"))) {
      	stream.forEach((String line) -> {
          sb.append(line);
          sb.append(System.lineSeparator());
        });
    } catch (IOException e) {
			e.printStackTrace();
		}

    String testString = sb.toString();
    String regex = "^[0-9]+$";
    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(testString);

    List<String> matchList = new ArrayList<String>();
    while (matcher.find()) {
      matchList.add(matcher.group());
    }

    System.out.println(matchList);
  }
}