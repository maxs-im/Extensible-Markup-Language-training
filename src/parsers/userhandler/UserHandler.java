package parsers.userhandler;

import generated.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
*       This class created for our SAX parser
 *       we transfer control to the default handler, which look through XML document
 */

public class UserHandler extends DefaultHandler{
    private String element;                                     // current element in the XML

    private ObjectFactory factory = new ObjectFactory();        // factory for our generated classes
    private Beer data;                                          // our data on exit

    // temporary parts of constructed Beer
    private BeerType currentBeer;
    private IngredientsType currentIngredients;
    private CharsType currentChars;
    private CharsType.Spill currentSpill;
    private CharsType.Spill.Container currentContainer;


    /*There I override only functions from the Handler interface because it's enough for our checking
      Only startElement checking that work on the start of each element in XML*/
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
        element = qName;

        switch(qName) {
            case "Beer":
                data = factory.createBeer();
                break;
            case "New":
                currentBeer = factory.createBeerType();
                currentBeer.setID(attributes.getValue("ID"));
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
                currentContainer.setMaterial(attributes.getValue("material"));
                currentSpill.getContainer().add(currentContainer);
                break;
        }
    }

    /*This function responds for the checking during each element sweep and the text between start and end of each element*/
    @Override
    public void characters(char ch[], int start, int length)
        throws SAXException {

        String inside = new String(ch, start, length).trim();

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

        element = "";
    }

    /*There I return my data from XML*/
    public Beer getData() {
        return data;
    }
}
