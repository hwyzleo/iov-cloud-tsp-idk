package net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.po.BtmLogPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 蓝牙模块信息变更日志表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-14
 */
@Mapper
public interface BtmLogDao extends BaseDao<BtmLogPo, Long> {

}
