package com.viisland.ViisGarden.commons;

public class PathConstant {
    public static class ProductPath {
        public static final String PRODUCT_MAP = "/api/product";
        public static final String ADD_PRODUCT = "/addProduct";
        public static final String UPDATE_PRODUCT = "/updateProduct/{productId}";
        public static final String DELETE_PRODUCT = "/deleteProduct/{productId}";
        public static final String GET_PRODUCT = "/getProduct";
        public static final String GET_ALL_PRODUCT = "/all-products";
    }

    public static class ArableFieldPath {
        public static final String ARABLE_FIELD_MAP = "/api/arableField";
        public static final String ADD_ARABLE_FIELD = "/addArableField";
        public static final String UPDATE_ARABLE_FIELD = "/updateArableField/{arableFieldId}";
        public static final String DELETE_ARABLE_FIELD = "/deleteArableField/{arableFieldId}";
        public static final String GET_ARABLE_FIELD = "/getArableField";
        public static final String GET_ALL_ARABLE_FIELD = "/all-arableFields";
    }

    public static class LocationPath {
        public static final String LOCATION_MAP = "/api/location";
        public static final String ADD_LOCATION = "/addLocation";
        public static final String UPDATE_LOCATION = "/updateLocation/{locationId}";
        public static final String DELETE_LOCATION = "/deleteLocation/{locationId}";
        public static final String GET_LOCATION = "/getLocation";
        public static final String GET_ALL_LOCATION = "/all-locations";
    }
}
