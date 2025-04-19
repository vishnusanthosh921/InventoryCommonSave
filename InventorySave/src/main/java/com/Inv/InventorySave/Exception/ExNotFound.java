//package com.Inv.Inventory.Exception;
//
//public class ExNotFound {
//
//}


package com.Inv.InventorySave.Exception;

public class ExNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errormessage;

    public ExNotFound() {
        super();
    }

    public ExNotFound(String errormessage) {
        super(errormessage);
        this.errormessage = errormessage;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
