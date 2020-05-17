package raytracer;

public class Main {
    public static void main(String [] args) throws Exception {
        String file = "./resources/test1.x3d"; // path to foo.xml
        XMLParser xmlParser = new XMLParser(file);
        xmlParser.parse();
        PrettyPrintParser prettyPrintParser = new PrettyPrintParser(file);
        prettyPrintParser.parse();



    }
}
