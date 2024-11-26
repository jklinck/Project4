package Profile;

import java.util.*;

public class Profile {

    private String name;
    private int age;
    private List friends;
    private boolean status;

    public Profile(String name, int age){
        this.name = name;
        this.age = age;
        status = false;
        friends = null;
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

//    public List getFriends(){
//
//    }

    void setName(String name){
        this.name = name;
    }

    // calls addProfile and connectFriends from ProfileManager
    void addFriends(Profile friend){

    }

    void displayProfile(){
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Name: ds\n", this.age);
        System.out.printf("Name: %b\n", this.status);
    }

    void setStatus(){
        if(this.status == false){
            this.status = true;
        }
        if else(this.status == true){
            this.status = false;
        }
    }
}
