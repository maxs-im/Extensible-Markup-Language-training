package parsers;

/**
 *  SAX Parser for the XML
 *  using java only libraries
 *
 *  This class can only read correct data from the XML
 */

import parsers.userhandler.UserHandler;
import generated.Beer;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;

/*
*  There only the shell is written.
*   We work with the SAX, but rest algorithm exposes the handler
*   that described in the package "userhandler" in class UserHandler
* */

public class BeerSAX {
    private Beer data;                                          // our data on exit

    // Starting parsing in time with creating object
    public BeerSAX(String path) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);

            SAXParser parser = spf.newSAXParser();
            UserHandler handler = new UserHandler();
            parser.parse(new File(path), handler);

            data = handler.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // return looking for data
    public Beer getData() {
        return data;
    }
}
