package coding.hrms.Business.abstracts;

import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Employer;

public interface AuthServiceEmployer {
	Result checkNullInput(Employer employer);

	Result checkRegisteredEmail(String email);

	Result emailValid(String email,String companyName,String webAdress);

}
