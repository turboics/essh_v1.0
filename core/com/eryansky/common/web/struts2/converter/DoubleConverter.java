/**
 *  Copyright (c) 2012-2014 http://www.eryansky.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.eryansky.common.web.struts2.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * 浮点数转换.
 * 
 * @author 尔演&Eryan eryanwcp@gmail.com
 * @date 2013-4-5 上午12:44:08
 * 
 */
public class DoubleConverter extends StrutsTypeConverter {
	// 使用千分号格式
	private DecimalFormat decimalFormat = new DecimalFormat(
			"###,###,###,###,##0.00");

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values != null && values.length > 0) {
			if (values[0].indexOf(',') != -1) {
				return Double.parseDouble(StringUtils.replace(values[0], ",",
						""));
			} else {
				return Double.parseDouble(values[0]);
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		if (o != null) {
			return decimalFormat.format(o);
		}
		return null;
	}

}
