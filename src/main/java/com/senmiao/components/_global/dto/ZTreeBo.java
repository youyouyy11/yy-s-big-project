package com.senmiao.components._global.dto;

import com.telecom.data.common.dto.BaseBo;
import com.telecom.data.jpa.domain.model.TreeModel;
import com.telecom.data.jpa.domain.model.TreeNode;

public abstract class ZTreeBo<T extends TreeModel> extends BaseBo<T> {

	private String name;

	private String parentId;

	private String idPath;

	private Boolean leaf;

	private boolean open = true;

	private boolean isParent = true;

	private Integer subNodesCount;

	public void init(T model) {
		TreeNode node = model.getNode();
		if (node != null) {
			this.name = node.getName();
			this.isParent = node.getLeaf() != null && node.getLeaf() ? false : true;
			this.idPath = node.getIdPath();
			this.parentId = node.getParentId();
			this.leaf = node.getLeaf();
			this.subNodesCount = node.getSubNodesCount();
		}
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getIdPath() {
		return idPath;
	}

	public void setIdPath(String idPath) {
		this.idPath = idPath;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	/**
	 * @return the subNodesCount
	 */
	public Integer getSubNodesCount() {
		return subNodesCount;
	}

	/**
	 * @param subNodesCount
	 *            the subNodesCount to set
	 */
	public void setSubNodesCount(Integer subNodesCount) {
		this.subNodesCount = subNodesCount;
	}
}
