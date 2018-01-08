/**
 *   Maxim Galchenko
 *
 *  October 2017
 *   No copyrights
 */



import generated.Beer;
import parsers.BeerDOM;
import parsers.BeerSAX;
import parsers.BeerStAX;
import formatting.*;

/**
 *  This file contains tests for task
 *  And it's entered for program too
 *
 *  @version 1.0
 *  @author Maxim
 */

public class Main {
    public static void main(String argv[]) {
        String path = "data.xml",
                pathXSLT = "Style.xslt",
                outputHTML = "output.html";

        String pathXSDs[] = {"Form.xsd"};

        if(XMLValidator.validate(path, pathXSDs)) {
            System.out.println("Validating passed");
        } else {
            System.out.println("Validating failed");
            return;
        }

        Beer dataFrom1;
        BeerDOM parser1 = new BeerDOM(path);
        dataFrom1 = parser1.getData();
        System.out.println("First completed");
        dataFrom1.show();

        Beer dataFrom2;
        BeerSAX parser2 = new BeerSAX(path);
        dataFrom2 = parser2.getData();
        System.out.println("Second completed");
        dataFrom2.show();

        Beer dataFrom3;
        BeerStAX parser3 = new BeerStAX(path);
        dataFrom3 = parser3.getData();
        System.out.println("Third completed");
        dataFrom1.show();


        dataFrom1.getNew().sort(new BeerComparator());

        System.out.println("\nSORTED:");
        dataFrom1.show();

        XMLTransformer.transform(path, pathXSLT, outputHTML);
    }
}
