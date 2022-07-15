package coding.hrms.Business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Employer;

public interface EmployersService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
