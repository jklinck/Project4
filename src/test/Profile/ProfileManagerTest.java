package Profile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfileManagerTest {

    @Test
    void addProfile() {
        ProfileManager manager = new ProfileManager();
        Profile user = new Profile("John Doe", 25);

        manager.addProfile(user);

        // Check if the profile exists in the ArrayList (friendsArray)
        assertTrue(manager.getFriendsArray().contains(user), "The user should be added to the friends array.");
    }

    @Test
    void connectFriends() {
        ProfileManager manager = new ProfileManager();
        Profile user1 = new Profile("John Doe", 25);
        Profile user2 = new Profile("Jane Doe", 26);

        manager.addProfile(user1);
        manager.addProfile(user2);

        manager.connectFriends(user1, user2);

        // Check if the users are connected
        assertTrue(user1.getFriends().contains(user2), "User1's friends should include User2.");
        assertTrue(user2.getFriends().contains(user1), "User2's friends should include User1.");
    }


    @Test
    void removeProfile() {
        ProfileManager manager = new ProfileManager();
        Profile user = new Profile("John Doe", 25);

        manager.addProfile(user);
        manager.removeProfile(user);

        // Check if the profile is removed from the ArrayList (friendsArray)
        assertFalse(manager.getFriendsArray().contains(user), "The user should be removed from the friends array.");
    }
}
