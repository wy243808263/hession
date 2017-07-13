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
		// ����factoryʵ��

		HessianProxyFactory factory = new HessianProxyFactory();

		factory.setOverloadEnabled(true); // ���÷�������ʶ��

		// �ͻ�����ʵ��Basic�ӿ�

		IPrinter printer = (IPrinter) factory.create(IPrinter.class, url);

		// System.out.println("Hessian: " + printer.printstr());
		System.out.println("Hessian: " + printer.printstr("Hurry"));
	}
}