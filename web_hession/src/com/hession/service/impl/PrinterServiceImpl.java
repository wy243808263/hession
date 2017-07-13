package com.hession.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hession.service.IPrinter;

public class PrinterServiceImpl implements IPrinter {

	@Override
	public String printstr(String image) {
		// dataType为50， dataValue是base64编码后的图像数据，
		Map<String, Object> params = new HashMap<String, Object>();
		if (!image.isEmpty()) {
			// 传输格式
			JSONObject jsonObject = JSONObject.parseObject(image);
			String inputs = jsonObject.getString("inputs");
			System.out.println(inputs);

			JSONArray jsonArray = jsonObject.getJSONArray("image");
			// 表示image的数据类型为字符串
			String dataType = jsonArray.getString(0);
			// 图片以base64编码的string
			String dataValue = jsonArray.getString(1);

			// 响应格式
			params.clear();

			JSONArray array = new JSONArray();

			params.put("outputLabel", "ocr_bankcard");
			params.put("outputMulti", "{}");

			JSONObject object = new JSONObject();
			object.put("dataType", 50);
			object.put("dataValue", "{\"card_num\":\"1234567890123456\",\"request_id\":\"20170301160849_918cfcae128fc919ad6d6e3b865d2973\",\"success\":\"true\"}");

			params.put("outputValue", object);
			params.put("outputs", array);
		} else {
			params.put("success", false);
			params.put("erro_code", "传输字符串为空");
		}

		return JSONObject.toJSONString(params);
	}
}