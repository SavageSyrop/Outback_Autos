package com.example.outback_autos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class CarInfoDBFiller {
    private CarInfoDBHelper mCarInfoDBHelper;
    private String[][] сarInfoData = {
            {"Ford", "Mustang","ford_mustang","412 л.с.","250 км/ч"," 7.6-30.4 л на 100 км","6500 об./мин","145 мм","Задний","27.000$"},
            {"Ford","Mondeo","ford_mondeo","190 л.c","205 км/ч","3.6-13.6 на 100 км","4000 об./мин","140 мм","Передний","31.828$"},
            {"Ford","F150","ford_f150","400 л.c.","240 км/ч","9.4-16.8 л на 100 км","5500 об./мин","333 мм","Полный","$67.960"},
            {"Ford","Transit","ford_transit","170 л.c.","110 км/ч","7.2-9.7 л на 100 км","4000 об./мин","307 мм","Задний","$47.199"},
            {"Ford","Focus","ford_focus","125 л.c.","185 км/ч","4.6 л на 100 км","6000 об./мин","155 мм","Передний","$22.560"}
//            {}
    };
    private String[][] brandInfoData = {
            {"Ford","ford","Ford Motor Company is an American multinational automobile manufacturer headquartered in Dearborn, Michigan, United States. It was founded by Henry Ford and incorporated on June 16, 1903. The company sells automobiles and commercial vehicles under the Ford brand, and luxury cars under its Lincoln luxury brand. "},
            {"Chevrolet","chevrolet","Chevrolet is a brand of cars sold by the economically independent association of the same name of General Motors Corporation. Chevrolet is the most popular among GM brands: in 2007, about 2.6 million vehicles were sold."},
            {"Hyundai","hyundai","Hyundai Motor Company is a South Korean automobile manufacturer. The largest automaker in the country and the fourth in the world. The headquarters is located in Seoul. It is part of the Hyundai Motor Group conglomerate, established in 2000."},
            {"Opel","opel","Opel Automobile GmbH is a German automobile manufacturer headquartered in Rüsselsheim. The company was founded on January 21, 1862; Car production began in 1899. Since 1929, it has been owned by General Motors. Since 2017, it has been owned by the Groupe PSA concern."},
            {"Subaru","subaru","Subaru is an automotive brand owned by Subaru Corporation. The volume of production in 2011 amounted to 528,234 cars and 52,027 commercial vehicles."},
            {"Volkswagen","volkswagen","Volkswagen is a German car brand, one of many owned by Volkswagen AG. Under this brand in 2019, 6 million 620 thousand cars were sold. The headquarters is in Wolfsburg. The Volkswagen Automuseum is also located there."},
            {"BMW","bmw","Bayerische Motoren Werke AG, commonly referred to as BMW (German pronunciation: is a German multinational corporate manufacturer of luxury vehicles and motorcycles headquartered in Munich, Bavaria, Germany. The corporation was founded in 1916 as a manufacturer of aircraft engines, which it produced from 1917 until 1918 and again from 1933 to 1945."},
            {"Skoda","skoda","Škoda, is a Czech automobile manufacturer established in 1925 as the successor to Laurin & Klement and headquartered in Mladá Boleslav, Czech Republic. Škoda Works became state owned in 1948. After 1991, it was gradually privatized to the German Volkswagen Group, becoming a partial subsidiary in 1994 and a wholly owned subsidiary in 2000."},
            {"Honda","honda","Honda  is a Japanese public multinational conglomerate manufacturer of automobiles, motorcycles, and power equipment, headquartered in Minato, Tokyo, Japan. Honda has been the world's largest motorcycle manufacturer since 1959,reaching a production of 400 million by the end of 2019."},
            {"Volvo","volvo","Volvo  is a Swedish multinational manufacturing corporation headquartered in Gothenburg. While its core activity is the production, distribution and sale of trucks, buses and construction equipment, Volvo also supplies marine and industrial drive systems and financial services. In 2016, it was the world's second-largest manufacturer of heavy-duty trucks."},
            {"Mercedes","mercedes"," Mercedes-Benz produces consumer luxury vehicles and commercial vehicles.[note 2] Its first Mercedes-Benz-badged vehicles were produced in 1926. In 2018, Mercedes-Benz was the largest seller of premium vehicles in the world, having sold 2.31 million passenger cars."},
            {"Mitsubishi","mitsubishi","Mitsubishi Corporation (MC) is a global integrated business enterprise that develops and operates businesses together with its offices and subsidiaries in approximately 90 countries and regions worldwide, as well as a global network of around 1,700 group companies."},
            {"Nissan","nissan","Nissan  is a Japanese multinational automobile manufacturer headquartered in Nishi-ku, Yokohama, Japan. The company sells its vehicles under the Nissan, Infiniti, and Datsun brands, with in-house performance tuning products (including cars) labelled Nismo. The company traces back to the beginnings of the 20th century, with the Nissan zaibatsu, now called Nissan Group."},
            {"Porsche","porsche","Porsche is a German automobile manufacturer specializing in high-performance sports cars, SUVs and sedans, headquartered in Stuttgart, Baden-Württemberg, Germany. The company is owned by Volkswagen AG, a controlling stake of which is owned by Porsche Automobil Holding SE. Porsche's current lineup includes the 718 Boxster/Cayman, 911 (992), Panamera, Macan, Cayenne and Taycan."},
            {"Dodge","dodge","Dodge is an American brand of automobiles and a division of Stellantis, based in Auburn Hills, Michigan. Dodge vehicles have historically included performance cars, and for much of its existence Dodge was Chrysler's mid-priced brand above Plymouth."},
            {"UAZ","uaz","is an automobile manufacturer based in Ulyanovsk, Russia, which manufactures off-road vehicles, buses and trucks. It has been part of the Sollers automotive group since 2000. \nUAZ is best known for the UAZ-469 utility vehicle, which has seen wide use as a military vehicle in the Eastern bloc and around the world. The UAZ factory started production in 1941 as part of the Soviet war effort. 51,706 UAZ vehicles were produced in 2016."},
            {"Koenigsegg","koenigsegg","The company was founded in 1994 in Sweden by Christian von Koenigsegg, with the intention of producing a \"world-class\" sports car. Many years of development and testing led to the CC8S, the company's first street-legal production car which was introduced in 2002."},
            {"Alfa Romeo","alfa_romeo","Alfa Romeo is an Italian luxury car manufacturer and a subsidiary of Stellantis. The company was founded on 24 June 1910, in Milan, Italy. \"Alfa\" is an acronym of its founding name, \"Anonima Lombarda Fabbrica Automobili.\" \"Anonima\" means \"anonymous\", which was a legal form of company at the time, as it was founded by anonymous investors. In the initial set-up phase, in order to have a building to produce cars, the company bought the Portello factory building of Darracq in Milan, which was closing up and selling all its assets.[3] The brand is known for sport-oriented vehicles and has been involved in car racing since 1911. Alfa Romeo was owned by Fiat Chrysler Automobiles, the company that was responsible for the production of Alfa Romeo cars until its operations were fully merged with those of the PSA Group to form Stellantis on 16 January 2021."}
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