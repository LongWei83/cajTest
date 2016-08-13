package cajTest;

import gov.aps.jca.Channel;
import gov.aps.jca.Context;
import gov.aps.jca.JCALibrary;
import gov.aps.jca.dbr.DBR;
import gov.aps.jca.dbr.DBRType;
import gov.aps.jca.dbr.DBR_Double;

public class Get_Put_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JCALibrary jca = null;
		Context ctxt = null;
		Channel chan = null;
		
		try {
			jca = JCALibrary.getInstance();
			ctxt = jca.createContext(JCALibrary.CHANNEL_ACCESS_JAVA);
			chan = ctxt.createChannel("TEST");
			
			ctxt.pendIO(3);
			
			ctxt.printInfo();
			
			DBR value;
			
			value = chan.get(DBR_Double.TYPE,1);
			
			ctxt.pendIO(3);
			
			value.printInfo();
			
			System.out.println("****");
			System.out.println(((DBR_Double)value).getDoubleValue()[0]);
			
			chan.destroy();
			ctxt.destroy();
		} catch (Exception ex) {
			System.err.println(ex.toString());
			System.exit(1);
		}
	}

}
