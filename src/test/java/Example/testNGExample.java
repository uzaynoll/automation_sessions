package Example;

import org.testng.annotations.*;

public class testNGExample {
    @Test
    public void testNGTest() {
        System.out.println("Test Annotation Method");
    }

    @Test
    public void testNGTest1() {
        System.out.println("Test Annotation Method1");
    }
    @BeforeTest
    public void BeforeTest() {
        System.out.println("Before Test ");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("After Class");
    }

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("After Suiter");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("AfterMethod");
    }
}
