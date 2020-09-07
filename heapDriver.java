package priortiyqueue;

import java.util.Random;

public class heapDriver {
	
	public static void main(String[] args) {
    int chance = 0, customersServiced = 0, maxLineSize = 0; 
    
    PriorityQueue heap = new PriorityQueue();
    
  
   // The loop loops 60 times to simulate the 60 minutes in the store.
    for(int i = 0; i <= 59; i++)
    {
        Random randNum = new Random();
        chance = randNum.nextInt(4) + 1; // generates random number to create 25% chance there is a new customer
        // add a new customer to line if variable addCust got a value 1 from range 1-4
        if(chance == 1)
        {
            PriorityCustomer c = new PriorityCustomer();
            heap.addCustomer(c);
            System.out.println("New customer added! Queue length is now " + heap.getSize() );
        }
      
        // update the maximum number of customer in line
        if(maxLineSize == 0)
        {
            maxLineSize = heap.getSize();
        }
        else if(maxLineSize < heap.getSize()){                                                  
            maxLineSize = heap.getSize();
        }

        PriorityCustomer first = heap.getFirst(); // The first customer in the queue is the customer currently being serviced.
      
        // If the queue is empty, a message is displayed to the user.
        if(first == null){
            System.out.println("The queue is empty");
        }
        
        else if(first.getServiceTime() > 0){
            first.decServiceTime();
        }
        else{ // If the serviceTime is 0, the customer has been fully serviced and is removed from queue. The next customer's service time starts getting decremented in the next iteration
             
            heap.removeCustomer();
            System.out.println("Customer serviced and removed from the queue. Queue length is now " + heap.getSize() + ".");
            customersServiced++; // Number of customers serviced is incremented.
        }
        System.out.println("---------------------------------------------------");
    }
   //output total number of customer serviced and maximum customers in line during simulation
    System.out.println("Total number of customers serviced: " + customersServiced);
    System.out.println("Maximum line length: " + maxLineSize);
	}
}