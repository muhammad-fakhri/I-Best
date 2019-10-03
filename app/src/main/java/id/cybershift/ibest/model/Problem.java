package id.cybershift.ibest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Problem implements Parcelable {
    String userID;
    String title;
    String location;
    String contact;
    String description;

    public Problem() {
    }

    protected Problem(Parcel in) {
        userID = in.readString();
        title = in.readString();
        location = in.readString();
        contact = in.readString();
        description = in.readString();
    }

    public static final Creator<Problem> CREATOR = new Creator<Problem>() {
        @Override
        public Problem createFromParcel(Parcel in) {
            return new Problem(in);
        }

        @Override
        public Problem[] newArray(int size) {
            return new Problem[size];
        }
    };

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userID);
        parcel.writeString(title);
        parcel.writeString(location);
        parcel.writeString(contact);
        parcel.writeString(description);
    }
}
