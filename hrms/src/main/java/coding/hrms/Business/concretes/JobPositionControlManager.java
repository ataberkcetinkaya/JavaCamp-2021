package coding.hrms.Business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.Business.abstracts.JobPositionControl;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.dataAccess.abstracts.JobPositionDao;
import coding.hrms.entities.concretes.JobPosition;

@Service
	public class JobPositionControlManager implements JobPositionControl {

		JobPositionDao jobPositionDao;

		@Autowired
		public JobPositionControlManager(JobPositionDao jobPositionDao) {
			this.jobPositionDao = jobPositionDao;
		}

		@Override
		public Result checkRegisteredTitle(String title) {
			if (getByTitle(title).getData() != null) {
				return new ErrorResult("its already registered");
			}
			return new SuccessResult();
		}

		public DataResult<JobPosition> getByTitle(String title) {
			return new SuccessDataResult<JobPosition>(jobPositionDao.findByTitle(title));
		}

	}
