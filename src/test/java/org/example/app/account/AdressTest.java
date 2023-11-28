package org.example.app.account;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdressTest {

    @ParameterizedTest
    @CsvSource({"Słonimska , 50", " Sienkiewicza , 60/15", "Prowaintowa , 40 "})
    void givenAdressesNotBeEmpty(String street, String number) {
        assertThat(street, notNullValue());
        assertThat(street, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), lessThan(7));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void givenAdressesFromFileNotBeEmpty(String street, String number) {
        assertThat(street, notNullValue());
        assertThat(street, containsString("n"));
        assertThat(number, notNullValue());
        assertThat(number.length(), lessThan(7));
    }

}
