import javafx.util.Pair;

import java.util.ArrayList;


public class Schedule {
    public static boolean canSend(Pair<Employer,Employer> pairRelation, ArrayList<Pair<Employer,Employer>> workingPair){
        if(workingPair.contains(pairRelation)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean insertNewPair(Pair<Employer,Employer> newPair, ArrayList<Pair<Employer,Employer>> workingPair){
        if(workingPair.contains(newPair)){
            return false;
        }else{
            workingPair.add(newPair);
            return true;
        }
    }
    public static void main(String args[]){
        ArrayList<Pair<Employer,Employer>> pairs = new ArrayList<Pair<Employer, Employer>>();
        //Assume these are the employers in a company
        Employer A = new Employer("A", 1);
        Employer B = new Employer("B", 2);
        Employer C = new Employer("C", 3);
        Employer D = new Employer("D", 4);
        Employer E = new Employer("E", 5);
        Employer F = new Employer("F", 6);
        //Assume these pairs are the schedules. The first element is the developer and the second element is the reviewer
        pairs.add(new Pair<>(A,F));
        pairs.add(new Pair<>(B,A));
        pairs.add(new Pair<>(E,C));
        pairs.add(new Pair<>(D,B));
        //Test if a reviewer can send to a developer. Supposed to print "Unsuccessfully send to reviewer"
        if(canSend(new Pair<>(F,A),pairs)){
            System.out.println("Successfully send to reviewer");
        }else{
            System.out.println("Unsuccessfully send to reviewer");
        }
        //Test if a developer can send to a reviewer. Supposed to print "Successfully send to reviewer"
        if(canSend(new Pair<>(A,F),pairs)){
            System.out.println("Successfully send to reviewer");
        }else{
            System.out.println("Unsuccessfully send to reviewer");
        }
        //Test if a new assignment is assigned. Supposed to print "This working pair already exists. Please assign a new task"
        if(insertNewPair(new Pair<>(B,A),pairs)){
            System.out.println("A new assignment has been assigned to a pair");
        }else{
            System.out.println("This working pair already exists. Please assign a new task");
        }
        //Now B needs a new assignment. Supposed to print "A new assignment has been assigned to a pair"
        if(insertNewPair(new Pair<>(B,C),pairs)){
            System.out.println("A new assignment has been assigned to a pair");
        }else{
            System.out.println("This working pair already exists. Please assign a new task");
        }

    }
}
