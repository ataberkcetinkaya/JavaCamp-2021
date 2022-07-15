package homework4.adapters;

import java.rmi.RemoteException;
import java.time.ZoneId;

import homework4.abstracts.CustomerCheckManager;
import homework4.entities.Customer;
import homework4.interfaces.Result;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter extends CustomerCheckManager  {

	@Override
	public Result CheckPersonIdentity(Customer customer) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = true;
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(
					Long.parseLong(customer.getIdentityNumber()),
					customer.getFirstName().toUpperCase(),
					customer.getLastName().toUpperCase(), 
					customer.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear()
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(result) {
			return new homework4.models.Result(true);
		}else {
			return new homework4.models.Result(false, "Failed.");
		}
			
	}


}