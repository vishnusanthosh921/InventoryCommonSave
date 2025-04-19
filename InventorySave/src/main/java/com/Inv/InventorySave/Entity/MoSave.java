//package com.Inv.Inventory.Entity;
//
//public class MoSave {
//
//}

package com.Inv.InventorySave.Entity;

/**
 * @date 08 May, 2021
 * @author Aicy
 */

public class MoSave {
	private int code;
    private String message;
    private boolean refresh;
    private String detailapi;
    private String detailpage;

    public MoSave() {
    }

    public MoSave(int code, String message, boolean refresh, String detailapi, String detailpage) {
        this.code = code;
        this.message = message;
        this.refresh = refresh;
        this.detailapi = detailapi;
        this.detailpage = detailpage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRefresh() {
        return refresh;
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }

    public String getDetailapi() {
        return detailapi;
    }

    public void setDetailapi(String detailapi) {
        this.detailapi = detailapi;
    }

    public String getDetailpage() {
        return detailpage;
    }

    public void setDetailpage(String detailpage) {
        this.detailpage = detailpage;
    }
}

