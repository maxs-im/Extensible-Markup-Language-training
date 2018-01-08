package formatting;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
*   This class contain function transform witch transform our XML to the HTML
 *   by the rules from XSLT
 *
 *   first param - path to the xml
 *   second - xslt
 *   third - output HTML page
*/

public class XMLTransformer {
    public static void transform(String pathXML, String pathXSLT, String output) {

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transf;
        try {
            transf = factory.newTransformer(new StreamSource(pathXSLT));
            transf.transform(new StreamSource(pathXML), new StreamResult(output));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
