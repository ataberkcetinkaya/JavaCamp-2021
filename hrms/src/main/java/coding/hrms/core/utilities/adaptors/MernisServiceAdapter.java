package coding.hrms.core.utilities.adaptors;

import java.util.Date;

import org.springframework.stereotype.Service;

import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisServiceAdapter implements ValidationService {

	@Override
	public Result checkIfRealPerson(String nationalIdentity, String firstName, String lastName, Date birthDate) {
		return new SuccessResult();
	}
}
