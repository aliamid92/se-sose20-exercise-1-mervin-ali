package raytracer;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLParser {

    private String file;

    public XMLParser(String file) {
        this.file = file;
    }
    public void parse(){
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader =factory.createXMLEventReader(new FileInputStream(file));
            while(reader.hasNext()){
                XMLEvent nextevent = reader.nextEvent();
                if(nextevent.isStartElement()){
                    StartElement startElement =nextevent.asStartElement();
                    enter(startElement);
                }
                else if(nextevent.isEndElement()){
                    EndElement endElement = nextevent.asEndElement();
                    exit(endElement);
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    public void enter(StartElement startElement){
        QName qName =startElement.getName();
        System.out.println(qName.toString());
    }

    public void exit(EndElement endElement){
        QName qName =endElement.getName();
        System.out.println(qName.toString());
    }
}
