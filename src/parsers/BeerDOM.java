package parsers;

/**
 *  DOM Parser for the XML
 *  using java only libraries
 *
 *  This class can only read correct data from the XML
 */

import generated.*;
import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class BeerDOM {
    private ObjectFactory factory = new ObjectFactory();        // factory for our generated classes
    private Beer data;                                          // our data on exit

    // Starting parsing in time with creating object
    public BeerDOM(String path) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(path));
            doc.getDocumentElement().normalize();

            data = factory.createBeer();

            NodeList allNodeBeer = doc.getElementsByTagName("New");
            List<BeerType> beerList = data.getNew();

            for(int i = 0; i < allNodeBeer.getLength(); ++i) {
                beerList.add(parseBeer(allNodeBeer.item(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // return needed data from XML
    public Beer getData() {
        return data;
    }

    // parse part of the global element from Beer -- New beer
    private BeerType parseBeer(Node node) {
        BeerType curr = factory.createBeerType();
        if(node.getNodeType() == Node.ELEMENT_NODE) {

            // parse simple elements
            Element element = (Element) node;
            curr.setID(element.getAttribute("ID"));
            curr.setName(getFirstStringValueNode("Name", element));
            curr.setType(getFirstStringValueNode("Type", element));
            curr.setAl(Boolean.parseBoolean(getFirstStringValueNode("Al", element)));
            curr.setManufacture(getFirstStringValueNode("Manufacture", element));

            // parse Ingredients
            curr.setIngredients(parseIngredients(element.getElementsByTagName("Ingredients").item(0)));

            // parse charsType
            curr.setChars(parseChars(curr.isAl(), element.getElementsByTagName("Chars").item(0)));

        }

        return curr;
    }

    // supporting function for exstracting first value from the Node
    private String getFirstStringValueNode(String tag, Element element) {
        NodeList tmp =  element.getElementsByTagName(tag);
        if(tmp.getLength() == 0) {
            return "";
        }
        return tmp.item(0).getTextContent();
    }

    // parse less part from the Beer -- Ingredients
    private IngredientsType parseIngredients(Node node) {
        IngredientsType curr = factory.createIngredientsType();
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            curr.setWater(Integer.parseInt(getFirstStringValueNode("water", element)));
            curr.setMalt(Integer.parseInt(getFirstStringValueNode("malt", element)));
            curr.setHops(Integer.parseInt(getFirstStringValueNode("hops", element)));

            // to check if not exists
            String tmp;
            tmp = getFirstStringValueNode("sugar", element);
            if(!tmp.equals("")) {
                curr.setSugar(Integer.valueOf(tmp));
            }
            tmp = getFirstStringValueNode("supplements", element);
            if(!tmp.equals("")) {
                curr.setSupplements(Integer.valueOf(tmp));
            }
        }

        return curr;
    }

    // parse another less part of the Beer -- Chars
    private CharsType parseChars(boolean isAl, Node node) {
        CharsType curr = factory.createCharsType();
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            if(isAl) {
                curr.setTurns(getFirstStringValueNode("turns", element));
            }
            curr.setTransparency(getFirstStringValueNode("transparency", element));
            curr.setFiltered(Boolean.parseBoolean(getFirstStringValueNode("filtered", element)));
            curr.setNutritional(getFirstStringValueNode("nutritional", element));

            //parse spill
            curr.setSpill(parseSpill(element.getElementsByTagName("spill").item(0)));
        }

        return curr;
    }

    // Parse Spill from the Chars
    private CharsType.Spill parseSpill(Node node) {
        CharsType.Spill curr = factory.createCharsTypeSpill();
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            List<CharsType.Spill.Container> tareList = curr.getContainer();

            NodeList tareNodeList = element.getElementsByTagName("container");
            for(int i = 0; i < tareNodeList.getLength(); ++i) {
                tareList.add(parseContainer(tareNodeList.item(i)));
            }
        }

        return curr;
    }

    // Parse all containers if they are exist from the Spill
    private CharsType.Spill.Container parseContainer(Node node) {
        CharsType.Spill.Container curr = factory.createCharsTypeSpillContainer();
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            curr.setMaterial(element.getAttribute("material"));
            curr.setValue(Double.parseDouble(element.getTextContent()));
        }

        return curr;
    }
}
