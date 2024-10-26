#include <iostream>
using namespace std;

// 노드 구조체 정의
struct Node {
    int data;
    Node* next;
};

class LinkedList {
private:
    Node* head;

public:
    LinkedList() : head(nullptr) {}

    // 리스트의 맨 뒤에 새로운 노드 추가
    void append(int data) {
        Node* newNode = new Node{data, nullptr};
        if (!head) {
            head = newNode;
        } else {
            Node* temp = head;
            while (temp->next) {
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }

    // 리스트 출력
    void display() const {
        Node* temp = head;
        while (temp) {
            cout << temp->data << " -> ";
            temp = temp->next;
        }

        cout << "NULL" << endl;
    }

    // 메모리 해제
    // 소멸자: 객체가 소멸될 때 호출되는 함수
    ~LinkedList() {
        Node* temp;
        while (head) {
            temp = head;
            head = head->next;
            delete temp;
        }
    }
};

int main() {
    LinkedList list;
    list.append(10);
    list.append(20);
    list.append(30);
    list.display();

    return 0;
}