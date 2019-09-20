public class Primary {

    private String input;

    public Primary(String input) {
        this.input = input;
        parse();
    }


    public int parse(){
        try {
            return Integer.parseInt(input);
        }catch (Exception e) {
            // exclude external brackets from expression and parse then
            Expression expression = new Expression(input);
            return expression.parse();
        }
    }

}
