package com.bridgelabz.datastructure;

public class BankQueue {

	int num = 5;
	int[] Queue = new int[num];
	int front = -1;
	int rear = -1;

	public void enque(int add) {
		if (front == -1 && rear == -1) {
			front = rear = 0;
			Queue[rear] = add;
		} else if ((rear + 1) % num == front) {
			System.out.println("Queue is full");
		} else {
			this.rear = ((rear + 1) % num);
			this.Queue[rear] = add;

		}
	}

	public void deque() {
		if (front == -1 && rear == -1) {
			System.out.println("Queue is empty");
		} else if (front == rear) {
			System.out.println("dequeed element is " + Queue[front]);
			front = rear = -1;
		} else {
			System.out.println("dequeed element is " + Queue[front]);
			front = (front + 1) % num;

		}
	}

	public void display() {
		int i = front;
		if (front == -1 && rear == -1) {
			System.out.println("Queue is empty");
		}
		while (i != rear) {
			System.out.print(Queue[i] + " ");
			i = (i + 1) % num;
		}
		System.out.print(Queue[rear] + " \n");
	}

}
