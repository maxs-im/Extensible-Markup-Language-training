package formatting;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;


/**
 * XML Validation
 *
 * function validate checks all grammar from different xsds on one xml
 * first param - path to XML
 * second param - mass of paths to XSDs
 */
public class XMLValidator {
    public static boolean validate(String pathXML, String[] pathXSDs) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                                                                    // default constant equals http://www.w3.org/2001/XMLSchema
        Source xsdSources[] = new Source[pathXSDs.length];

        for(int i = 0; i < pathXSDs.length; ++i) {
            xsdSources[i] = new StreamSource(pathXSDs[i]);
        }

        try {
            Schema schema = factory.newSchema(xsdSources);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(pathXML));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}