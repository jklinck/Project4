package Profile;
import java.util.ArrayList;

/**
 * This class is for creating user Profiles as well as updating, displaying
 * user information, displaying friends and adding friends
 * @author Joe Klinck
 * @author Anthony Lei
 */

public class Profile {

    private String name;
    private int age;
    private ArrayList<Profile> friends;
    private boolean status;

    /**
     * Default constructor for creating a user Profile,
     * takes a string and int as parameters and adds those
     * as the users name and age. Also sets their status to true
     * and creates an ArrayList to store their friends
     * @param name - String value for users name
     * @param age - int value for users age
     */
    public Profile(String name, int age){
        this.name = name;
        this.age = age;
        status = true;
        friends = new ArrayList<>();
    }

    /**
     * Returns the users name
     * @return - String
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the users age
     * @return - int
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Returns the user's status
     * @return - boolean
     */
    public boolean getStatus(){
        return this.status;
    }

    /**
     * Returns a list of the users friends
     * @return - ArrayList of type Profile
     */
    public ArrayList<Profile> getFriends(){
        return this.friends;
    }

    /**
     * Sets the users name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the users age
     * @param age
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * Allows user to change their status
     */
    public void setStatus(){
        if(this.status == false){
            this.status = true;
        }
        else if(this.status == true){
            this.status = false;
        }
    }

    /**
     * Allows user to add a friend
     * @param friend
     * @return - Profile object
     */
    public Profile addFriend(Profile friend){
        friends.add(friend);

        return friend;
    }

    /**
     * Allows a user to display their profile information
     */
    public void displayProfile(){
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Age: %d\n", this.age);
        System.out.printf("Status: %b\n", this.status);
    }
}
