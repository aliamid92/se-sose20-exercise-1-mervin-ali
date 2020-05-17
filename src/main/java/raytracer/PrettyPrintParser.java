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

    @Override
    public void parse() {
        super.parse();
    }

    @Override
    public void enter(StartElement startElement) {

        System.out.print(Strings.repeat("\t", this.count));
        System.out.println("->" + startElement.getName().toString());
        this.count++;


    }

    @Override
    public void exit(EndElement endElement) {
        this.count--;
        System.out.print(Strings.repeat("\t", this.count));
        System.out.println("<-" + endElement.getName().toString());

    }
}
