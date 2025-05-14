package net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.po.BtmPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 蓝牙模块信息表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-14
 */
@Mapper
public interface BtmDao extends BaseDao<BtmPo, Long> {

    /**
     * 根据序列号查询蓝牙模块信息
     *
     * @param sn 序列号
     * @return 蓝牙模块信息
     */
    BtmPo selectBySn(String sn);

}
