package coding.hrms.core.verificate;

import coding.hrms.core.utilities.results.Result;

public interface VerificationService {
	Result emailIsVerificate(String email);
	Result employerIsVerificateByEmployee(int id);
}
