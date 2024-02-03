package com.example.deliveryservice.dao;

import java.util.List;

public final class DeliveryDao {
    private static final DeliveryDao INSTANCE = new DeliveryDao();

    // ..

    public static DeliveryDao getINSTANCE() {
        return INSTANCE;
    }

    private DeliveryDao() {
    }
}
