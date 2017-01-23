package thanh.hcm.vn.demoviettravel.model;

/**
 * Created by phamquocthanh on 1/21/2017.
 */

public class FoodModel {

    int idFood;
    int photoFood;
    String nameFood;
    String addressFood;
    String priceFood;

    public FoodModel(int idFood, int photoFood, String nameFood, String addressFood, String priceFood) {
        this.idFood = idFood;
        this.photoFood = photoFood;
        this.nameFood = nameFood;
        this.addressFood = addressFood;
        this.priceFood = priceFood;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getPhotoFood() {
        return photoFood;
    }

    public void setPhotoFood(int photoFood) {
        this.photoFood = photoFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getAddressFood() {
        return addressFood;
    }

    public void setAddressFood(String addressFood) {
        this.addressFood = addressFood;
    }

    public String getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(String priceFood) {
        this.priceFood = priceFood;
    }
}
