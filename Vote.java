
public class Vote {
    private Person person;
    private String date;

    public Vote(Person person, String date) {
        this.date = date;
        this.person = person;
    }

    public Person getPerson(){
        return person;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vote){
            Vote compVote = (Vote) obj;
            if(compVote.getPerson().toString().equals(person)  &&  compVote.getDate().equals(date)){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + person.toString().hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
