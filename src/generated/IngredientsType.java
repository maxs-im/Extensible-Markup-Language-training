
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ingredientsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ingredientsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="water" type="{}amountType"/>
 *         &lt;element name="malt" type="{}amountType"/>
 *         &lt;element name="hops" type="{}amountType"/>
 *         &lt;element name="sugar" type="{}amountType" minOccurs="0"/>
 *         &lt;element name="supplements" type="{}amountType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingredientsType", propOrder = {
    "water",
    "malt",
    "hops",
    "sugar",
    "supplements"
})
public class IngredientsType {

    @XmlSchemaType(name = "integer")
    protected int water;
    @XmlSchemaType(name = "integer")
    protected int malt;
    @XmlSchemaType(name = "integer")
    protected int hops;
    @XmlSchemaType(name = "integer")
    protected Integer sugar;
    @XmlSchemaType(name = "integer")
    protected Integer supplements;


    public int checkAmount(int num) {
        if(num < 0) {
            return 0;
        }
        if( num > 100) {
            return 100;
        }
        return num;
    }
    /**
     * Gets the value of the water property.
     * 
     */
    public int getWater() {
        return water;
    }

    /**
     * Sets the value of the water property.
     * 
     */
    public void setWater(int value) {
        this.water = checkAmount(value);
    }

    /**
     * Gets the value of the malt property.
     * 
     */
    public int getMalt() {
        return malt;
    }

    /**
     * Sets the value of the malt property.
     * 
     */
    public void setMalt(int value) {
        this.malt = checkAmount(value);
    }

    /**
     * Gets the value of the hops property.
     * 
     */
    public int getHops() {
        return hops;
    }

    /**
     * Sets the value of the hops property.
     * 
     */
    public void setHops(int value) {
        this.hops = checkAmount(value);
    }

    /**
     * Gets the value of the sugar property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSugar() {
        return sugar;
    }

    /**
     * Sets the value of the sugar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSugar(Integer value) {
        this.sugar = checkAmount(value);
    }

    /**
     * Gets the value of the supplements property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSupplements() {
        return supplements;
    }

    /**
     * Sets the value of the supplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSupplements(Integer value) {
        this.supplements = checkAmount(value);
    }

}
