import java.util.ArrayList;

public class Term extends Factor{

    private String input;
    private ArrayList<Factor> factors = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();


    public Term(String input) {
        super(input);
    }

    @Override
    public int parse() {
        //parse string to list of factors and list of operators
        int result = factors.get(0).parse();
        for (int i = 1; i < factors.size() - 1; i++) {
            if (operators.get(i - 1).equals("+")) {
                result += factors.get(i).parse();
            }
            else {
                result -= factors.get(i).parse();
            }
        }
        return result;
    }

}
