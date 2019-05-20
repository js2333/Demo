package com.dt78.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Demo1 {
	public static void main(String[] args) {
		//1.������ȫ����������
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		
		//2.������ȫ������
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		
		//3.��ʼ��SecurityUtils������
		SecurityUtils.setSecurityManager(securityManager);
		
		//4.��SecurityUtils�����л�ȡSubject
		Subject subject = SecurityUtils.getSubject();
		
		//5.��֤��������¼��
		//AuthenticationToken: ���ڷ�װ�û�������˻���Ϣ
		AuthenticationToken token = new UsernamePasswordToken("jack", "123");
		
		try {
			subject.login(token);
			
			//��ȡSimpleAuthenticationInfo�ĵ�һ��������principal
			Object principal = subject.getPrincipal();
			
			//���login����û���κ��쳣��������֤�ɹ�
			System.out.println("��¼�ɹ���"+principal);
		} catch (UnknownAccountException e) {
			//�˻�������
			System.out.println("�˻�������");
		}  catch (IncorrectCredentialsException e) {
			//�������
			System.out.println("�������");
		} catch (Exception e) {
			//ϵͳ����
			System.out.println("ϵͳ����");
		} 
		
	}
}
