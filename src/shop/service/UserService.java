package shop.service;

import shop.model.User;

public class UserService {
    static User[] users = new User[50];
    static int count = 0;
    static long idGeneration = 0L;
    public boolean add(User user){

        if(checkUsername(user.getUsername())){
            user.setId(idGeneration++);
            users[count++] = user;
            return true;
        }
        return false;
    }

    public User signIn(String username, String password){
        for (int i = 0; i < count ; i++) {
           if(users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
               return users[i];
           }
        }
        return null;
    }

    private boolean checkUsername(String username) {
        for (int i = 0; i < count ; i++) {
            if(users[i].getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
}
