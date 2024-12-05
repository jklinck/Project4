package Profile;

import ADTPackage.LinkedListWithIterator;
import GraphPackage.UndirectedGraph;
import java.util.*;

public class ProfileManager {

   private UndirectedGraph<Profile> friendsList;
   private ArrayList<Profile> friendsArray;
   private Profile firstProfile;
   /*
   I created a Profile firstProfile so the displayAllProfiles below would
   have a starting point, in the deleteProfile method we need to
   account for the edge case where the Profile we are deleting is the
   current firstProfile, if so we need to assign firstProfile to one of
   the current firstProfile's friends
    */

    public ProfileManager(){
      this.friendsList = null;
      this.friendsArray = null;
      this.firstProfile = null;
    }

    /* add a profile to the graph, doesn't create a new profile, just adds a profile to the graph,
    performs a null check on friendsList and if it is then it creates a new UndirectedGraph and add
    user as the firstProfile and then adds user as a vertex
     */

    /*
    this is a check to see if all of the Profiles added in Main are being
    added to UndirectedGraph friendsList
     */
    public int getAllFriends(){
        return friendsList.getNumberOfVertices();
    }

    public void addProfile(Profile user){
        if(friendsList == null){
            friendsList = new UndirectedGraph<Profile>();
            friendsArray = new ArrayList<>();
            firstProfile = user;
        }
        friendsList.addVertex(user);
        friendsArray.add(user);
        /*
        a graph can be acyclic, thus we do not need the last vertex
        to be pointing at another vertex, thus it will operate similarly
        to a doubly linked list, although it could end up cyclic if the
        first profile and last profile are friends
         */
    }

    // call addEdge method from undirectedGraph, this method comes from the
    // BasicGraphInterface
    public void connectFriends(Profile user1, Profile user2){
        friendsList.addEdge(user1, user2);
    }

    // only needs to display friends names
    public void displayAllProfiles(){
        for(Profile user: friendsArray){
            System.out.println(user.getName());
        }
    }

    public void removeProfile(Profile user){
        /*
        if removing the firstProfile Profile then we need to assign another random
        Profile/vertex to firstProfile

        also need to remove user from friendsArray
         */
    }

}
