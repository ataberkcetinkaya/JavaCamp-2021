package coding.hrms.core.verificate;

import org.springframework.stereotype.Service;

import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessResult;

@Service
	public class VerificationManager implements VerificationService{

		@Override
		public Result emailIsVerificate(String email) {
			return new SuccessResult(email + "verified.");
		}
		
		@Override
		public Result employerIsVerificateByEmployee(int id) {
			return new SuccessResult();
		}
	}