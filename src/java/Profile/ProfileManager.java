package Profile;

import ADTPackage.LinkedListWithIterator;
import GraphPackage.UndirectedGraph;
import java.util.*;

public class ProfileManager {

   private UndirectedGraph<Profile> friendsList;
   private ArrayList<Profile> friendsArray;

    public ProfileManager(){
      this.friendsList = new UndirectedGraph<>();
      this.friendsArray = new ArrayList<>();
    }

    public void addProfile(Profile user){
        friendsList.addVertex(user);
        friendsArray.add(user);
    }

    // call addEdge method from undirectedGraph, this method comes from the
    // BasicGraphInterface
    public void connectFriends(Profile user1, Profile user2){
        // using addEdge from GraphPackage.DirectedGraph.java
        friendsList.addEdge(user1, user2);
    }

    // only needs to display friends names
    public void displayAllProfiles(){
        for(Profile user: friendsArray){
            user.displayProfile();
            System.out.printf("- - - - - - - - - - - - - - - \n");
        }
    }

    public void displayMyFriends(Profile user){
        /*
        you can either pass the user that is logged in
        or you can call this with one of the users friends and display
        your friends friends
         */

    }


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
