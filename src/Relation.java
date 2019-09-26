import java.util.Arrays;
import java.util.List;

public class Relation extends Term{

    private String[] termSeparators = {">", "<", "="};

    public Relation(String input) {
        super(input);
    }

    @Override
    public int parse() {
        String[] parsedInput = parser.parseRelation(input);
        Term leftTerm = new Term(parsedInput[0]);
        String sep = parsedInput[1];
        if (sep.length() == 0) {
            return leftTerm.parse();
        } else {
            Term rightTerm = new Term(parsedInput[2]);
            if (sep.equals(">")) {
                return leftTerm.parse() > rightTerm.parse() ? 1 : 0;
            }
            if (sep.equals("<")) {
                return leftTerm.parse() < rightTerm.parse() ? 1 : 0;
            }
            else {
                return leftTerm.parse() == rightTerm.parse() ? 1 : 0;
            }
        }
    }
}
