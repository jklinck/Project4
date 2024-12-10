package Profile;

import GraphPackage.UndirectedGraph;
import java.util.*;

/**
 * This class is for creating an UndirectedGraph containing Profile objects to
 * create users in a social network.
 * @author Joe Klinck
 * @author Anthony Lei
 */

public class ProfileManager {

   private UndirectedGraph<Profile> friendsList;
   private ArrayList<Profile> friendsArray;

    /**
     * Default constructor for creating an UndirectedGraph containing Profile objects
     * of users and mirror that graph with an ArrayList
     */
    public ProfileManager(){
      this.friendsList = new UndirectedGraph<>();
      this.friendsArray = new ArrayList<>();
    }

    /**
     * Add a profile to the social network
     * @param user - Profile
     */
    public void addProfile(Profile user){
        friendsList.addVertex(user);
        friendsArray.add(user);
    }

    /**
     * Returns and array containing all users
     * @return - ArrayList of type Profile
     */
    public ArrayList<Profile> getFriendsArray(){
        return this.friendsArray;
    }

    /**
     * Allows a user to connect themselves to other users (create a friendship)
     * @param user1 - Profile
     * @param user2 - Profile
     */
    public void connectFriends(Profile user1, Profile user2){
        // using addEdge from GraphPackage.DirectedGraph.java
        friendsList.addEdge(user1, user2);
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    /**
     * Displays all Profiles in the social network
     */
    public void displayAllProfiles(){
        for(Profile user: friendsArray){
            user.displayProfile();
            System.out.printf("- - - - - - - - - - - - - - - \n");
        }
    }

    /**
     * Allows a user to print out the names of all of their friends
     * @param user - Profile
     */
    public void displayMyFriends(Profile user){
        /*
        you can either pass the user that is logged in
        or you can call this with one of the users friends and display
        your friends friends
         */
        System.out.printf("%s's friends: \n", user.getName());
        ArrayList<Profile> list = user.getFriends();
        for(Profile current: list){
            System.out.println(current.getName());
        }

    }

    /**
     * Allows for the deleting of a user from the graph, also removes the user
     * from the ArrayList which is mirroring the graph.
     * @param user - Profile
     */
    public void removeProfile(Profile user){
        friendsArray.remove(user);
        /*
        removeUser is the method that we added to DirectedGraph.java so we could
        access the remove method in UnsortedLinkedDictionary since the graph being
        created inside of
         */
        friendsList.removeUser(user);
    /*
    we need to remove the profile from the graph and also
    remove the edges


     */
    }

}
