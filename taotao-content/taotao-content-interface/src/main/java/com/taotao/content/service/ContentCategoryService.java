package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {
	//获取 分类列表
	List<EasyUITreeNode> getContentCategoryList(long parentId);
	// 后台操作添加分类内容
	TaotaoResult addContentCategory(long parentId,String name);
	
}
