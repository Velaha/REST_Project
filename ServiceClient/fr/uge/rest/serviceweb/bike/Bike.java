/**
 * Bike.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.rest.serviceweb.bike;

public class Bike  implements java.io.Serializable {
    private boolean available;

    private int avgNote;

    private java.lang.String[] comments;

    private java.lang.String etat;

    private long id;

    private int[] notes;

    private int price;

    private int timesRented;

    public Bike() {
    }

    public Bike(
           boolean available,
           int avgNote,
           java.lang.String[] comments,
           java.lang.String etat,
           long id,
           int[] notes,
           int price,
           int timesRented) {
           this.available = available;
           this.avgNote = avgNote;
           this.comments = comments;
           this.etat = etat;
           this.id = id;
           this.notes = notes;
           this.price = price;
           this.timesRented = timesRented;
    }


    /**
     * Gets the available value for this Bike.
     * 
     * @return available
     */
    public boolean isAvailable() {
        return available;
    }


    /**
     * Sets the available value for this Bike.
     * 
     * @param available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }


    /**
     * Gets the avgNote value for this Bike.
     * 
     * @return avgNote
     */
    public int getAvgNote() {
        return avgNote;
    }


    /**
     * Sets the avgNote value for this Bike.
     * 
     * @param avgNote
     */
    public void setAvgNote(int avgNote) {
        this.avgNote = avgNote;
    }


    /**
     * Gets the comments value for this Bike.
     * 
     * @return comments
     */
    public java.lang.String[] getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this Bike.
     * 
     * @param comments
     */
    public void setComments(java.lang.String[] comments) {
        this.comments = comments;
    }


    /**
     * Gets the etat value for this Bike.
     * 
     * @return etat
     */
    public java.lang.String getEtat() {
        return etat;
    }


    /**
     * Sets the etat value for this Bike.
     * 
     * @param etat
     */
    public void setEtat(java.lang.String etat) {
        this.etat = etat;
    }


    /**
     * Gets the id value for this Bike.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Bike.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the notes value for this Bike.
     * 
     * @return notes
     */
    public int[] getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this Bike.
     * 
     * @param notes
     */
    public void setNotes(int[] notes) {
        this.notes = notes;
    }


    /**
     * Gets the price value for this Bike.
     * 
     * @return price
     */
    public int getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Bike.
     * 
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }


    /**
     * Gets the timesRented value for this Bike.
     * 
     * @return timesRented
     */
    public int getTimesRented() {
        return timesRented;
    }


    /**
     * Sets the timesRented value for this Bike.
     * 
     * @param timesRented
     */
    public void setTimesRented(int timesRented) {
        this.timesRented = timesRented;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bike)) return false;
        Bike other = (Bike) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.available == other.isAvailable() &&
            this.avgNote == other.getAvgNote() &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              java.util.Arrays.equals(this.comments, other.getComments()))) &&
            ((this.etat==null && other.getEtat()==null) || 
             (this.etat!=null &&
              this.etat.equals(other.getEtat()))) &&
            this.id == other.getId() &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              java.util.Arrays.equals(this.notes, other.getNotes()))) &&
            this.price == other.getPrice() &&
            this.timesRented == other.getTimesRented();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isAvailable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getAvgNote();
        if (getComments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEtat() != null) {
            _hashCode += getEtat().hashCode();
        }
        _hashCode += new Long(getId()).hashCode();
        if (getNotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNotes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getPrice();
        _hashCode += getTimesRented();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bike.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "Bike"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("available");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "available"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avgNote");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "avgNote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://shop.serviceweb.rest.uge.fr", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "etat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://shop.serviceweb.rest.uge.fr", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timesRented");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bike.serviceweb.rest.uge.fr", "timesRented"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
