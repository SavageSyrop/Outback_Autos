package com.example.outback_autos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class CarInfoDBFiller {
    private CarInfoDBHelper mCarInfoDBHelper;
    private String[][] сarInfoData = {
            {"Ford", "Mustang","mustang","412 л.с.","250 км/ч"," 7.6-30.4 л на 100 км","6500 об./мин","145 мм","Задний","27.000$"},
            {"Ford","Mondeo","mondeo","190 л.c","205 км/ч","3.6-13.6 на 100 км","4000 об./мин","140 мм","Передний","31.828$"},
            {"Ford","F150","f150","400 л.c.","240 км/ч","9.4-16.8 л на 100 км","5500 об./мин","333 мм","Полный","$67.960"},
            {"Ford","Transit","transit","170 л.c.","110 км/ч","7.2-9.7 л на 100 км","4000 об./мин","307 мм","Задний","$47.199"},
            {"Ford","Focus","focus","125 л.c.","185 км/ч","4.6 л на 100 км","6000 об./мин","155 мм","Передний","$22.560"}
    };
    private String[][] brandInfoData = {
            {"Ford","ford","Ford Motor Company is an American multinational automobile manufacturer headquartered in Dearborn, Michigan, United States. It was founded by Henry Ford and incorporated on June 16, 1903. The company sells automobiles and commercial vehicles under the Ford brand, and luxury cars under its Lincoln luxury brand. "},
            {"Chevrolet","chevrolet","Chevrolet is a brand of cars sold by the economically independent association of the same name of General Motors Corporation. Chevrolet is the most popular among GM brands: in 2007, about 2.6 million vehicles were sold."},
            {"Hyundai","hyundai","Hyundai Motor Company is a South Korean automobile manufacturer. The largest automaker in the country and the fourth in the world. The headquarters is located in Seoul. It is part of the Hyundai Motor Group conglomerate, established in 2000."},
            {"Opel","opel","Opel Automobile GmbH is a German automobile manufacturer headquartered in Rüsselsheim. The company was founded on January 21, 1862; Car production began in 1899. Since 1929, it has been owned by General Motors. Since 2017, it has been owned by the Groupe PSA concern."},
            {"Subaru","subaru","Subaru is an automotive brand owned by Subaru Corporation. The volume of production in 2011 amounted to 528,234 cars and 52,027 commercial vehicles."},
            {"Volkswagen","volkswagen","Volkswagen is a German car brand, one of many owned by Volkswagen AG. Under this brand in 2019, 6 million 620 thousand cars were sold. The headquarters is in Wolfsburg. The Volkswagen Automuseum is also located there."}
    };

    public CarInfoDBFiller(CarInfoDBHelper CarInfoDBHelper) {
        mCarInfoDBHelper = CarInfoDBHelper;
    }

    private void addCarInfoRow(String[] data) {
        SQLiteDatabase database = mCarInfoDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CarInfoContract.CarInfoEntry.BRAND, data[0]);
        values.put(CarInfoContract.CarInfoEntry.MODEL, data[1]);
        values.put(CarInfoContract.CarInfoEntry.IMAGE_NAME, data[2]);
        values.put(CarInfoContract.CarInfoEntry.MAX_POWER, data[3]);
        values.put(CarInfoContract.CarInfoEntry.MAX_SPEED, data[4]);
        values.put(CarInfoContract.CarInfoEntry.FUEL_CONSUMPTION, data[5]);
        values.put(CarInfoContract.CarInfoEntry.MAX_TORQUE, data[6]);
        values.put(CarInfoContract.CarInfoEntry.CLEARANCE, data[7]);
        values.put(CarInfoContract.CarInfoEntry.DRIVE, data[8]);
        values.put(CarInfoContract.CarInfoEntry.PRICE, data[9]);

        long newRowId = database.insert(
                CarInfoContract.CarInfoEntry.TABLE_NAME,
                null,
                values);
    }

    private void addBrandInfoRow(String[] data) {
        SQLiteDatabase database = mCarInfoDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CarInfoContract.BrandInfoEntry.BRAND, data[0]);
        values.put(CarInfoContract.BrandInfoEntry.IMAGE_NAME, data[1]);
        values.put(CarInfoContract.BrandInfoEntry.INFO, data[2]);

        long newRowId = database.insert(
                CarInfoContract.BrandInfoEntry.TABLE_NAME,
                null,
                values);
    }

    public void fillDB() {
        for (int i = 0; i < сarInfoData.length; i++) {
            addCarInfoRow(сarInfoData[i]);
        }
        for (int i = 0; i < brandInfoData.length; i++) {
            addBrandInfoRow(brandInfoData[i]);
        }
    }
}