package thanh.hcm.vn.demoviettravel.model;

/**
 * Created by phamquocthanh on 1/21/2017.
 */

public class PlaceModel {

    int idPlace;
    int photoPlace;
    String namePlace;
    String addressPlace;
    String timePlace;

    public PlaceModel(int idPlace, int photoPlace, String namePlace, String addressPlace, String timePlace) {
        this.idPlace = idPlace;
        this.photoPlace = photoPlace;
        this.namePlace = namePlace;
        this.addressPlace = addressPlace;
        this.timePlace = timePlace;
    }

    public int getPhotoPlace() {
        return photoPlace;
    }

    public void setPhotoPlace(int photoPlace) {
        this.photoPlace = photoPlace;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getAddressPlace() {
        return addressPlace;
    }

    public void setAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
    }

    public String getTimePlace() {
        return timePlace;
    }

    public void setTimePlace(String timePlace) {
        this.timePlace = timePlace;
    }
}
