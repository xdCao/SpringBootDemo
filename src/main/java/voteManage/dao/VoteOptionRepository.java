package voteManage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voteManage.domain.Voteoption;

/**
 * Created by xdcao on 2017/5/3.
 */
@Repository
public interface VoteOptionRepository extends JpaRepository<Voteoption,Integer> {
}
