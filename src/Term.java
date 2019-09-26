import java.util.ArrayList;

public class Term extends Factor{

    private ArrayList<String> factors = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();


    public Term(String input) {
        super(input);
    }

    @Override
    public int parse() {
        String openedBrackets = openBrackets(input);
        ArrayList[] parsedInput = parser.parseTerm(openedBrackets);
        this.factors = parsedInput[0];
        this.operators = parsedInput[1];
        int result = new Factor(factors.get(0)).parse();
        for (int i = 1; i < factors.size(); i++) {
            if (operators.get(i - 1).equals("+")) {
                result += new Factor(factors.get(i)).parse();
            }
            else {
                result -= new Factor(factors.get(i)).parse();
            }
        }
        return result;
    }

    private String openBrackets(String input) {
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) == '(') {
                int brackets = 1;
                int j = i+1;
                while ((brackets > 0) & (j < input.length())) {
                    if (input.charAt(j) == '(') brackets++;
                    if (input.charAt(j) == ')') brackets--;
                    j++;
                }
                String internalString = input.substring(i+1, j-1);
                Term internalTerm = new Term(internalString);
                input = input.replace("(" + internalString + ")", Integer.toString(internalTerm.parse()));
            } else i++;
        }
        return input;
    }

}
