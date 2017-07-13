package com.hession.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hession.service.IPrinter;

public class PrinterServiceImpl implements IPrinter {

	@Override
	public String printstr(String image) {
		// dataTypeΪ50�� dataValue��base64������ͼ�����ݣ�
		Map<String, Object> params = new HashMap<String, Object>();
		if (!image.isEmpty()) {
			// �����ʽ
			JSONObject jsonObject = JSONObject.parseObject(image);
			String inputs = jsonObject.getString("inputs");
			System.out.println(inputs);

			JSONArray jsonArray = jsonObject.getJSONArray("image");
			// ��ʾimage����������Ϊ�ַ���
			String dataType = jsonArray.getString(0);
			// ͼƬ��base64�����string
			String dataValue = jsonArray.getString(1);

			// ��Ӧ��ʽ
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
			params.put("erro_code", "�����ַ���Ϊ��");
		}

		return JSONObject.toJSONString(params);
	}
}