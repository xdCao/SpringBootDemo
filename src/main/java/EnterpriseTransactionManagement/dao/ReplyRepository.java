package EnterpriseTransactionManagement.dao;

import EnterpriseTransactionManagement.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xdcao on 2017/5/2.
 */
@Repository
public interface ReplyRepository extends JpaRepository<Reply,Integer> {

    List<Reply> findByMessageByMessageId();

}
