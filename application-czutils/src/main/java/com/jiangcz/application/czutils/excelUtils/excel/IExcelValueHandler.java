package com.jiangcz.application.czutils.excelUtils.excel;

public interface IExcelValueHandler<T> {
	
	public String getValue(T obj, ExcelColumn column);

}
