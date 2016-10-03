package org.yona.design.abstractfactory;

/*�����ó��󹤳�ģʽ����ȡ��ģʽ��˽�з���������ģʽʵ�������������
������һ��Web�йܹ�˾���ù�˾��Windows��UNIXƽ̨���йܷ���
��Web�йܹ�˾��������ƽ̨���ṩ���ֲ�ͬ���͵��йܷ��񣺻�����basic�����߼���advanced���͸��߼���premiere����
�����һ��Ӧ�ã��ṩ��ѯ��Web�йܹ�˾�ṩ�Ĳ�ͬ���͵��йܰ��Ĺ��ܡ�*/

public  interface AbstractServerFactory {
	//�ṩ���ַ���
	public BasicServer createBasicServer();
	public AdvanServer createAdvanServer();
	public PremServer createPremServer();
}
