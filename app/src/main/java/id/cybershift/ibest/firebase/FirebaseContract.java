package id.cybershift.ibest.firebase;

public class FirebaseContract {
    public static String UserUID = "";

    public static String getUserUID() {
        return UserUID;
    }

    public static void setUserUID(String userUID) {
        UserUID = userUID;
    }
}
