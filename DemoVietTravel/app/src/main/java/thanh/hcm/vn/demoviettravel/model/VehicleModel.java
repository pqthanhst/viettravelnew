package thanh.hcm.vn.demoviettravel.model;

/**
 * Created by phamquocthanh on 1/22/2017.
 */

public class VehicleModel {

    int idVehicle;
    int photoVehicle;
    String nameVehicle;
    String typeVehicle;
    //double numRattingVehicle;
    float numRattingVehicle;

    public VehicleModel(int idVehicle, int photoVehicle, String nameVehicle, String typeVehicle, float numRattingVehicle) {
        this.idVehicle = idVehicle;
        this.photoVehicle = photoVehicle;
        this.nameVehicle = nameVehicle;
        this.typeVehicle = typeVehicle;
        this.numRattingVehicle = numRattingVehicle;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getPhotoVehicle() {
        return photoVehicle;
    }

    public void setPhotoVehicle(int photoVehicle) {
        this.photoVehicle = photoVehicle;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

//    public double getNumRattingVehicle() {
//        return numRattingVehicle;
//    }
//
//    public void setNumRattingVehicle(double numRattingVehicle) {
//        this.numRattingVehicle = numRattingVehicle;
//    }

    public float getNumRattingVehicle() {
        return numRattingVehicle;
    }

    public void setNumRattingVehicle(float numRattingVehicle) {
        this.numRattingVehicle = numRattingVehicle;
    }
}
