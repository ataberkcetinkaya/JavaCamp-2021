package coding.hrms.Business.abstracts;

import coding.hrms.core.utilities.results.Result;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();

	Result add(Candidate candidate);
}