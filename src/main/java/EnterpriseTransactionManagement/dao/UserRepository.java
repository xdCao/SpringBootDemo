package EnterpriseTransactionManagement.dao;

import EnterpriseTransactionManagement.domain.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xdcao on 2017/5/1.
 */
@Repository
public interface UserRepository extends JpaRepository<Employ,Integer> {

    Employ findByEmployNameAndPassword(String name,String password);


}
