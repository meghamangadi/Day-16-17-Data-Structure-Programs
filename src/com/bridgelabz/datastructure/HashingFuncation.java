package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class HashingFuncation{

	

	Scanner sc=new Scanner(System.in);
	
	public NodeLinkedList[] createingHashTable()
	{      
		NodeLinkedList[] Hashlist=new NodeLinkedList[11];
		return Hashlist;
	}
		
		public static void main(String [] args)
		{	
			Scanner sc=new Scanner(System.in);
			HashingFuncation hashCall=new HashingFuncation();
			NodeLinkedList[] hashTable = hashCall.createingHashTable();
			int[] textFileValues=HashingFuncation.readIntegerFromFileForHashing();
			int AddSearchElement=0;
			int element;
			int index;
			int SearchElementindex;
			for(int i=0;i<textFileValues.length;i++)
			{				
				element=textFileValues[i];
				index=hashCall.HashingsFuncation(hashTable, element);
				hashTable[index]=HashingFuncation.addHashigElement( hashTable[index],element);
				
			}	
			System.out.println("Please Enter the number");
			AddSearchElement=sc.nextInt();
			SearchElementindex=hashCall.HashingsFuncation(hashTable, AddSearchElement);
			hashTable[SearchElementindex]=HashingFuncation.searchDataInHashingTable(hashTable[SearchElementindex],AddSearchElement);
			HashingFuncation.writeDataToFileHashingFuncation(hashTable[SearchElementindex]);
			
		}
		  public static int[] readIntegerFromFileForHashing()
		    { 
		    	String lineread;
		    	String[] inputStringArray;
		    	int[] inputIntArray = null;
		    	
		    	try {
		    	String intFileInput=new String();
		    	FileReader fileread= new FileReader("C:/Users/Next/eclipse-workspace/Data_Structure_Programs/src/com/bridgelabz/datastructure/hashingTextFile.txt");
		        BufferedReader buffer=new BufferedReader(fileread);

		        while((lineread=buffer.readLine())!=null)
		    	{	
		        	intFileInput+=lineread;   	
		        	
		    	}
		        intFileInput=intFileInput.replaceAll(" ", ",");
		    	intFileInput=intFileInput.trim();
		    	inputStringArray=intFileInput.split(",");
		    	inputIntArray=new int[inputStringArray.length];
		    	
		    	for(int i=0;i<inputIntArray.length;i++)
		    	{
		    		
		    		inputIntArray[i]=Integer.parseInt(inputStringArray[i]);
		    		
		    	}
		    	
		    	buffer.close();
		    	
		    	}catch(IOException e)
		    {
		    		System.out.println(e);
		    }
		    	return inputIntArray ;

		    }
		  public static NodeLinkedList addHashigElement(NodeLinkedList node1,int num)
		    {
		    	NodeLinkedList temp;
		    	
		    	NodeLinkedList newNode=new NodeLinkedList();
		       newNode.data=num;
		       newNode.next=null;
		       
		       if(node1==null)
		       {
		    	   node1 = newNode;
	                                
		    	   return node1;
		       }if(node1.data>newNode.data)
		          {
		    	   newNode.next=node1;
		    	   node1=newNode;
		    	   return node1;
		          }
		       else{
		    	   temp = node1;
		         while(temp.next!=null)
		         {
		        	 if(temp.next.data > newNode.data) 
		        	 {
		        		 newNode.next=temp.next;
		        		 temp.next=newNode;
		        		 break;
		        	 }
		           temp =temp.next;
		         }
		         temp.next=newNode;
		       }
		       return node1;
		    }
		   
		    public static  NodeLinkedList searchDataInHashingTable(NodeLinkedList node,int seachingElement)
		    {
		    	NodeLinkedList  temp=node;
		    	 if(temp.next==null) 
		    	 {
			    	 if(seachingElement==(temp.data))
			         {	
			                node=node.next;      
			                System.out.println("number is Found");
			            
			                return temp;		        	 
			         }
		    	 }
		         while(temp.next!=null){
		           if(seachingElement==(temp.next).data)
		           {
		        	   temp.next=(temp.next).next;
		        	   System.out.println("number is Found");
		            
		        	   return temp;
		           }
		           		temp=temp.next ;
		         }
		         
		         System.out.println("number is not Found");
		       
		         temp=addHashigElement(temp,seachingElement);
		         return temp;
		    }
		    
			public static void writeDataToFileHashingFuncation(NodeLinkedList tNode )
			{
				try
				{   
					String tString2="";
				    File file2=new File("C:/Users/Next/eclipse-workspace/Data_Structure_Programs/src/com/bridgelabz/datastructure/hashingTextFile.txt"
				    		);
				    file2.createNewFile();
				    FileWriter fw=new FileWriter(file2);

				    while(tNode!=null)
					{
				      	tString2+=String.valueOf(tNode.data);
				      	tString2+=" ";
				      	tNode=tNode.next;
				    }
				   
				    fw.write(tString2);
				    fw.close();
				}
				catch(IOException e)
				{
				System.out.println(e);
				}
			}

		
	    public void searchElemetFromHashTable(NodeLinkedList[] HashElement,int number)
	    {
	    	
	    }
	   
	    public void addingElementIntoHashinTable(NodeLinkedList[] hashElement,int number)
	    {
	    	
	    }
	    
	    public int HashingsFuncation(NodeLinkedList[] hashTable,int number )
	    {      
	    	return (number%hashTable.length);
	    }
	    
	   

	
}
