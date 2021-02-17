package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTitle {

    @Test
    public void test() {
        AtomationTitle obj=new AtomationTitle();
        String expected="My Store";
        Assert.assertEquals(expected,obj.verifyTitle());
    }
}
