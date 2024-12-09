package Profile;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProfileTest {

    @Test
    void getName() {
        Profile profile = new Profile("John Doe", 25);
        assertEquals("John Doe", profile.getName(), "The name should match the initialized value.");
    }

    @Test
    void getAge() {
        Profile profile = new Profile("John Doe", 25);
        assertEquals(25, profile.getAge(), "The age should match the initialized value.");
    }

    @Test
    void getStatus() {
        Profile profile = new Profile("John Doe", 25);
        assertTrue(profile.getStatus(), "The initial status should be true.");
    }

    @Test
    void setName() {
        Profile profile = new Profile("John Doe", 25);
        profile.setName("Jane Doe");
        assertEquals("Jane Doe", profile.getName(), "The name should be updated to 'Jane Doe'.");
    }

    @Test
    void addFriend() {
        Profile profile = new Profile("John Doe", 25);
        Profile friend = new Profile("Jane Doe", 26);
        profile.addFriend(friend);

        assertTrue(profile.getFriends().contains(friend), "The friend should be added to the list of friends.");
    }

    @Test
    void displayProfile() {
        Profile profile = new Profile("John Doe", 25);
        profile.displayProfile(); // Visual test; confirm output manually.
    }

    @Test
    void setStatus() {
        Profile profile = new Profile("John Doe", 25);

        profile.setStatus();
        assertFalse(profile.getStatus(), "The status should toggle to false.");

        profile.setStatus();
        assertTrue(profile.getStatus(), "The status should toggle back to true.");
    }
}
