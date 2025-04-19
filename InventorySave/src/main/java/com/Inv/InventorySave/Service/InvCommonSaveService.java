package com.Inv.InventorySave.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.Inv.InventorySave.Entity.MoResponse;
import com.Inv.InventorySave.Entity.MoSave;
import com.Inv.InventorySave.Exception.ExGenericException;
import com.Inv.InventorySave.Repository.InvCommonSaveRepository;

@Service
public class InvCommonSaveService implements InvCommonSaveRepository {
	private final SimpleJdbcCall sjdbccRnSave;
	private final DataSourceTransactionManager dstm;
	public InvCommonSaveService(DataSource dataSource) {
		this.sjdbccRnSave = new SimpleJdbcCall(dataSource).withProcedureName("rnsave");
		this.dstm = new DataSourceTransactionManager(dataSource);
	}
	

	@Override
	public MoSave fnGetSaveSummary(String moJson) {
		String jsondata = moJson;
		 System.out.println(jsondata);
		MoSave moSave = new MoSave();
		moSave.setCode(0);
		moSave.setMessage("Not Saved....!!!");
		Integer liCode = 0;
		String emessage="";
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = dstm.getTransaction(transactionDefinition);
		
	
		
	try {
		SqlParameterSource patientservice = new MapSqlParameterSource()
				.addValue("mJsonData",jsondata)
				 .addValue("mOutputCode",0);

		Map out = sjdbccRnSave.execute(patientservice);
		//liCode = (Integer) out.get("moutputcode");
		liCode = ((Number) out.get("mOutputCode")).intValue();
		
		//liCode=1;
	
					
			if (liCode >0) {
				String sMessage = "Saved...!!!  Ref.No. " + liCode.toString();
				moSave.setCode(liCode);
				moSave.setMessage(sMessage);

			} else {
				String sMessage = "Not Saved: Invalid Data";
				moSave.setCode(0);
				moSave.setMessage(sMessage);
				moSave.setRefresh(false);
				return (moSave);
			}
					
			
		
		} catch (DataAccessException | NumberFormatException | TransactionException e) {
			moSave.setCode(0);
			emessage = e.toString();
			System.out.println(e.toString());
			System.out.println(e);
			throw new ExGenericException("504",
					"API DataAccess | NumberFormat | Transaction Exception On fnGetAddInstructions  --" + e.toString());
		} catch (Exception ex) {
			emessage = ex.toString();
			if (ex.getClass() == ExGenericException.class) {
				ExGenericException exGenericException = (ExGenericException) ex;
				moSave.setCode(0);
				throw new ExGenericException("506",
						"ExGenericException fnGetAddInstructions - " + exGenericException.getErrMessage());

			} else {
				moSave.setCode(0);
				 throw new ExGenericException("507", "API Exception On fnGetAddInstructions  --" + ex.toString());
			}
		} finally {
			System.out.println(moSave.getCode());
			if (moSave.getCode() > 0) {
				dstm.commit(transactionStatus);
				moSave.setCode(liCode);
				moSave.setMessage("Saved...!!! ");
				moSave.setRefresh(true);
			} else {
				dstm.rollback(transactionStatus);
				moSave.setCode(0);
				moSave.setMessage(emessage);
				System.out.println("not Saved...!!!");
				moSave.setRefresh(false);
			}
		}
		return moSave;

	}

	
	


}




