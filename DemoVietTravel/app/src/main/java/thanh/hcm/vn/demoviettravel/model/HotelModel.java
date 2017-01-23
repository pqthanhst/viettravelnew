package thanh.hcm.vn.demoviettravel.model;

/**
 * Created by phamquocthanh on 1/22/2017.
 */

public class HotelModel {

    int idHotel;
    int photoHotel;
    String nameHotel;
    String addressHotel;
    float numRanting;

    public HotelModel(int idHotel, int photoHotel, String nameHotel, String addressHotel, float numRanting) {
        this.idHotel = idHotel;
        this.photoHotel = photoHotel;
        this.nameHotel = nameHotel;
        this.addressHotel = addressHotel;
        this.numRanting = numRanting;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getPhotoHotel() {
        return photoHotel;
    }

    public void setPhotoHotel(int photoHotel) {
        this.photoHotel = photoHotel;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getAddressHotel() {
        return addressHotel;
    }

    public void setAddressHotel(String addressHotel) {
        this.addressHotel = addressHotel;
    }

    public float getNumRanting() {
        return numRanting;
    }

    public void setNumRanting(float numRanting) {
        this.numRanting = numRanting;
    }
}
