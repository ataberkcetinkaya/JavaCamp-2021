package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>  {
	JobPosition findByTitle(String title);
}
