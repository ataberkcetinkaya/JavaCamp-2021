package coding.hrms.Business.abstracts;

import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Candidate;

public interface AuthServiceCandidate {
	Result checkNullInput(Candidate candidate);

	Result checkRegisteredEmail(String email);

	Result checkRegisteredNationalIdentity(String nationalIdentity);

	Result emailValid(String email);
}
