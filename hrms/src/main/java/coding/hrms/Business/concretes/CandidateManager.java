package coding.hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.Business.abstracts.AuthServiceCandidate;
import coding.hrms.Business.abstracts.CandidateService;
import coding.hrms.core.utilities.adaptors.ValidationService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.verificate.VerificationService;
import coding.hrms.dataAccess.abstracts.CandidateDao;
import coding.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

		CandidateDao candidateDao;
		AuthServiceCandidate authServiceCandidate;
		ValidationService validationService;
		VerificationService verificationService;

		@Autowired
		public CandidateManager(CandidateDao candidateDao, AuthServiceCandidate authServiceCandidate,
				ValidationService validationService, VerificationService verificationService) {
			this.candidateDao = candidateDao;
			this.authServiceCandidate = authServiceCandidate;
			this.validationService = validationService;
			this.verificationService = verificationService;
		}

		@Override
		public DataResult<List<Candidate>> getAll() {
			return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listed");
		}

		@Override
		public Result add(Candidate candidate) {
			Result checkNullInput = authServiceCandidate.checkNullInput(candidate);
			Result emailValid = authServiceCandidate.emailValid(candidate.getEmail());
			Result checkRegisteredEmail = authServiceCandidate.checkRegisteredEmail(candidate.getEmail());
			Result checkRegisteredNationalIdentity = authServiceCandidate
					.checkRegisteredNationalIdentity(candidate.getNationalIdentity());
			Result emailIsVerificate = verificationService.emailIsVerificate(candidate.getEmail());
			Result checkIfRealPerson = validationService.checkIfRealPerson(candidate.getNationalIdentity(),
					candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());

			Result[] results = { checkNullInput, emailValid, checkRegisteredEmail, checkRegisteredNationalIdentity,
					emailIsVerificate,checkIfRealPerson };

			for (Result result : results) {
				if (!result.isSuccess()) {
					return result;
				}
			}
			this.candidateDao.save(candidate);
			return new SuccessResult("Saved.");
		}

	}
