public class User extends FileDB {
    public String fullName;
    public String email;
    public String password;

    User(String fullName, String email, String password) {
        super("db_users.txt");
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public Boolean signUp() {
        insertFile(this.fullName);
        insertFile(this.email);
        insertFile(this.password);
        return true;
    }

    /*public boolean signIn(){
        int index = 0;
        index++;
        if (selectData(email)==2 && (selectData(password) == 3)){
            return true;
        }else{
            return false;
        }
    }*/
}
