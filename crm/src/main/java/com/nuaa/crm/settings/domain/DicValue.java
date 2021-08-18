package com.nuaa.crm.settings.domain;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class DicValue {

   private String ID;
   private String VALUE;
   private String TEXT;
   private String ORDERNO;
   private String TYPECODE;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVALUE() {
        return VALUE;
    }

    public void setVALUE(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getTEXT() {
        return TEXT;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public String getORDERNO() {
        return ORDERNO;
    }

    public void setORDERNO(String ORDERNO) {
        this.ORDERNO = ORDERNO;
    }

    public String getTYPECODE() {
        return TYPECODE;
    }

    public void setTYPECODE(String TYPECODE) {
        this.TYPECODE = TYPECODE;
    }
}
