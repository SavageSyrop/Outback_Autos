package com.example.outback_autos;

import android.provider.BaseColumns;

public class CarInfoContract {
    public static abstract class CarInfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "car_info";
        public static final String BRAND = "brand";
        public static final String MODEL = "model";
        public static final String IMAGE_NAME = "image_name";
        public static final String MAX_POWER = "max_power";
        public static final String MAX_SPEED = "max_speed";
        public static final String FUEL_CONSUMPTION = "fuel_consumption";
        public static final String MAX_TORQUE = "max_torque";
        public static final String CLEARANCE = "clearance";
        public static final String DRIVE = "drive";
        public static final String PRICE = "price";
    }

    public static abstract class BrandInfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "brand_info";
        public static final String BRAND = "brand";
        public static final String IMAGE_NAME = "image_name";
        public static final String INFO = "info";
    }
}
