public class Relation extends Term{

    private String input;
    private String[] termSeparators = {">", "<", "="};

    public Relation(String input) {
        super(input);
    }

    @Override
    public int parse() {
        //parse Expression to get Term or 2 Terms separated
        String leftPart = "";
        String rightPart = "";
        String sep = "";
        // parse string here
        Term leftTerm = new Term(leftPart);
        Term rightTerm = new Term(rightPart);
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
