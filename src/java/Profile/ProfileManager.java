package Profile;

import GraphPackage.UndirectedGraph;
import ADTPackage.QueueInterface;
import ADTPackage.LinkedQueue;
import java.util.*;

/**
 * This class is for creating an UndirectedGraph containing Profile objects to
 * create users in a social network.
 * @author Joe Klinck
 * @author Anthony Lei
 */

public class ProfileManager {

   private UndirectedGraph<Profile> friendsGraph;
   private ArrayList<Profile> friendsArray;

    /**
     * Default constructor for creating an UndirectedGraph containing Profile objects
     * of users and mirror that graph with an ArrayList
     */
    public ProfileManager(){
      this.friendsGraph = new UndirectedGraph<>();
      this.friendsArray = new ArrayList<>();
    }

    /**
     * Utility method for displayAllProfilesDepthFirst and displayAllProfilesBreadthFirst
     * so a user can pass a name as a String and have it converted back into a Profile object.
     * This is a good method but there is one glaring issue. What if there are two users
     * with the same name. I'm going to leave this alone, but it could be corrected by
     * adding a userID field into Profile since many users could have the same name but
     * no user will have the same userID as another.
     * @param name - String
     * @return - Profile object
     */
    public Profile getUser(String name){
        Profile returnedUser = null;
        for(Profile user: friendsArray){
            // if names match
            if(user.getName().equals(name)){
                returnedUser = user;
            }
        }
        return returnedUser;
    }

    /**
     * Add a profile to the social network
     * @param user - Profile
     */
    public void addProfile(Profile user){
        friendsGraph.addVertex(user);
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
        friendsGraph.addEdge(user1, user2);
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
        friendsGraph.removeUser(user);
    }

    /**
     * Utility method for calling getBreadthFirstTraversal() from DirectedGraph but
     * passing a String instead of a Profile object.
     * @param name - String
     */
    public void displayAllProfilesBreadthFirst(String name){
        Profile user = this.getUser(name);
        QueueInterface<Profile> userQueue = friendsGraph.getBreadthFirstTraversal(user);
        while(!userQueue.isEmpty()){
            System.out.println(userQueue.dequeue().getName());
        }
    }

    /**
     * Utility method for calling getDepthFirstTraversal() from DirectedGraph but
     * passing a String instead of a Profile object.
     * @param name - String
     */
    public void displayAllProfilesDepthFirst(String name){
        Profile user = this.getUser(name);
        QueueInterface<Profile> userQueue = friendsGraph.getDepthFirstTraversal(user);
        while(!userQueue.isEmpty()){
            System.out.println(userQueue.dequeue().getName());
        }
    }

}



