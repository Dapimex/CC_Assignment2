public class Primary {

    public String input;
    public Parser parser = new Parser();

    public Primary(String input) {
        this.input = input;
    }


    public int parse(){
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            Relation relation = new Relation(input);
            return relation.parse();
        }
    }

}
