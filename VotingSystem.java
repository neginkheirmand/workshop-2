
import java.util.ArrayList;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem(){
        votingList = new ArrayList<>();
    }

    public void createVoting(String question, int type, ArrayList<String> choices){
        Voting newVoting = new Voting(type, question);
        for(int i=0; i<choices.size(); i++) {
            newVoting.createPoll(choices.get(i));
        }
        votingList.add(newVoting);
        return;
    }

    public void getVotingList(){
        System.out.println("number of Votings: "+ votingList.size());
        if(votingList.size()!=0){
            int i=1;
            for(Voting voting : votingList){
                System.out.println("Vote "+i+") ");
                System.out.println("the Question was: "+ voting.getQuestion()+"\n and ");
                voting.printVotes();
                i++;
            }
        }
    }

    public void getVoting(int index){
        System.out.println("Vote "+(index+1)+") ");
        System.out.println("the Question was: "+ votingList.get(index).getQuestion()+"\n and the choices are:");
        ArrayList<String> choices =votingList.get(index).getPolls();
        for(int i=0; i<choices.size(); i++){
            System.out.println((i+1)+") "+choices.get(i));
        }
        return;
    }

    public void vote(int index, Person person, ArrayList<String> choices){
        votingList.get(index).vote(person, choices);
        return;
    }

    public void getResult(int indexVoting){
        votingList.get(indexVoting).printVotes();
    }
}
