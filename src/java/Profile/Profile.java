package Profile;

import ADTPackage.LinkedListWithIterator;

import java.lang.reflect.Array;

public class Profile {

    private String name;
    private int age;
    private ArrayList<Profile> friends;
    private boolean status;

    public Profile(String name, int age){
        this.name = name;
        this.age = age;
        status = false;
        friends = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public boolean getStatus(){
        return this.status;
    }

    public ArrayList<Profile> getFriends(){
        return this.friends;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    // calls addProfile and connectFriends from ProfileManager
    public Profile addFriend(Profile friend){
        friends.add(friend);

        return friend;
    }

    public void displayProfile(){
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Age: %d\n", this.age);
        System.out.printf("Status: %b\n", this.status);
    }

    public void setStatus(){
        if(this.status == false){
            this.status = true;
        }
        else if(this.status == true){
            this.status = false;
        }
    }
}
