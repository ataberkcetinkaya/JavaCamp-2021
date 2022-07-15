package coding.hrms.Business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.dataAccess.abstracts.CandidateDao;
import coding.hrms.entities.concretes.Candidate;

@Service
public class AuthServiceCandidateManager {

	private CandidateDao candidateDao;

	@Autowired
	public AuthServiceCandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}

	public Result checkNullInput(Candidate candidate) {
		
		System.out.println(" : " + candidateDao.findByNationalIdentity(candidate.getNationalIdentity()));

		if (candidate.getEmail().strip().equals("") || candidate.getPassword().strip().equals("")
				|| candidate.getFirstName().strip().equals("") || candidate.getLastName().strip().equals("")
				|| candidate.getNationalIdentity().strip().equals("") || candidate.getBirthDate() == null) {
			return new ErrorResult("fill please");
		}
		return new SuccessResult();
	}

	public Result checkRegisteredNationalIdentity(String nationalIdentity) {
		if (getByNationalIdentity(nationalIdentity).getData() != null) {

			return new ErrorResult("registered already");
		}
		return new SuccessResult();
	}
	
	public Result checkRegisteredEmail(String email) {
		if (getByEmail(email).getData() != null) {

			return new ErrorResult("email registered before");
		}
		return new SuccessResult();
	}

	public Result emailValid(String email) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		Boolean emailMatcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();

		if (!emailMatcher) {
			return new ErrorResult("wrong type");
		}
		return new SuccessResult();

	}
	
	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity){
		return new SuccessDataResult<Candidate>(candidateDao.findByNationalIdentity(nationalIdentity));
	}

	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(candidateDao.findByEmail(email));
	}

}
