/*
 *  Ho Xin Yong Cinee
 *  Main function  to run  the system
 */
public class Main {
  
    public static void main(String[] args) {

        User user = new User();
     
        //UserV is inner class of User
        User.UserV userv = user.new UserV();
        User.UserM userm = user.new UserM();

        // Controller binds User view and user model, so it can links
        User.UserC userc =  user.new UserC(userv,userm);
        
    }

}
