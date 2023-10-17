package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.shopecommerce.utils.constants.DocumentConstants.*;

@Document(collection = ORDERS_ADMIN_COLLECTION)
@Getter
@Setter
public class OrdersAdminEntity {
    @Id
    @Field(ID)
    private String id;
    @Field(ORDER_ADMIN_TOTAL)
    private Float totalYear;
    @Field(ORDERS_ADMIN_MONTH)
    private Float totalMonth;
    @Field(ORDERS_ADMIN_WEEK)
    private Float totalWeek;
    @Field(ORDERS_ADMIN_DAY)
    private Float totalDay;
    @Field(ORDERS_ADMIN_MONTHS)
    private List<Float> months;
    @Field(ORDERS_ADMIN_WEEKS)
    private List<Float> weeks;
    @Field(ORDERS_ADMIN_DAYS)
    private List<Float> days;
}
