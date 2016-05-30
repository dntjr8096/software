package model;

import model.Observer;

public interface Observerable {

    public void addObserver(Observer o);             // ������ ���
    public void deleteObserver(Observer o);          // ������ ����
    public void notifyObservers();                         // �������� ������ ����
}
