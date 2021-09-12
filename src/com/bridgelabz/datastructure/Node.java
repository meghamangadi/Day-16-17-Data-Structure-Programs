package com.bridgelabz.datastructure;

	public class Node<S>
	{
		public String words;
		public int numbers;
		public Node<String> nextNode;
		public Node<Integer> nextnode;
		
		public Node()
		{
			this.nextNode=null;
			this.nextnode=null;
		}
	
		
		public void setDataForString(String words)
		{
			this.words=words;
			this.nextNode=null;
		}
		public void setDataForInteger(int num)
		{
			this.numbers=num;
			this.nextnode=null;
			
		}
		Node<String> front,rear;
	}

