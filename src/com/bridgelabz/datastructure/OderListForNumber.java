package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OderListForNumber {

	Node<Integer> start;
	Scanner sc = new Scanner(System.in);

	public void readNumbersFromFile() {
		int[] collectNumber = OderListForNumber.readIntegerFromFileUnSortedElement();
		int length = collectNumber.length;
		OderListForNumber.sort(collectNumber, 0, length - 1);
		System.out.println("Array size is" + length);
		for (int i = 0; i < length; i++) {
			addItem(collectNumber[i]);

		}
	}

	public static void sort(int arr[], int l, int r) {
		if (l < r) {

			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	public static int[] merge(int arr[], int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return arr;
	}

	public static int[] readIntegerFromFileUnSortedElement() {
		String lineread;
		String[] inputStringArray;
		int[] inputIntArray = null;

		try {
			String intFileInput = new String();
			FileReader fileread = new FileReader(
					"C:/Users/Next/eclipse-workspace/Data_Structure_Programs/src/com/bridgelabz/datastructure/OrderList.txt");
			BufferedReader buffer = new BufferedReader(fileread);

			while ((lineread = buffer.readLine()) != null) {
				intFileInput += lineread;

			}
			intFileInput = intFileInput.replaceAll(" ", ",");
			intFileInput = intFileInput.trim();
			inputStringArray = intFileInput.split(",");
			inputIntArray = new int[inputStringArray.length];

			for (int i = 0; i < inputIntArray.length; i++) {

				inputIntArray[i] = Integer.parseInt(inputStringArray[i]);

			}

			buffer.close();

		} catch (IOException e) {
			System.out.println(e);
		}
		return inputIntArray;

	}

	public void List() {
		if (start == null) {
			System.out.println("List is not contain any numbers");
		}
	}

	public void addItem(int data) {
		Node<Integer> head = start;
		Node<Integer> temp = new Node<Integer>();
		temp.numbers = data;
		temp.nextnode = null;
		if (start == null) {
			start = temp;
		} else {
			while (head.nextnode != null) {
				head = head.nextnode;
			}
			head.nextnode = temp;
		}
	}

	public void display() {
		Node<Integer> temp = start;
		while (temp != null) {
			System.out.print(temp.numbers + " ");
			temp = temp.nextnode;
		}
		System.out.println(" ");
	}

	public int size() {
		int count = 1;
		Node<Integer> temp = start;
		while (temp.nextnode != null) {
			temp = temp.nextnode;
			count++;
		}
		int a = count;
		System.out.println("size of Linked List " + a);
		return count;
	}

	public void searchData() {
		Node<Integer> temp = start;
		int count = 0;
		System.out.println("Enter a number to Search");
		int s = sc.nextInt();
		int flag = 0;
		while (temp.nextnode != null) {
			count++;
			if (temp.numbers == s) {
				System.out.println(" number is found At " + count);
				flag++;
				break;
			}
			temp = temp.nextnode;
		}

		if (flag == 1) {
			removeData(count);
		} else {
			addItem(s);
			System.out.println("After Adding a List ");
			display();
			OderListForNumber.writeDataToFileForIntegerValue(start);
		}
	}

	public static void writeDataToFileForIntegerValue(Node<Integer> tNode) {
		try {
			String tString2 = "";
			File file2 = new File(
					"C:/Users/Next/eclipse-workspace/Data_Structure_Programs/src/com/bridgelabz/datastructure/OrderList.txt");
			file2.createNewFile();
			FileWriter fw = new FileWriter(file2);

			while (tNode != null) {
				tString2 += String.valueOf(tNode.numbers);
				tString2 += " ";
				tNode = tNode.nextnode;
			}

			fw.write(tString2);
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	void removeData(int count) {
		Node<Integer> temp = start;
		if (count == 1) {
			start = start.nextnode;
			System.out.println("After Deleting List is ");
			display();
		} else {
			for (int i = 1; i < count - 1; i++) {
				temp = temp.nextnode;

			}

			temp.nextnode = temp.nextnode.nextnode;

			System.out.println("After Deleting List is ");
			display();
			OderListForNumber.writeDataToFileForIntegerValue(start);
		}
	}

	public static void main(String[] args) {

		OderListForNumber orderlist = new OderListForNumber();
		orderlist.readNumbersFromFile();
		orderlist.size();
		orderlist.display();
		orderlist.searchData();

	}

}
