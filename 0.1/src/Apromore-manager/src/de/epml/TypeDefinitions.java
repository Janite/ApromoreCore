//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.15 at 04:54:36 PM EST 
//


package de.epml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeDefinitions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeDefinitions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="definition" type="{http://www.epml.de}typeDefinition"/>
 *           &lt;element name="specialization" type="{http://www.epml.de}typeSpecialization"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeDefinitions", propOrder = {
    "definitionOrSpecialization"
})
public class TypeDefinitions {

    @XmlElements({
        @XmlElement(name = "specialization", type = TypeSpecialization.class),
        @XmlElement(name = "definition", type = TypeDefinition.class)
    })
    protected List<TExtensibleElements> definitionOrSpecialization;

    /**
     * Gets the value of the definitionOrSpecialization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the definitionOrSpecialization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDefinitionOrSpecialization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeSpecialization }
     * {@link TypeDefinition }
     * 
     * 
     */
    public List<TExtensibleElements> getDefinitionOrSpecialization() {
        if (definitionOrSpecialization == null) {
            definitionOrSpecialization = new ArrayList<TExtensibleElements>();
        }
        return this.definitionOrSpecialization;
    }

}
