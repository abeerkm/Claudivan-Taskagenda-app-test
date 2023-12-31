package test;

import infra.AppiumDriverProvider;
import infra.TestContext;
import org.junit.jupiter.api.BeforeEach;

public class Setup {
    private final TestContext context;
    private AppiumDriverProvider appiumDriverProvider;

    public Setup(TestContext context) {
        this.context = context;
    }
    @BeforeEach
    public void setUp() {
        appiumDriverProvider=new AppiumDriverProvider();
        context.put("driver",appiumDriverProvider.getDriver());

    }
}
