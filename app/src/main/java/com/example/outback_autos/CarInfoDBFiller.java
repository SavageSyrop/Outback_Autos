package com.example.outback_autos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class CarInfoDBFiller {
    private CarInfoDBHelper mCarInfoDBHelper;
    private String[][] сarInfoData = {
            {"Ford", "Mustang","ford_mustang","412","250"," 7.6-30.4","6500","145","Rear","27.000"},
            {"Ford","Mondeo","ford_mondeo","190","205","3.6-13.6","4000","140","Front","31.828"},
            {"Ford","F150","ford_f150","400 ","240","9.4-16.8","5500","333","4WD","67.960"},
            {"Ford","Transit","ford_transit","170","110","7.2-9.7","4000","307","Rear","47.199"},
            {"Ford","Focus","ford_focus","125 ","185","4.6","6000","155","Front","22.560"},
            {"Chevrolet","Camaro","chevrolet_camaro","650","240","11.8-16.1","6500","150 ","Rear","33.800"},
            {"Chevrolet","Tahoe","chevrolet_tahoe","343","180","9.6-12.6","5600","216","4WD","74.000"},
            {"Chevrolet","Corvette","chevrolet_corvette","495","315","8.3-19.5","6460","105","Rear","66.750"},
            {"Hyundai","Solaris","hyundai_solaris","123","193 "," 4.9-7.6","4000","160","Front","14.000"},
            {"Hyundai","Tucson","hyundai_tucson","132","201 ","6.3-8.4","5000","195","Front","27.000"},
            {"Hyundai","Santa Fe","hyundai_santa_fe","275","210 ","4.6-14.9  ","4000","176","4WD","40.000"},
            {"Opel","Astra","opel_astra","200 ","180"," 3.6-13","6000 ","160","Rear","18.000"},
            {"Opel","Vivaro","opel_vivaro","117 ","160","4.9-10.5","3500","180","Front","30.000"},
            {"Opel","Vivaro","opel_vivaro","117 ","160","4.9-10.5","3500","180","Front","30.000"},
            {"Subaru","Forester","subaru_forester","280","207","5.7-12.4","4000","220","4WD","31.200"},
            {"Subaru","WRX","subaru_wrx","268 ","255","7.6-13.7","5600","135","4WD","37.000"},
            {"Subaru","Outback","subaru_outback","265","206","6.2-9.3","4100","213","4WD","56.000"},
            {"Volkswagen","Beetle","volkswagen_beetle","210","160","4.3-11.9","2400","146","Front","20.000"},
            {"Volkswagen","Buzz","volkswagen_buzz","198","145","(Electric) 0","(Electric) 0","160","Rear","40.000"},
            {"Volkswagen","Golf","volkswagen_golf","147","216","4.7-8.7","5500","150","Front","47.000"},
            {"BMW","X2","bmw_x2","240","224","5.9-8.6","5000","182","4WD","37.500"},
            {"BMW","M8","bmw_m8","617","305","8.2-14.9","7300","128","4WD","117.300"},
            {"BMW","i7","bmw_i7","650","240","(Electric) 0","(Electric) 0","135","4WD","119.300"},
            {"Skoda","Rapid","skoda_rapid","125","204","3.6-7.5","4400","160","Front","16.000"},
            {"Skoda","Octavia","skoda_octavia","150","240","3.8-9.7","5200","180","Front","26.000"},
            {"Skoda","Kamiq","skoda_kamiq","150","193","7.3-9.3","5500","180","Front","17.900"},
            {"Honda","Accord","honda_accord","252","201"," 3.2-11.8","5000","139","Front","17.000"},
            {"Honda","Legend","honda_legend","314","250","5.9-13.2","6000","143","4WD","27.000"},
            {"Honda","Civic","honda_civic","158","210","3.2-14.1","4500","160","Front","12.000"},
            {"Volvo","XC60","volvo_xc60","197","180","5.8-17.1","5000","200","4WD","45.000"},
            {"Volvo","S90","volvo_s90","249","230","2.9-9.4","6200","152","4WD","42.000"},
            {"Volvo","XC90","volvo_xc90","225","180","6-8.2","3200","237","Front","77.262"},
            {"Mercedes","G-Class","mercedes_g_class","422","220","9.6-20.6","3500","241","4WD","16.170"},
            {"Mercedes","A-Class","mercedes_a_class","122","250","5.2-7.4","4000","104","Front","56.425"},
            {"Mercedes","E-Class","mercedes_e_class","197","300","7.1","4000","1604","4WD","73.307"},
            {"Mitsubishi","Lancer","mitsubishi_lancer","82","200","3.3-13.8","4000","175","Rear","15.361"},
            {"Mitsubishi","ASX","mitsubishi_asx","150","191","10","4200","215","4WD","40.593"},
            {"Mitsubishi","Eclipse","mitsubishi_eclipse","162","195","7.7-8","4000","155","Front","55.193"},
            {"Nissan","Cube","nissan_cube","85","160","5-6.8","4400","160","Front","17.500"},
            {"Nissan","GT-R","nissan_gt_r","570","315","9","5800","105","4WD","113.540"},
            {"Nissan","Qashqai","nissan_qashqai","115","194","1.2","2000","200","Rear","29.672"},
            {"Porsche","Panamera","porsche_panamera","310","315","8.6-11","6800","130","4WD","124.866"},
            {"Porsche","718","porsche_718","300","304","9.1-11","4500","113","Rear","78.174"},
            {"Porsche","911","porsche_911","650","330","9.4-14","5000","122","4WD","133.688"},
            {"Dodge","Challenger","dodge_challenger","327","327","7.8-31.2","4800","145","Rear","67.376"},
            {"Dodge","Charger","dodge_charger","485","315","19.6","4000","124","4WD","86.083"},
            {"Dodge","Ram","dodge_ram","506","190","14.7-26.1","4200","187","4WD","97.000"},
            {"UAZ","Patriot","uaz_patriot","134","150","13","3900","210","4WD","31.787"},
            {"UAZ","Hunter","uaz_hunter","128","130","10.6-15.5","2500","241","4WD","15.315"},
            {"UAZ","452","uaz_452","90","127","15.5","2500","241","4WD","26.768"},
            {"Koenigsegg","CCX","koenigsegg_ccx","1018","410","26","5800","100","Rear","2.000.000"},
            {"Koenigsegg","One:1","koenigsegg_one","1360","440","12.5-16.9","6000","59","Rear","2.500.000"},
            {"Alfa Romeo","Giulietta","alfa_romeo_giulietta","170","218","6.6","4500","140","Front","28.897"},
            {"Alfa Romeo","159","alfa_romeo_159","260","229","7.7-11.5","4500","150","Front","21.140"},
            {"Alfa Romeo","Giulia GTA","alfa_romeo_giulia","117","305","5.5","3000","100","4WD","42.000"}
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
            {"Mercedes","mercedes","Mercedes-Benz produces consumer luxury vehicles and commercial vehicles. Its first Mercedes-Benz-badged vehicles were produced in 1926. In 2018, Mercedes-Benz was the largest seller of premium vehicles in the world, having sold 2.31 million passenger cars."},
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