// //package com.Inv.Inventory.Repository;
// //
// //public class InvCommonRepository {
// //
// //}


// package com.Inv.InventorySave.Repository;

// import java.util.Map;

// import org.springframework.stereotype.Repository;



// @Repository
// public interface InvSaveCommonRepository {

// 	public Map<String, Object> fnGetScreenJSON(String sql);

	
// }

package com.Inv.InventorySave.Repository;

import org.springframework.stereotype.Repository;

import com.Inv.InventorySave.Entity.MoSave;

@Repository
public interface InvCommonSaveRepository {
	public MoSave fnGetSaveSummary(String moJson);

}

