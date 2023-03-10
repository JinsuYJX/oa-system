package com.azwcl.oa.infrastructure.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 基础查询类
 *
 * @author az
 * @date 2022/10/06
 */

@Getter
@Setter
@ToString
public class BaseQuery {
    /**
     * 页码
     */
    Long pageNumber = 1L;

    /**
     * 页大小
     */
    Long pageSize = 50L;

    /**
     * 查询词
     */
    String searchKey;
}
