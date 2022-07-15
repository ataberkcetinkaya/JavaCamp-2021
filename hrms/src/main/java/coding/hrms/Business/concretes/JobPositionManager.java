package coding.hrms.Business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.Business.abstracts.JobPositionControl;
import coding.hrms.Business.abstracts.JobPositionService;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.dataAccess.abstracts.JobPositionDao;
import coding.hrms.entities.concretes.JobPosition;

@Service
	public class JobPositionManager implements JobPositionService {
		
		private JobPositionDao jobPositionDao;
		private JobPositionControl jobPositionControl;
		
		@Autowired
		public JobPositionManager(JobPositionDao jobPositionDao,JobPositionControl jobPositionControl) {
			this.jobPositionDao = jobPositionDao;
			this.jobPositionControl = jobPositionControl;
		}

		@Override
		public List<JobPosition> getAll() {
			return jobPositionDao.findAll();
		}

		@Override
		public Result add(JobPosition jobPosition) {
			Result checkRegisteredTitle = jobPositionControl.checkRegisteredTitle(jobPosition.getTitle());
			
			if(!checkRegisteredTitle.isSuccess()) {
				return checkRegisteredTitle;
			}
			
			jobPositionDao.save(jobPosition);
			return new SuccessResult("saved");
			
		}

	}
