
import java.util.*;

import ir.huri.jcal.JalaliCalendar;


public class Voting {
    private int type;
    //if type == 0 : uni-vote system
    //if type == 1 : plural-vote system

    private String question;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> polls;

    public Voting(int typeOfVote, String question){
        voters = new ArrayList<>();
        polls = new HashMap<>();
        this.type = typeOfVote;
        this.question = question;

        if(typeOfVote == 0){
            //uni-vote system of voting has the characteristic of random choosing
            createPoll("random choice");
        }
    }

    public String getQuestion(){
        return question;
    }

    public void createPoll(String choice){
        polls.put(choice, new HashSet<>());
    }

    public void vote(Person voter, ArrayList<String> choices){
        if(type == 0 && choices.size()>1){
            System.out.println("the person "+voter.toString() +" wants to chose more than one of the answer in a uni-vote poll\n choices not accepted");
            return;
        }
        //we make sure this person hasn't already participated in this
        if(voters.contains(voter)){
            System.out.println("this player has already participated in this poll");
            return;
        }

        if(type == 0 && choices.get(0).equals("random choice") ){
            //this option is available only for the uni-vote system so we are sure the player cannot chose another
            //and that choices.size()==1 is true
            ArrayList <String> choicesTemp=new ArrayList<>();
            for(String str : polls.keySet()){
                choicesTemp.add(str);
            }
            //now we have an array list with the values of the key set of polls hash map
            int randomNumber = (new Random()).nextInt(choicesTemp.size()-1);
            //-1 because "random choice" is one of the options
            if(choicesTemp.get(randomNumber).equals("random choice")){
                polls.get(choicesTemp.get(randomNumber+1)).add(new Vote(voter, new JalaliCalendar().toString()));
            }else {
                polls.get(choicesTemp.get(randomNumber)).add(new Vote(voter, new JalaliCalendar().toString()));
            }
            return;
        }

        for(int i=0; i<choices.size(); i++){
            //we make sure the choice passed to this method in the array list is actually part of this voting
             if(  polls.containsKey( choices.get(i) ) ) {
                 //we make sure this player hasn't already voted to this option
                 boolean alreadyVoted = false;
                 for (String strOption : polls.keySet()) {
                     for (Vote tempVote : polls.get(strOption)) {
                         if (tempVote.getPerson().equals(voter)) {
                             alreadyVoted = true;
                             break;
                         }
                     }
                     if (alreadyVoted == true) {
                         break;
                     }
                 }

                 if (alreadyVoted == true) {
                     System.out.println("this person has already voted to this option!\ncannot vote again");
                     continue;
                 } else {
                     polls.get(choices.get(i)).add(new Vote(voter, new JalaliCalendar().toString()));
                 }
             }else{
                System.out.println("this is not a choice for this question");
             }
        }
        voters.add(voter);
    }

    public void getVoters(){
        System.out.println("\n...");
        System.out.println("the participants of this vote are:");
        for(int i=0; i<voters.size(); i++){
            System.out.println("voter "+ (i+1)+ ") "+ voters.get(i).toString());
        }
        System.out.println("...\n");
    }

    public void printVotes(){
        System.out.println("\n---");
        System.out.println("the choices are:");
        int i=1;
        for(String choice : polls.keySet()){
            System.out.printf(i+") "+choice+" | number of votes: "+ polls.get(choice).size());
            if(voters.size()!=0) {
                System.out.println(" info of Voters: ");
                for (Vote vote : polls.get(choice)) {
                    System.out.println("\tvoter: " + vote.getPerson().toString() + " | Date: " + vote.getDate());
                }
            }
            i++;
        }
        System.out.println("---\n");
    }

    public ArrayList<String> getPolls(){
        ArrayList<String> choices= new ArrayList<>();
        for(String choice : polls.keySet()){
            choices.add(choice);
        }
        return choices;
    }
}
