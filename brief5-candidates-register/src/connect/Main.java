package connect;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {

	

public static void main( String args[] ) throws ClassNotFoundException {
		
	char operationType;
	Scanner reader = new Scanner(System.in);
	System.out.println("****** SoussTalents101 Candidates ******");
    CandidateDao candidateDaoImpl =  new CandidateDaoImpl();
	int candidateId = 0;

//	System.out.println(candidateDaoImpl.getAllCandidates().size());
//	System.out.println(candidateDaoImpl.getAllCandidates());

	do {
		System.out.println("\n\nChoose You Operation:");
		
		System.out.println("1-Create Candidate.\n2-View Candidate.\n3-Edit Candidate. \n4-Delete Candidate \n0-Exit.");
		System.out.print("Enter type of the operation: ");
		operationType = reader.next().charAt(0);

		if (operationType == '0') {
			System.out.println("Exit!");
			reader.close();
			break;
		} else if (operationType == '1') {
			//ask for info
		    Candidate candidate = new Candidate("latifa4@anmoon.ma", "lattifa", "amougauay", "123 Main Street, New York, NY 10030", "Tizinit", "Morocco");
			if(candidateDaoImpl.insertCandidate(candidate)) {
				System.out.println("Candidate Created SuccessFuly!");
			}

		} else if (operationType == '2') {
			
			do{
				System.out.println("Enter Candidate Id: ");
			    candidateId = reader.nextInt();
				System.out.println("Candidate Doesnt Exist!");
				if(candidateDaoImpl.getCandiate(candidateId)) {
					System.out.println("Candidate Found SuccessFuly!");
				    System.out.println(candidateDaoImpl.getCandiate(candidateId));
				}
			}
			while(!candidateDaoImpl.getCandiate(candidateId));
 
		}
		else if (operationType == '3') {
			
			do{
				System.out.println("Enter Candidate Id: ");
			    candidateId = reader.nextInt();
				//ask for info;
				System.out.println("Candidate Doesnt Exist!");
				if(candidateDaoImpl.getCandiate(candidateId)) {
				    Candidate updatedCandidate1 = new Candidate("oooh@anmon.ma", "latifa", "amougauay", "123 Main Street, New York, NY 10030", "Tizinit", "Morocco");
				    System.out.println(candidateDaoImpl.updateCandidate(candidateId, updatedCandidate1));
				    
					System.out.println("Candidate Updated SuccessFuly!");
				    System.out.println(candidateDaoImpl.getCandiate(candidateId));
				}
			}
			while(!candidateDaoImpl.getCandiate(candidateId));

		}
		else if (operationType == '4') {			
				
			do{
				System.out.println("Enter Candidate Id: ");
			    candidateId = reader.nextInt();
				System.out.println("Candidate Doesnt Exist!");
				if(candidateDaoImpl.deleteCandidate(candidateId)) {
					System.out.println("Candidate Deleted SuccessFuly!");
				}
			}
			while(!candidateDaoImpl.deleteCandidate(candidateId));

		}else {
			System.out.println("Error opertaion doesnt exist!");
			continue;
		}
	} while (true);
	reader.close();

}

}
