package com.shopecommerce.utils;


import lombok.NoArgsConstructor;

public class DocumentConstants {
    //global
    public static final String ID = "_id";
    public static final String CREATE_AT = "create_at";
    public static final String MODIFIED_AT = "modified_at";
    public static final String USER_ID = "user_id";
    public static final String PRODUCT_ID = "product_id";
    public static final String QUANTITY = "quantity";
    public static final String PAYMENT_TYPE = "payment_type";

    //users
    public static final String USER_COLLECTION = "users";
    public static final String USER_NAME = "name";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";
    public static final String USER_PHONE = "phone";
    public static final String USER_ROLE = "role";
    public static final String LOGIN_FAIL = "count";
    public static final String USER_BANNED = "banned";
    public static final String USER_ADDRESS = "address";
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String POSTAL_CODE = "postal_code";
    public static final String COUNTRY_DETAIL = "country_detail";
    public static final String MOBILE = "mobile";
    public static final String CART = "cart";

    //products
    public static final String PRODUCT_COLLECTION = "products";
    public static final String PRODUCT_NAME = "name";
    public static final String PRODUCT_CATEGORY = "category";
    public static final String PRODUCT_DESCRIPTION = "description";
    public static final String PRODUCT_STOCK = "stock";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_DISCOUNT = "discount";
    public static final String DISCOUNT_NAME = "name";
    public static final String DISCOUNT_STATUS = "status";
    public static final String DISCOUNT_PERCENTAGE = "percentage";

    //orders
    public static final String ORDER_COLLECTION = "orders";
    public static final String ORDER_TOTAL = "total";
    public static final String ORDER_TAX = "tax_price";
    public static final String ORDER_STATUS = "status";
    public static final String ORDER_ITEMS = "items";

    //roles
    public static final String ROLE_COLLECTION = "roles";
    public static final String ROLE_NAME = "name";
    public static final String ROLE_FUNCTIONS = "functions";
    public static final String ROLE_STATUS = "status";
    public static final String ROLE_PRIORITY = "priority";

    //functions role
    public static final String FUNCTIONS_COLLECTION = "function";
    public static final String FUNCTION_DESCRIPTION = "description";
    public static final String SUB_FUNCTIONS = "sub_functions";


    //orders admin
    public static final String ORDERS_ADMIN_COLLECTION = "orders_admin";
    public static final String ORDER_ADMIN_TOTAL = "total_year";
    public static final String ORDERS_ADMIN_MONTH = "total_month";
    public static final String ORDERS_ADMIN_WEEK = "total_week";
    public static final String ORDERS_ADMIN_DAY = "total_day";
    public static final String ORDERS_ADMIN_MONTHS = "months";
    public static final String ORDERS_ADMIN_WEEKS = "weeks";
    public static final String ORDERS_ADMIN_DAYS = "days";
}
