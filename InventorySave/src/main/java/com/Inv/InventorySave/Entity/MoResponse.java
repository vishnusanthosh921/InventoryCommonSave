//package com.Inv.Inventory.Entity;
//
//public class MoResponse {
//
//}


package com.Inv.InventorySave.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class MoResponse {
	private boolean success; 
    private int httpstatus;
    private String message;
    private Object data;

    public MoResponse() {
    }
    public MoResponse(boolean success,int httpstatus,String message,String data) {
        this.success = success;
        this.httpstatus = httpstatus;
        this.message = message;
        this.data = data;
    }
    
    @XmlElement
    public boolean getSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success;} 
    @XmlElement
    public int getHttpstatus() { return httpstatus; }
    public void setHttpstatus(int httpstatus) { this.httpstatus = httpstatus;}
    @XmlElement
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    @XmlElement
    public Object getData() {return data;}
    public void setData(Object data) {this.data = data;}
}
