package raytracer;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class XMLParser {

    private String file;

    public XMLParser(String file) {
        this.file = file;
    }

    // this method will go through the xml file, and as soon as it encounters the opening tag, it will call the enter method
    // and when it encounters the closing tag, it will call the exit method.
    public void parse(){
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader =factory.createXMLEventReader(new FileInputStream(file));
            // "reader" goes into the entire XML file and as soon as it encounters opening or closing tag, it makes a new event call "nextevent"
            while(reader.hasNext()){
                XMLEvent nextevent = reader.nextEvent();
                // if the type of "nextevent" is opening tag, it will call "enter" method, and pass the opening tag to it.
                if(nextevent.isStartElement()){
                    StartElement startElement =nextevent.asStartElement();
                    enter(startElement);
                }
                // if the type of "nextevent" is closing tag, it will call "exit" method, and pass the closing tag to it.
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

    // this method will print both the name and attributes of the opening tag.
    // this method does not print the attributes of the X3D opening tag.
    public void enter(StartElement startElement){

        QName qName =startElement.getName();
        System.out.println("Start Element: " + qName.toString());
        if(!qName.toString().equals("X3D")){
            Iterator <Attribute> Iterator =startElement.getAttributes();
            while (Iterator.hasNext()){
                Attribute attribute =Iterator.next();
                System.out.println(attribute.getName().toString() +" = " + attribute.getValue());
            }

        }


    }


    // this method will print the name of the closing tag.
    public void exit(EndElement endElement){
        QName qName =endElement.getName();
        System.out.println("End Element: " + qName.toString());
    }
}
