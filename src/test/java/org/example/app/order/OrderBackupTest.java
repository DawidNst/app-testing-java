package org.example.app.order;

import org.example.app.Meal;
import org.example.app.order.Order;
import org.example.app.order.OrderBackup;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;


class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {//otwarcie i intilizacja pliku
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @Test
    void backupOrderWithOneMeal() throws IOException {//test który sprawdza otwarcie i zakmniecie pliku z jego tworzeniem

        //given
        Meal meal = new Meal(15, "Pisces Pizza");
        org.example.app.order.Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOder(order);

        //then
        System.out.println("Order" + order.toString() + "backed up");
    }
    @AfterAll
    static void tearDown() throws IOException{// zamknięcie pliku
        orderBackup.closeFile();
    }
}