package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiayoudengjiDao;
import com.entity.JiayoudengjiEntity;
import com.service.JiayoudengjiService;
import com.entity.vo.JiayoudengjiVO;
import com.entity.view.JiayoudengjiView;

@Service("jiayoudengjiService")
public class JiayoudengjiServiceImpl extends ServiceImpl<JiayoudengjiDao, JiayoudengjiEntity> implements JiayoudengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiayoudengjiEntity> page = this.selectPage(
                new Query<JiayoudengjiEntity>(params).getPage(),
                new EntityWrapper<JiayoudengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiayoudengjiEntity> wrapper) {
		  Page<JiayoudengjiView> page =new Query<JiayoudengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiayoudengjiVO> selectListVO(Wrapper<JiayoudengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiayoudengjiVO selectVO(Wrapper<JiayoudengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiayoudengjiView> selectListView(Wrapper<JiayoudengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiayoudengjiView selectView(Wrapper<JiayoudengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
