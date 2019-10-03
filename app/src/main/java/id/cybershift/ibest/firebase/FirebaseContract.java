package id.cybershift.ibest.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseContract {
    public static String UserUID = "";

    public static String getUserUID() {
        return UserUID;
    }

    public static void setUserUID(String userUID) {
        UserUID = userUID;
    }
}
