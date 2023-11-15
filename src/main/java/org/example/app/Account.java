package org.example.app;

public class Account {

    private boolean active;
    private Address defaultDelivery;

    public void setActive(boolean active) {
        this.active = active;
    }

    public Account(Address defaultDelivery) {
        this.defaultDelivery = defaultDelivery;
        if (defaultDelivery != null){
            activate();
        }else {
            this.active = false;
        }
    }

    public Address getDefaultDelivery() {
        return defaultDelivery;
    }

    public void setDefaultDelivery(Address defaultDelivery) {
        this.defaultDelivery = defaultDelivery;
    }

    Account() {
        this.active = false;
    }

    void activate() {
        this.active = true;
    }

    boolean isActive() {
        return this.active;
    }
}
