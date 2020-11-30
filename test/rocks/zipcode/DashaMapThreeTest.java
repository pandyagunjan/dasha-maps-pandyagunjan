package rocks.zipcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class DashaMapThreeTest {

    @Test
    public void setTest(){
        DashaMapThree mapp = new DashaMapThree();
        mapp.set("AA", "10");
        mapp.set("ZZ", "1");
        String expected = mapp.get("AA");
        String actual = "10";

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void delete() {
        DashaMapThree dm = new DashaMapThree();
        dm.set("aaa", "5");
        dm.set("bbb", "15");
        dm.set("ccc", "20");
        String expected = "bbb";
        String actual = dm.delete("bbb");
        Assert.assertEquals(expected, actual);

        // Assert.fail("unimplemented test delete()");
    }

    @Test
    public void delete1() {
        DashaMapThree dm = new DashaMapThree();
        dm.set("aaa", "5");
        dm.set("bbb", "15");
        dm.set("ccc", "20");
        String expected = "item not found";
        String actual = dm.delete("ddd");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void delete2() {
        DashaMapThree dm = new DashaMapThree();
        dm.set("aaa", "5");
        dm.set("bbb", "15");
        dm.set("ccc", "20");
        dm.set("ddd", "25");
        dm.set("dad", "25");
        String expected = "item not found";
        String actual = dm.delete("def");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void get() {
        DashaMapThree dm = new DashaMapThree();

        dm.set("aaa", "5");
        String expected = "5";
        String actual = dm.get("aaa");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void get2() {
        DashaMapThree dm = new DashaMapThree();

        dm.set("aaa", "5");
        dm.set("aba", "3");
        dm.set("aac", "1");
        String expected = "5";
        String actual = dm.get("aaa");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        DashaMapThree dm = new DashaMapThree();

        Boolean expected = false;

        dm.set("aaa", "5");

        Boolean actual = dm.isEmpty();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        DashaMapThree dm = new DashaMapThree();

        dm.set("aaa", "5");
        dm.set("ab", "5");
        Long expected = 2L;
        Long actual = dm.size();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void bucketSize() {
        DashaMapThree dm = new DashaMapThree();

        dm.set("aaa", "5");
        dm.set("aba", "15");
        dm.set("acd", "25");
        dm.set("aag","10");
        Integer expected = 2;
        Integer actual = dm.bucketSize("aa");
      //  Integer actualForb = dm.bucketSize("b");
        Assert.assertEquals(expected, actual);
       // Assert.assertEquals(expected, actualForb);
    }
    @Test
    public void bucketSize1() {
        DashaMapThree dm = new DashaMapThree();

        dm.set("aaa", "5");
        dm.set("bbb", "5");
        Integer expected = 1;
        Integer actual = dm.bucketSize("aa");
        Assert.assertEquals(expected, actual);
    }



}