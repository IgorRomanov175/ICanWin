package dataProvide;

import org.testng.annotations.DataProvider;

public class DataProvide{

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }

}
