package com.session.client;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hession.service.IPrinter;

public class TestClient {

	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {

		String url = "http://127.0.0.1:8080/hessianDemo/service";
		// 创建factory实例

		HessianProxyFactory factory = new HessianProxyFactory();

		factory.setOverloadEnabled(true); // 启用方法重载识别

		// 客户端需实现Basic接口

		IPrinter printer = (IPrinter) factory.create(IPrinter.class, url);

		// System.out.println("Hessian: " + printer.printstr());
		System.out.println("Hessian: " + printer.printstr("Hurry"));
	}
}