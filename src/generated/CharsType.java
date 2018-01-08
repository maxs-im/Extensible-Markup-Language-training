
package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for charsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="charsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="turns" type="{}percentsType" minOccurs="0"/>
 *         &lt;element name="transparency" type="{}percentsType"/>
 *         &lt;element name="filtered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nutritional">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="([0-9])* kcal"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="spill">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="container" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;>tareType">
 *                           &lt;attribute name="material">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="wooden"/>
 *                                 &lt;enumeration value="polymeric"/>
 *                                 &lt;enumeration value="metallic"/>
 *                                 &lt;enumeration value="textile"/>
 *                                 &lt;enumeration value="cardboard"/>
 *                                 &lt;enumeration value="own"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "charsType", propOrder = {
    "turns",
    "transparency",
    "filtered",
    "nutritional",
    "spill"
})
public class CharsType {

    protected String turns;
    @XmlElement(required = true)
    protected String transparency;
    protected boolean filtered;
    @XmlElement(required = true)
    protected String nutritional;
    @XmlElement(required = true)
        protected CharsType.Spill spill;

    /**
     * Gets the value of the turns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTurns() {
        return turns;
    }

    /**
     * Sets the value of the turns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTurns(String value) {
        this.turns = value;
    }

    /**
     * Gets the value of the transparency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransparency() {
        return transparency;
    }

    /**
     * Sets the value of the transparency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransparency(String value) {
        this.transparency = value;
    }

    /**
     * Gets the value of the filtered property.
     * 
     */
    public boolean isFiltered() {
        return filtered;
    }

    /**
     * Sets the value of the filtered property.
     * 
     */
    public void setFiltered(boolean value) {
        this.filtered = value;
    }

    /**
     * Gets the value of the nutritional property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNutritional() {
        return nutritional;
    }

    /**
     * Sets the value of the nutritional property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNutritional(String value) {
        this.nutritional = value;
    }

    /**
     * Gets the value of the spill property.
     * 
     * @return
     *     possible object is
     *     {@link CharsType.Spill }
     *     
     */
    public CharsType.Spill getSpill() {
        return spill;
    }

    /**
     * Sets the value of the spill property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharsType.Spill }
     *     
     */
    public void setSpill(CharsType.Spill value) {
        this.spill = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="container" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;>tareType">
     *                 &lt;attribute name="material">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="wooden"/>
     *                       &lt;enumeration value="polymeric"/>
     *                       &lt;enumeration value="metallic"/>
     *                       &lt;enumeration value="textile"/>
     *                       &lt;enumeration value="cardboard"/>
     *                       &lt;enumeration value="own"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "container"
    })
    public static class Spill {

        protected List<CharsType.Spill.Container> container;

        /**
         * Gets the value of the container property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the container property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContainer().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CharsType.Spill.Container }
         * 
         * 
         */
        public List<CharsType.Spill.Container> getContainer() {
            if (container == null) {
                container = new ArrayList<CharsType.Spill.Container>();
            }
            return this.container;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;>tareType">
         *       &lt;attribute name="material">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="wooden"/>
         *             &lt;enumeration value="polymeric"/>
         *             &lt;enumeration value="metallic"/>
         *             &lt;enumeration value="textile"/>
         *             &lt;enumeration value="cardboard"/>
         *             &lt;enumeration value="own"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Container {

            @XmlValue
            protected double value;
            @XmlAttribute(name = "material")
            protected String material;

            /**
             * Gets the value of the value property.
             * 
             */
            public double getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             */
            public void setValue(double value) {
                if(value < 0.25) {
                    value = 0.25;
                }
                this.value = value;
            }

            /**
             * Gets the value of the material property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMaterial() {
                return material;
            }

            /**
             * Sets the value of the material property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMaterial(String value) {
                if(value.equals("wooden") || value.equals("polymeric") || value.equals("metallic")
                        || value.equals("textile") || value.equals("cardboard") || value.equals("own")) {
                    this.material = value;
                } else {
                    this.material = "own";
                }
            }

        }

    }

}
