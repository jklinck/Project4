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
        John.addFriend(Amy);

//        friendsList.displayAllProfiles();
        /*
        code below is working and is a step in the right direction for
        getting displayAllProfiles() in ProfileManager working
         */
        LinkedListWithIterator<Profile> friends = John.getFriends();
        for(Profile friend : friends) {
            System.out.println(friend.getName());
        }


    }
}
