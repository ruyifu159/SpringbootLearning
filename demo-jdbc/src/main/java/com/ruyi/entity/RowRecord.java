/**
 * 
 */
package com.ruyi.entity;

import java.util.List;

/**
 * @author ruyi 
 * @date 2020年7月9日 下午7:16:22
 *
 */
public class RowRecord {
	private Table table;
	
	private List<Column> columns;

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
	
}
