/*
 * Copyright © 2009-2017 The Apromore Initiative.
 *
 * This file is part of "Apromore".
 *
 * "Apromore" is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * "Apromore" is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.
 * If not, see <http://www.gnu.org/licenses/lgpl-3.0.html>.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.08.01 at 05:03:55 PM EST 
//


package com.processconfiguration.qml;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QuestionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuestionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="guidelines" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="impact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mapQF" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="partiallyDepends" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fullyDepends" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionType", propOrder = {
    "description",
    "guidelines",
    "impact",
    "mapQFL",
    "preQL",
    "skippable"
})
public class QuestionType {

    @XmlElement(required = true)
    protected String description;
    protected String guidelines;
    protected String impact;
    @XmlAttribute(required = true)
    protected String id;
    @XmlAttribute(required = true)
    protected String mapQF;
    @XmlAttribute
    protected String partiallyDepends;
    @XmlAttribute
    protected String fullyDepends;
    
    //added
    protected List<String> mapQFL;
    //added
    protected ArrayList<ArrayList<String>> preQL;   
    //added
    protected boolean skippable=false;
    //added
	public void setSkippable(boolean skippable){
		this.skippable=skippable;
	}	
	//added
	public boolean isSkippable(){
		return skippable;
	}

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the guidelines property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuidelines() {
        return guidelines;
    }

    /**
     * Sets the value of the guidelines property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuidelines(String value) {
        this.guidelines = value;
    }

    /**
     * Gets the value of the impact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpact() {
        return impact;
    }

    /**
     * Sets the value of the impact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpact(String value) {
        this.impact = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
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
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the mapQF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapQF() {
        return mapQF;
    }
    
    //added
    public List<String> getMapQFL() {
        return mapQFL;
    }

    /**
     * Sets the value of the mapQF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapQF(String value) {
    	this.mapQF = value;
    }
    
    //added
    public void setMapQFL(String value) {
        StringTokenizer st = new StringTokenizer(value, " ");  
    	this.mapQFL = new ArrayList<String>();
    	while(st.hasMoreTokens()){
    		mapQFL.add(st.nextToken().substring(1));
    	}
    }

    /**
     * Gets the value of the partiallyDepends property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartiallyDepends() {
        return partiallyDepends;
    }

    /**
     * Sets the value of the partiallyDepends property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartiallyDepends(String value) {
        this.partiallyDepends = value;
    }
    
    /**
     * Gets the value of the fullyDepends property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullyDepends() {
        return fullyDepends;
    }

    /**
     * Sets the value of the fullyDepends property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullyDepends(String value) {
        this.fullyDepends = value;
    }
    
    //added: WARNING - can only be invoked once this.partiallyDepends and this.fullyDepends have been initialised
    public void setPreQL(){
    	List<String> partiallyDependsL = new ArrayList<String>();
      	List<String> fullyDependsL = new ArrayList<String>();
      	ArrayList<String> tempP = new ArrayList<String>();
    	this.preQL = new ArrayList<ArrayList<String>>();
     	StringTokenizer st;

    	if (this.fullyDepends!=null){
    		st =  new StringTokenizer(this.fullyDepends, " ");  
    		while(st.hasMoreTokens()){
    			fullyDependsL.add(st.nextToken().substring(1));
       		}
    	}
    	if (this.partiallyDepends!=null){
        	st = new StringTokenizer(this.partiallyDepends, " ");  
       		while(st.hasMoreTokens()){
       			partiallyDependsL.add(st.nextToken().substring(1));
       		}
    		for (String pd : partiallyDependsL) {
    			tempP = new ArrayList<String>(fullyDependsL);//this tempP needs to be refreshed for every cycle of the for
    			tempP.add(pd);
    			preQL.add(tempP);
    			//tempP.clear();//this is NOT needed, otherwise it doesn't work as it adds a pointer to a list, rather than copying the element as new
    		} 
    	}
    	else if (this.fullyDepends!=null){
    		preQL.add((ArrayList<String>) fullyDependsL);//preQL is only made of one element containing the full dependencies
    	}
    	else//in case both partiallyDepends and fullyDepends are empty, preQL needs to contain an empty set (as per the formalization)
    		preQL.add(new ArrayList<String>());
    }
    
    //added
    public ArrayList<ArrayList<String>> getPreQL(){
    	return this.preQL;
    }
    
    //added
	public String toString(){
		return this.getDescription();
	}
	
	//added
	public int hashCode(){
		return new Integer(getId()).intValue();
	}

}
