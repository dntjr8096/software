package model;

public class Book{
	public String Title = "";	//����
	public String Link = "";	//å �Ǹ� ��ũ -> �˶������ �̵�	
	public String Author = "";	//����
	public String Cover = "";	//åǥ�� �̹��� �ּ�
	public String ISBN = "";	//å ������ȣ ISBN
	public String price = "";	//å ����
	private int page = 0;		//���ݱ��� ���� ������ ��
	
	public void setPage(int page){	//���� .������ ����
		this.page = page;
	}
}