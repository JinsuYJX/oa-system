package com.azwcl.oa.domain.user.repo;

import java.util.Collection;
import java.util.Collections;

/**
 * 基础 repo; 所有 repo 必须集成自此
 *
 * @author az
 * @date 2022/09/18
 */

public interface BaseRepo<T> {

    /**
     * 批处理数据大小
     */
    Integer DEFAULT_BATCH_SIZE = 500;


    /**
     * 保存一条数据
     *
     * @param t T
     */
    default void save(T t) {

    }

    /**
     * 保存所有数据
     *
     * @param list 待保存集合
     */
    default void saveAll(Collection<T> list) {

    }

    /**
     * 通过 id 删除数据
     *
     * @param id 删除序号
     */
    default void deleteById(Number id) {

    }

    /**
     * 通过 id 集合删除一批数据
     *
     * @param ids 序号集合
     */
    default void deleteByIds(Collection<Number> ids) {

    }

    /**
     * 通过 id 修改某条数据
     *
     * @param t 待修改数据
     */
    default void updateById(T t) {

    }

    /**
     * 通过 id 集合修改一批数据
     *
     * @param list 待修改数据集合
     */
    default void updateByIds(Collection<T> list) {

    }

    /**
     * 通过 id 查询
     *
     * @param id 待查询id
     * @return 结果
     */
    default T findById(Number id) {
        return null;
    }

    /**
     * 通过 id 集合查询
     *
     * @param ids 待查询id集合
     * @return 结果集
     */
    default Collection<T> findByIds(Collection<Number> ids) {
        return Collections.emptyList();
    }
}
