//package com.Inv.Inventory.Exception;
//
//public class ExGenericException {
//
//}


package com.Inv.InventorySave.Exception;

public class ExGenericException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;

    public String getErrCode() {
        return errorCode;
    }

    public void setErrCode(String errCode) {
        this.errorCode = errCode;
    }

    public String getErrMessage() {
        return errorMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errorMessage = errMessage;
    }

    public ExGenericException(String errCode, String errMessage) {
        this.errorCode = errCode;
        this.errorMessage = errMessage;
    }
}
