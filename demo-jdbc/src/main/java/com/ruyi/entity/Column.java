/**
 * 
 */
package com.ruyi.entity;

/**
 * @author ruyi 
 * @date 2020年7月9日 下午7:13:32
 *
 */
public class Column {

	private String columnName;
	
	private String columnType;
	
	private String columnValue;
	
	private String note;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	
}
