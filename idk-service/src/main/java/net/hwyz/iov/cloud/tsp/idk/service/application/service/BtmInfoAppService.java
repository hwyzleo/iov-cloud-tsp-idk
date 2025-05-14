package net.hwyz.iov.cloud.tsp.idk.service.application.service;

import cn.hutool.core.util.ObjUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.framework.common.util.StrUtil;
import net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.dao.BtmDao;
import net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.dao.BtmLogDao;
import net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.po.BtmLogPo;
import net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.po.BtmPo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 蓝牙模块信息相关应用服务类
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BtmInfoAppService {

    private final BtmDao btmDao;
    private final BtmLogDao btmLogDao;

    /**
     * 批量导入中央计算平台信息
     *
     * @param batchNum     批次号
     * @param supplierCode 供应商编码
     * @param btmList      蓝牙模块列表
     */
    public void batchImport(String batchNum, String supplierCode, List<BtmPo> btmList) {
        if (StrUtil.isBlank(supplierCode)) {
            logger.warn("数据批次[{}]蓝牙模块信息供应商编码为空", batchNum);
        }
        for (BtmPo btmPo : btmList) {
            if (ObjUtil.isNull(btmDao.selectBySn(btmPo.getSn()))) {
                btmPo.setSupplierCode(supplierCode);
                btmDao.insertPo(btmPo);
                recordLog(btmPo, "数据批次[" + batchNum + "]数据导入");
            } else {
                logger.warn("数据批次[{}]蓝牙模块信息[{}]已存在", batchNum, btmPo.getSn());
            }
        }
    }

    /**
     * 记录蓝牙模块信息变更日志
     *
     * @param btmPo  蓝牙模块对象
     * @param remark 变更备注
     */
    private void recordLog(BtmPo btmPo, String remark) {
        btmLogDao.insertPo(BtmLogPo.builder()
                .sn(btmPo.getSn())
                .configWord(btmPo.getConfigWord())
                .hardwareVer(btmPo.getHardwareVer())
                .softwareVer(btmPo.getSoftwareVer())
                .hardwareNo(btmPo.getHardwareNo())
                .softwareNo(btmPo.getSoftwareNo())
                .hsm(btmPo.getHsm())
                .mac(btmPo.getMac())
                .description(remark)
                .build());
    }

}
