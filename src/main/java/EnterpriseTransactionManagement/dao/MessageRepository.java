package EnterpriseTransactionManagement.dao;

import EnterpriseTransactionManagement.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xdcao on 2017/5/2.
 */
@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {


}
