package parsers;
/**
*
*  StAX Parser for the XML
*  using java only libraries
*
*  This class can only read correct data from the XML
*/
import generated.*;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileReader;
import java.util.Iterator;


/*
    There is a cycle in the constructor. So we parse our document step by step like in the SAX parser
    Much of the code even the same

    But we used other shell which more convenient
 */
public class BeerStAX {
    private String element;                                     // current element in the XML

    private ObjectFactory factory = new ObjectFactory();        // factory for our generated classes
    private Beer data;                                          // our data on exit

    // temporary parts of constructed Beer
    private BeerType currentBeer;
    private IngredientsType currentIngredients;
    private CharsType currentChars;
    private CharsType.Spill currentSpill;
    private CharsType.Spill.Container currentContainer;

    // Starting parsing in time with creating object
    public BeerStAX(String path) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileReader(path));

            while(reader.hasNext()) {
                XMLEvent eventRead = reader.nextEvent();

                switch(eventRead.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement curr = eventRead.asStartElement();

                        element = curr.getName().getLocalPart();

                        Iterator<Attribute> tmp = curr.getAttributes();
                        if(tmp.hasNext()) {
                            startElement(tmp.next().getValue());
                        } else {
                            startElement("");
                        }

                        break;
                    case XMLStreamConstants.CHARACTERS:
                        characters(eventRead.asCharacters().getData());
                        element = "";
                        break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // started handle from the start of each element
    private void startElement(String attributes) {
        switch(element) {
            case "Beer":
                data = factory.createBeer();
                break;
            case "New":
                currentBeer = factory.createBeerType();
                currentBeer.setID(attributes);
                data.getNew().add(currentBeer);
                break;
            case "Ingredients":
                currentIngredients = factory.createIngredientsType();
                currentBeer.setIngredients(currentIngredients);
                break;
            case "Chars":
                currentChars = factory.createCharsType();
                currentBeer.setChars(currentChars);
                break;
            case "spill":
                currentSpill = factory.createCharsTypeSpill();
                currentChars.setSpill(currentSpill);
                break;
            case "container":
                currentContainer = factory.createCharsTypeSpillContainer();
                currentContainer.setMaterial(attributes);
                currentSpill.getContainer().add(currentContainer);
                break;
        }
    }

    // handled text inside current element
    private void characters(String inside) {
        switch(element) {
            // set global beer
            case "Name":
                currentBeer.setName(inside);
                break;
            case "Type":
                currentBeer.setType(inside);
                break;
            case "Al":
                currentBeer.setAl(Boolean.parseBoolean(inside));
                break;
            case "Manufacture":
                currentBeer.setManufacture(inside);
                break;

            // set ingredients in beer
            case "water":
                currentIngredients.setWater(Integer.parseInt(inside));
                break;
            case "malt":
                currentIngredients.setMalt(Integer.parseInt(inside));
                break;
            case "hops":
                currentIngredients.setHops(Integer.parseInt(inside));
                break;
            case "sugar":
                currentIngredients.setSugar(Integer.valueOf(inside));
                break;
            case "supplements":
                currentIngredients.setSupplements(Integer.valueOf(inside));
                break;

            // set chars in beer
            case "turns":
                if(currentBeer.isAl()) {
                    currentChars.setTurns(inside);
                }
                break;
            case "transparency":
                currentChars.setTransparency(inside);
                break;
            case "filtered":
                currentChars.setFiltered(Boolean.parseBoolean(inside));
                break;
            case "nutritional":
                currentChars.setNutritional(inside);
                break;

            // set container in spill in chars in beer
            case "container":
                currentContainer.setValue(Double.parseDouble(inside));
                break;
        }
    }

    // return data that we constructed
    public Beer getData() {
        return data;
    }
}
