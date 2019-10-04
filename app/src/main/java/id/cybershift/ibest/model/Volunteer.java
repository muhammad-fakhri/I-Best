package id.cybershift.ibest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Volunteer implements Parcelable {
    String name, email, gender, institution, domisili, job;
    String UID;

    public Volunteer() {
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    protected Volunteer(Parcel in) {
        name = in.readString();
        email = in.readString();
        gender = in.readString();
        institution = in.readString();
        domisili = in.readString();
        job = in.readString();
        UID = in.readString();
    }

    public static final Creator<Volunteer> CREATOR = new Creator<Volunteer>() {
        @Override
        public Volunteer createFromParcel(Parcel in) {
            return new Volunteer(in);
        }

        @Override
        public Volunteer[] newArray(int size) {
            return new Volunteer[size];
        }
    };

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(gender);
        parcel.writeString(institution);
        parcel.writeString(domisili);
        parcel.writeString(job);
        parcel.writeString(UID);
    }
}
