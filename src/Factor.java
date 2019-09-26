import java.util.ArrayList;

public class Factor extends Primary {

    private ArrayList<Primary> primaries = new ArrayList<>();

    public Factor(String input) {
        super(input);
    }

    @Override
    public int parse() {
        this.primaries = parser.parseFactor(input);
        int result = primaries.get(0).parse();
        for (int i = 1; i < primaries.size(); i++) {
            result *= primaries.get(i).parse();
        }
        return result;
    }

}
