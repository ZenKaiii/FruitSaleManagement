package com.zenkaiii.service;

import com.zenkaiii.entity.Fruit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zenkaiii.vo.BarVO;
import com.zenkaiii.vo.PieVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-06-18
 */
public interface IFruitService extends IService<Fruit> {
    public BarVO barVOList();
    public List<PieVO> pieVOList();
}
