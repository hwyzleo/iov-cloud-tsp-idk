package net.hwyz.iov.cloud.tsp.idk.service.facade.assembler;

import net.hwyz.iov.cloud.tsp.idk.api.contract.BtmExService;
import net.hwyz.iov.cloud.tsp.idk.service.infrastructure.repository.po.BtmPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 对外服务蓝牙模块信息转换类
 *
 * @author hwyz_leo
 */
@Mapper
public interface BtmExServiceAssembler {

    BtmExServiceAssembler INSTANCE = Mappers.getMapper(BtmExServiceAssembler.class);

    /**
     * 数据传输对象转数据对象
     *
     * @param btmExService 数据传输对象
     * @return 数据对象
     */
    @Mappings({})
    BtmPo toPo(BtmExService btmExService);

    /**
     * 数据对象列表转数据传输对象列表
     *
     * @param btmExServiceList 数据传输对象列表
     * @return 数据对象列表
     */
    List<BtmPo> toPoList(List<BtmExService> btmExServiceList);

}
