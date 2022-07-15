package coding.hrms.Business.abstracts;

import coding.hrms.core.utilities.results.Result;

public interface JobPositionControl {
	Result checkRegisteredTitle(String title);
}
