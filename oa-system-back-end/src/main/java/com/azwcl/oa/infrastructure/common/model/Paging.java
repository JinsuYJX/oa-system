package com.azwcl.oa.infrastructure.common.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.Collections;

/**
 * 分页
 *
 * @author az
 * @date 2022/10/06
 */

@Getter
@ToString
public class Paging<T> {
    /**
     * 页大小
     */
    private final Integer pageSize;

    /**
     * 页码
     */
    private final Integer pageNumber;

    /**
     * 记录总数
     */
    private final Integer total;

    /**
     * 记录数
     */
    private final Collection<T> records;


    public Paging(BaseQuery query, Integer total, Collection<T> records) {
        this.pageSize = query.getPageSize();
        this.pageNumber = query.getPageNumber();
        this.total = total;
        this.records = records;
    }

    public Paging(BaseQuery query) {
        this.pageSize = query.getPageSize();
        this.pageNumber = query.getPageNumber();
        this.total = 0;
        this.records = Collections.emptyList();
    }
}
