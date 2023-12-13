package org.example.app.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeAfterExtension implements AfterEachCallback {

    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Inside before each extension");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Inside after each extension");
    }
}
