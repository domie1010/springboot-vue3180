package com.dao;

import com.entity.XizhurenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XizhurenView;

/**
 * 系主任 Dao 接口
 *
 * @author 
 */
public interface XizhurenDao extends BaseMapper<XizhurenEntity> {

   List<XizhurenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
