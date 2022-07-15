package coding.hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.Business.abstracts.AuthServiceEmployer;
import coding.hrms.Business.abstracts.EmployersService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.verificate.VerificationService;
import coding.hrms.dataAccess.abstracts.EmployerDao;
import coding.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployersService {

		EmployerDao employerDao;
		AuthServiceEmployer authServiceEmployer;
		VerificationService verificationService;

		@Autowired
		public EmployerManager(EmployerDao employerDao,AuthServiceEmployer authServiceEmployer,VerificationService verificationService) {
			this.employerDao = employerDao;
			this.authServiceEmployer = authServiceEmployer;
			this.verificationService = verificationService;
		}

		@Override
		public DataResult<List<Employer>> getAll() {
			return new SuccessDataResult<List<Employer>>
			(employerDao.findAll(),"Data listed");
		}

		@Override
		public Result add(Employer employer) {
			Result checkNullInput = authServiceEmployer.checkNullInput(employer);
			Result checkRegisteredEmail = authServiceEmployer.checkRegisteredEmail(employer.getEmail());
			Result emailValid = authServiceEmployer.emailValid(employer.getEmail(), employer.getCompanyName(),employer.getWebAdress());
			Result emailIsVerificate = verificationService.emailIsVerificate(employer.getEmail());
			Result employerIsVerificateByEmployee = verificationService.employerIsVerificateByEmployee(employer.getId());
			
			Result[] results = {checkNullInput,checkRegisteredEmail,emailValid,emailIsVerificate,employerIsVerificateByEmployee};
			
			for(Result result:results) {
				if(!result.isSuccess()) {
					return result;
				}
			}

			employerDao.save(employer);
			return new SuccessResult("employer added.");
		}
	}
		
