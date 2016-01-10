package queueStack;

import java.io.*;
import java.util.*;

public class WhosNext {

	public static void main(String[] args) throws IOException {
		
		//queue init
		LinkedListQueue q = new LinkedListQueue();
		
		//scanner init
		Scanner sf = new Scanner(new File("H:\\ComSci\\text\\FileName.txt"));
		
		//fill q
		while(sf.hasNext()) {
			
			q.enqueue(sf.nextLine());
			
		}
		
		//close scanner
		sf.close();
		
		//initialize some Variables
		int totalWaitTime = 0;
		Scanner sc = new Scanner((String)q.getFirst());
		int firstCustArrivalTime = sc.nextInt();
		int nextAvailTimeA = firstCustArrivalTime;
		int nextAvailTimeB = firstCustArrivalTime;
		sc.close();
		
		//dequeue each customer and calc his wait time
		while(q.isEmpty()==false) {
			
			//get customer data
			sc = new Scanner((String)q.dequeue());
			int custArrivalTime = sc.nextInt();
			int custHelpTime = sc.nextInt();
			
			//get time the customer's help begins
			int dequeueTime = 0;
			
			//if A can take
			if(nextAvailTimeA<nextAvailTimeB) {
				
				//check if customer has to wait
				if(nextAvailTimeA>custArrivalTime) {
					//set dequeue
					dequeueTime = nextAvailTimeA;
					//set next available time
					nextAvailTimeA = nextAvailTimeA + custHelpTime;
				
				//if customer does not have to wait
				} else {
					//set dequeue time
					dequeueTime = custArrivalTime;
					//set next available time
					nextAvailTimeA = custArrivalTime + custHelpTime;
					
				}
				
				//B takes
			} else {
				
				//same as a but with b
				if(nextAvailTimeB>custArrivalTime) {
					
					dequeueTime = nextAvailTimeB;
					nextAvailTimeB = nextAvailTimeB + custHelpTime;
					
				} else {
					
					dequeueTime = custArrivalTime;
					nextAvailTimeB = custArrivalTime + custHelpTime;
					
				}
				
				
			}
			
			//calculate total wait time
			int thisWaitTime = dequeueTime-custArrivalTime;
			totalWaitTime = totalWaitTime+thisWaitTime;
			
			
		}
		
		//print
		System.out.println(totalWaitTime);

	}

}
