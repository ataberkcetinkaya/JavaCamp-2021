package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByNationalIdentity(String nationalIdentity);
	Candidate findByEmail(String email);
}