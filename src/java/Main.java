import Profile.Profile;
import Profile.ProfileManager;
import ADTPackage.LinkedListWithIterator;

public class Main {
    public static void main(String[] args){
        ProfileManager friendsList = new ProfileManager();
        Profile John = new Profile("John", 30);
        Profile Amy = new Profile("Amy", 25);

        friendsList.addProfile(John);
        friendsList.addProfile(Amy);
        friendsList.connectFriends(John, Amy);

//        friendsList.displayAllProfiles();
        LinkedList<Profile> friends = John.getFriends();

        Node current = friends.head;

    }
}
