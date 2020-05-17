package raytracer;

import com.google.common.base.Strings;

import javax.xml.stream.Location;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import java.util.LinkedList;

public class PrettyPrintParser extends XMLParser {
    private int count = 0;


    public PrettyPrintParser(String file) {
        super(file);
    }

    // this method will go through the xml file, and as soon as it encounters the opening tag, it will call enter method
    // and when it encounters the closing tag, it will call the exit method.

    @Override
    public void parse() {
        super.parse();
    }

    // this method prefixes the opening tag with "->" and add space according to the nesting level.
    // it then prints it on the terminal.
    @Override
    public void enter(StartElement startElement) {

        System.out.print(Strings.repeat("\t", this.count));
        System.out.println("->" + startElement.getName().toString());
        this.count++;


    }

    // this method prefixes the closing tag with "<-" and subtract the space according to the nesting level.
    // it then prints it on the terminal.
    @Override
    public void exit(EndElement endElement) {
        this.count--;
        System.out.print(Strings.repeat("\t", this.count));
        System.out.println("<-" + endElement.getName().toString());

    }
}
