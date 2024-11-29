package Profile;

import GraphPackage.UndirectedGraph;

public class ProfileManager {

   private UndirectedGraph<Profile> friendsList;
   private Profile root;
   /*
   I created a root Profile so the displayAllProfiles below would
   have a starting point, in the deleteProfile method we need to
   account for the edge case where the Profile we are deleting is the
   current root, if so we need to assign any other random node to root
    */

    public ProfileManager(){
      this.friendsList = new UndirectedGraph<>();
      this.root = null;
    }

    // add a profile to the graph, doesn't create a new profile, just adds a profile to the graph
    public void addProfile(Profile user){
        if(friendsList == null){

        }
        friendsList.addVertex(user);
    }

    // call addEdge method from undirectedGraph, this method comes from the
    // BasicGraphInterface
    void connectFriends(Profile user1, Profile user2){
        friendsList.addEdge(user1, user2);
    }

    // only needs to display friends names
    void displayAllProfiles(){

    }

    void removeProfile(Profile user){
        /*
        if removing the root Profile then we need to assign another random
        Profile/vertex to root
         */
    }

}
