
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Person voter1 = new Person("firstname1", "lastname1");
        Person voter2 = new Person("firstname2", "lastname2");
        Person voter3 = new Person("firstname3", "lastname3");
        Person voter4 = new Person("firstname4", "lastname4");
        Person voter5 = new Person("firstname5", "lastname5");
        // creacting the first voting system
        VotingSystem votingSystem1 = new VotingSystem();
        // creacting the first voting system
            //will have as question : "first Question of poll 1 " (and will be able to chose more than one choice
            //and as choices:
            //"choice 1"
            //"choice 2"
            //"choice 3"

        ArrayList<String> choices1=new ArrayList<String>();
        choices1.add("choice 1");
        choices1.add("choice 2");
        choices1.add("choice 3");

        votingSystem1.createVoting("first Question of poll 1", 0, choices1);
        votingSystem1.vote(0, voter1, new ArrayList<String>() {
            {
                add("random choice");
            }
        });
        votingSystem1.vote(0, voter2, new ArrayList<String>() {
            {
                add("choice 2");
            };
        });
        votingSystem1.vote(0, voter3, new ArrayList<String>() {
            {
                add("choice 3");
            };
        });
        System.out.println("using the getResult method");
        votingSystem1.getResult(0);
        System.out.println();
        System.out.println("using the getVote method");
        votingSystem1.getVoting(0);

        System.out.println("\n\n\n");


        ArrayList<String> choices2=new ArrayList<String>();
        choices2.add("option 1");
        choices2.add("option 2");
        choices2.add("option 3");
        choices2.add("option 4");

        votingSystem1.createVoting("second Question of poll 1", 1, choices2);
        votingSystem1.vote(1, voter1, new ArrayList<String>() {
            {
                add("option 1");
                add("option 1");
            }
        });
        votingSystem1.vote(1, voter2, new ArrayList<String>() {
            {
                add("option 1");
            }
        });
        votingSystem1.vote(1, voter3, new ArrayList<String>() {
            {
                add("option 3");
            }
        });
        System.out.println("using the getResult method");
        votingSystem1.getResult(1);
        System.out.println();
        System.out.println("using the getVote method");
        votingSystem1.getVoting(1);



    }


}
