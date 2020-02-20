package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;


@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	//分类表的mapper文件注入进来
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId){
		//根据父节点id查询子节点列表
		TbItemCatExample example =  new TbItemCatExample();
		
		//设置查询条件
		Criteria criteria = example.createCriteria();
		//设置parentId
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		//将TBItemCat集合转换成EasyUITreeNode集合
		List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<>();
		for(TbItemCat itemCat:list)
		{
			EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
			easyUITreeNode.setId(itemCat.getId());
			easyUITreeNode.setText(itemCat.getName());
			easyUITreeNode.setState(itemCat.getIsParent()?"closed":"open");
			easyUITreeNodeList.add(easyUITreeNode);
		}
		return easyUITreeNodeList;
		
		
	}
}
