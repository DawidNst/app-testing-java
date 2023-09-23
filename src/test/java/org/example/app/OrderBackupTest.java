package org.example.app;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @Test
    void backupOrderWithOneMeal() throws IOException {

        //given
        Meal meal = new Meal(15, "Pisces Pizza");
        Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOder(order);

        //then
        System.out.println("Order" + order.toString() + "backed up.");
    }
    @AfterAll
    static void tearDown() throws IOException{
        orderBackup.closeFile();
    }
}