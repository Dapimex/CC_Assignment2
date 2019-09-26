import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private String[] termSeparators = {">", "<", "="};
    private String[] factorSeparators = {"-", "+"};

    public String[] parseRelation(String input) {
        String leftPart = "";
        String rightPart = "";
        String sep = "";
        List<String> separators = Arrays.asList(termSeparators);
        for (int i = 0; i < input.length(); i++) {
            if (separators.contains(Character.toString(input.charAt(i)))) {
                sep += input.charAt(i);
            } else if (input.charAt(i) != ' ') {
                if (sep.length() > 0) {
                    rightPart += input.charAt(i);
                }
                else {
                    leftPart += input.charAt(i);
                }
            }
        }
        return new String[]{leftPart, sep, rightPart};
    }

    public ArrayList<String>[] parseTerm(String input) {
        ArrayList<String> factors = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        String currentFactor = "";
        List<String> separators = Arrays.asList(factorSeparators);
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) == ' ')) {
                if (separators.contains(Character.toString(input.charAt(i)))) {
                    factors.add(currentFactor);
                    currentFactor = "";
                    operators.add(Character.toString(input.charAt(i)));
                }
                else {
                    currentFactor += input.charAt(i);
                }
            }
        }
        if (currentFactor.length() > 0) factors.add(currentFactor);
        return new ArrayList[]{factors, operators};
    }

    public ArrayList<Primary> parseFactor(String input) {
        ArrayList<Primary> primaries = new ArrayList<>();
        String currentPrimary = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*') {
                primaries.add(new Primary(currentPrimary));
                currentPrimary = "";
            }
            else {
                currentPrimary += input.charAt(i);
            }
        }
        if (currentPrimary.length() > 0) primaries.add(new Primary(currentPrimary));
        return primaries;
    }

}
