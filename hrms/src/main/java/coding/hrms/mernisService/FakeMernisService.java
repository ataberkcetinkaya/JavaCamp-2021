package coding.hrms.mernisService;

import java.time.LocalDate;

public class FakeMernisService {
	public boolean fakeMernisService(String nationalIdentity, String firstName, String lastName, LocalDate birthDate) {

		System.out.println(nationalIdentity + " with national id " + firstName + " " + lastName + " looking good.");
		return true;
	}
}