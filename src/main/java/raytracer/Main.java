package raytracer;

public class Main {
    public static void main(String [] args) throws Exception {
        String file = "./resources/test1.x3d"; // path to foo.xml

        // Please create a new instance of XMLParser and pass the file into it.
        // then call the parse() method of the instance to see the XML file data on the terminal.
        XMLParser xmlParser = new XMLParser(file);
        xmlParser.parse();

        // In order to see the nesting level of the XML file, Please create a new Instance of PrettyPrintParser class and pass the file into it.
        // then call the parse() method of the instance to see the nesting levels of the XML file in the terminal.
        PrettyPrintParser prettyPrintParser = new PrettyPrintParser(file);
        prettyPrintParser.parse();



    }
}
