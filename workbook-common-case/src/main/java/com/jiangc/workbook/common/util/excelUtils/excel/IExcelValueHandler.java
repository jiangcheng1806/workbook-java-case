package com.jiangc.workbook.common.util.excelUtils.excel;

public interface IExcelValueHandler<T> {
	
	public String getValue(T obj, ExcelColumn column);

}
