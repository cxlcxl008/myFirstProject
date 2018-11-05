package test;

import pers.xiaolong.VersionUtils;
import org.junit.Assert;
import org.junit.Test;

public class VersionUtilsTest {
    @Test
    public void compareTest(){
        Assert.assertEquals(VersionUtils.SMALLER,VersionUtils.compare("1.0","1.1"));
        Assert.assertEquals(VersionUtils.SMALLER,VersionUtils.compare("1.0","2.0"));
        Assert.assertEquals(VersionUtils.BIGGER,VersionUtils.compare("2.2","2.0"));
        Assert.assertEquals(VersionUtils.BIGGER,VersionUtils.compare("2.0","1.0"));
        Assert.assertEquals(VersionUtils.EQUAL,VersionUtils.compare("2.2","2.2"));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.compare(null,null));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.compare("",""));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.compare("1.1.1","1.1.2"));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.compare("1.1","1.1.2"));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.compare("a.1","1.1"));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.compare("1.1","a.1"));
    }
    @Test
    public void isCompatibleTest(){
        Assert.assertEquals(VersionUtils.NOT_COMPATIBLE,VersionUtils.isCompatible("1.0","2.0"));
        Assert.assertEquals(VersionUtils.COMPATIBLE,VersionUtils.isCompatible("2.0","2.0"));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.isCompatible(null,null));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.isCompatible("",""));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.isCompatible("1.1.1","1.1.2"));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.isCompatible("1.1","1.1.2"));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.isCompatible("a.1","1.1"));
        Assert.assertEquals(VersionUtils.INPUT_NOT_VALID,VersionUtils.isCompatible("1.1","a.1"));
    }
}
