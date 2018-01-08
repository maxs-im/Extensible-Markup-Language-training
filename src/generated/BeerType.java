
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for beerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{}typeType"/>
 *         &lt;element name="Al" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Manufacture" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ingredients" type="{}ingredientsType"/>
 *         &lt;element name="Chars" type="{}charsType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beerType", propOrder = {
    "name",
    "type",
    "al",
    "manufacture",
    "ingredients",
    "chars"
})
public class BeerType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "Al")
    protected boolean al;
    @XmlElement(name = "Manufacture", required = true)
    protected String manufacture;
    @XmlElement(name = "Ingredients", required = true)
    protected IngredientsType ingredients;
    @XmlElement(name = "Chars", required = true)
    protected CharsType chars;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        if(value.equals("dark") || value.equals("bright")
                || value.equals("camp") || value.equals("alive")) {
            this.type = value;
        } else {
            this.type = "dark";
        }
    }

    /**
     * Gets the value of the al property.
     * 
     */
    public boolean isAl() {
        return al;
    }

    /**
     * Sets the value of the al property.
     * 
     */
    public void setAl(boolean value) {
        this.al = value;
    }

    /**
     * Gets the value of the manufacture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacture() {
        return manufacture;
    }

    /**
     * Sets the value of the manufacture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacture(String value) {
        this.manufacture = value;
    }

    /**
     * Gets the value of the ingredients property.
     * 
     * @return
     *     possible object is
     *     {@link IngredientsType }
     *     
     */
    public IngredientsType getIngredients() {
        return ingredients;
    }

    /**
     * Sets the value of the ingredients property.
     * 
     * @param value
     *     allowed object is
     *     {@link IngredientsType }
     *     
     */
    public void setIngredients(IngredientsType value) {
        this.ingredients = value;
    }

    /**
     * Gets the value of the chars property.
     * 
     * @return
     *     possible object is
     *     {@link CharsType }
     *     
     */
    public CharsType getChars() {
        return chars;
    }

    /**
     * Sets the value of the chars property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharsType }
     *     
     */
    public void setChars(CharsType value) {
        this.chars = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

}
