package net.hwyz.iov.cloud.tsp.idk.api.contract.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.hwyz.iov.cloud.tsp.idk.api.contract.BtmExService;

import java.util.List;

/**
 * 批量导入蓝牙模块信息请求
 *
 * @author hwyz_leo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchImportBtmRequest {

    /**
     * 蓝牙模块列表
     */
    @NotEmpty(message = "蓝牙模块列表不能为空")
    private List<BtmExService> btmList;

    /**
     * 供应商编码
     */
    private String supplierCode;

    /**
     * 批次号
     */
    private String batchNum;

}
