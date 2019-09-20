package ktds.erp.emp.security.loginPolicy;

import java.util.List;

public interface SecurityLoginPolicyDAO {
	List<PassHistoryDTO> getPasswordChangeList();
	int update(List<PassHistoryDTO> userlist);
}
