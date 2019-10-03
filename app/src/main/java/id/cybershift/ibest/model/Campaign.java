package id.cybershift.ibest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Campaign implements Parcelable {
    String posterPath;
    String userUID;
    String key;
    String judul;
    String periode_waktu;
    String batas_registrasi;
    String lokasi;
    String tugas_relawan;
    String barang;
    String briefing;
    String informasi_tambahan;

    protected Campaign(Parcel in) {
        posterPath = in.readString();
        userUID = in.readString();
        key = in.readString();
        judul = in.readString();
        periode_waktu = in.readString();
        batas_registrasi = in.readString();
        lokasi = in.readString();
        tugas_relawan = in.readString();
        barang = in.readString();
        briefing = in.readString();
        informasi_tambahan = in.readString();
    }

    public static final Creator<Campaign> CREATOR = new Creator<Campaign>() {
        @Override
        public Campaign createFromParcel(Parcel in) {
            return new Campaign(in);
        }

        @Override
        public Campaign[] newArray(int size) {
            return new Campaign[size];
        }
    };

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public Campaign() {
    }

    public Campaign(String userID, String judul, String periode_waktu, String batas_registrasi, String lokasi) {
        this.userUID = userID;
        this.judul = judul;
        this.periode_waktu = periode_waktu;
        this.batas_registrasi = batas_registrasi;
        this.lokasi = lokasi;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPeriode_waktu() {
        return periode_waktu;
    }

    public void setPeriode_waktu(String periode_waktu) {
        this.periode_waktu = periode_waktu;
    }

    public String getBatas_registrasi() {
        return batas_registrasi;
    }

    public void setBatas_registrasi(String batas_registrasi) {
        this.batas_registrasi = batas_registrasi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTugas_relawan() {
        return tugas_relawan;
    }

    public void setTugas_relawan(String tugas_relawan) {
        this.tugas_relawan = tugas_relawan;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getBriefing() {
        return briefing;
    }

    public void setBriefing(String briefing) {
        this.briefing = briefing;
    }

    public String getInformasi_tambahan() {
        return informasi_tambahan;
    }

    public void setInformasi_tambahan(String informasi_tambahan) {
        this.informasi_tambahan = informasi_tambahan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(posterPath);
        parcel.writeString(userUID);
        parcel.writeString(key);
        parcel.writeString(judul);
        parcel.writeString(periode_waktu);
        parcel.writeString(batas_registrasi);
        parcel.writeString(lokasi);
        parcel.writeString(tugas_relawan);
        parcel.writeString(barang);
        parcel.writeString(briefing);
        parcel.writeString(informasi_tambahan);
    }
}
