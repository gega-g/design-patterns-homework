package ge.tbc.tbcitacademy.dataProvider;

public class DataProvider {
    @org.testng.annotations.DataProvider()
    public Object[][] userData() {
        return new Object[][]{
                {"firstName1", "lastName1", "Male", "11111111111"},
                {"firstName2", "lastName2", "Female", "22222222222"},
                {"firstName3", "lastName3", "Other", "33333333333"},
        };
    }
}
