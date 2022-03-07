package Data;

public class DataProvider
{
    @org.testng.annotations.DataProvider(name = "login")
    public static Object[][] DataSet(){

        Object[][] obj = {
                {"standard_user", "23456S$"},
                {"srilanakamrst1@gmail.com", "12345S#"}
        };
        return obj;
    }
}
