import java.util.PriorityQueue;

public class Queue {
	/*
	#######################################################
	#### Hardcoded for now, need to implement Database ####
	#######################################################
	*/
	public static void main(String[] args) {
		
		
		//Int Phone number out of name, changed to String 
		//should change int zip to string zip maybe (not out of java integer parameter) ? check that out later
		//Maybe change everything to String but leave Int Priority due to that being organizer 
		
		Patient Brian = new Patient(1, "Brian", "Auburn Ave", "Atlanta", "30303", "229-529-6860", "Broken Arm", 3);
		Patient Rose = new Patient(2, "Rose", "Bourbon Street", "New Orleans", "30303", "229-529-6861", "Headache", 6);
		Patient Mack = new Patient(3, "Mack", "Wall Street", "New York City", "30303", "229-529-6862", "Rabies", 2);
		Patient Zack = new Patient(4, "Zack", "Hollywood Boulevard", "Los Angeles", "30303", "229-529-6863", "Minor Cut", 5);
		Patient Aleya = new Patient(5, "Aleya", "Broadway", "New York", "30303", "229-529-6863", "Nose Bleed", 4);
		Patient Zoya = new Patient(6, "Zoya", "Lombard Street", "San Francisco", "30303", "229-529-6863", "Zombie", 1);
		
		/*public Patient(int i, String n, String sN, String c, String z, String p, String inj, int prior){
		//simplified 
		id = i;
		Name = n;
		StreetName = sN;
		City = c;
		Zip = z;
		Phone = p;
		Injury = inj;
		Priority = prior;
	*/
		PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();
		
		//adds patients and their info (HardCoded) 
		pQueue.add(Brian);
		pQueue.add(Rose);
		pQueue.add(Mack);
		pQueue.add(Zack);
		
		int count = 1;
		
		while(pQueue.isEmpty()){
			System.out.println("Priority " + count + " = " + pQueue.remove());
			count++; 
		}
		System.out.println();
	}
	/* Not printing out toString method from Patients class, figure that out */

}
