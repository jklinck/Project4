package Profile;

import ADTPackage.LinkedListWithIterator;
import GraphPackage.UndirectedGraph;
import java.util.*;

public class ProfileManager {

   private UndirectedGraph<Profile> friendsList;
   private ArrayList<Profile> friendsArray;

    public ProfileManager(){
      this.friendsList = new UndirectedGraph<Profile>();
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
            System.out.println(user.getName());
        }
    }

    public void removeProfile(Profile user){
        friendsArray.remove(user);

    /*
    we need to remove the profile from the graph and also
    remove the edges


     */
    }

}
