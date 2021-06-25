package com.zenkaiii.service.impl;

import com.zenkaiii.entity.Fruit;
import com.zenkaiii.mapper.FruitMapper;
import com.zenkaiii.service.IFruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zenkaiii.util.DataUtil;
import com.zenkaiii.vo.BarVO;
import com.zenkaiii.vo.DataVO;
import com.zenkaiii.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-06-18
 */
@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements IFruitService {

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public BarVO barVOList() {
        BarVO barVO = new BarVO();
        List<String> names = new ArrayList<>();
        List<DataVO> values = new ArrayList<>();
        List<Fruit> fruits = this.fruitMapper.selectList(null);
        for (Fruit fruit : fruits){
            names.add(fruit.getName());
            DataVO dataVO = new DataVO();
            dataVO.setValue(fruit.getSale());
//            Map<String,String> map = new HashMap<>();
//            map.put("color","000000");
            dataVO.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            values.add(dataVO);
        }
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;
    }

    @Override
    public List<PieVO> pieVOList() {
        List<PieVO> pieVOList = new ArrayList<>();
        List<Fruit> fruits = this.fruitMapper.selectList(null);
        for (Fruit fruit : fruits) {
            PieVO pieVO = new PieVO();
            pieVO.setValue(fruit.getSale());
            pieVO.setName(fruit.getName());
            pieVO.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            pieVOList.add(pieVO);
        }
        return pieVOList;
    }

}
