package home.edu.processor;


import org.jpos.iso.ISOMsg;

import com.hqsolution.hqserver.app.dao.BankAccount;

public class BankAccountInfoProcessor extends RequestProcessor{
	
	//indicate saved action is OK
	private Boolean persistOk;
	
	public BankAccountInfoProcessor() {
		
	}
	
	@Override
	public void process() {
		super.process();
		ISOMsg isoMsg = getMsgReceived();
		
		//get information from message
		
		persistOk = true;
	}
	
	
	public Boolean isPersistOk() {
		return persistOk;
	}
}
