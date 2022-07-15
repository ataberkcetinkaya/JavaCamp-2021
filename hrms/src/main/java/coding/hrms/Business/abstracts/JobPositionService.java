package coding.hrms.Business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
	Result add(JobPosition jobPosition);
}