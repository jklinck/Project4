package Profile;

import ADTPackage.LinkedListWithIterator;
import GraphPackage.UndirectedGraph;
import java.util.*;

public class ProfileManager {

   private UndirectedGraph<Profile> friendsList;
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
      this.firstProfile = null;
    }

    /* add a profile to the graph, doesn't create a new profile, just adds a profile to the graph,
    performs a null check on friendsList and if it is then it creates a new UndirectedGraph and add
    user as the firstProfile and then adds user as a vertex
     */

    public void addProfile(Profile user){
        if(friendsList == null){
            friendsList = new UndirectedGraph<Profile>();
            firstProfile = user;
        }
        friendsList.addVertex(user);
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
        /*
        this isn't working, need to look at getFriends method in Profile as
        potential issue
         */
        Stack<Profile> profiles = new Stack<>();
        Queue<Profile> visited = new LinkedList<Profile>();

        profiles.push(firstProfile);
        while(!profiles.isEmpty()){
            Profile current = profiles.pop();

            if(!visited.contains(current)){
                visited.add(current);
                LinkedListWithIterator<Profile> myFriends = current.getFriends();
                for(Profile adjacent : myFriends){
                    profiles.push(adjacent);
                }
                System.out.println(current.getName());
            }
        }
    }

    public void removeProfile(Profile user){
        /*
        if removing the firstProfile Profile then we need to assign another random
        Profile/vertex to firstProfile
         */
    }

}
