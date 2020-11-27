package rocks.zipcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class DashaMapTwoTest {

    @Test
    public void set() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        Integer expected = 1;
        Integer actual = dm.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void set2() {
        DashaMapTwo dm = new DashaMapTwo();

        Integer expected = 0;
        Integer actual = dm.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        DashaMapTwo dm = new DashaMapTwo();
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
        DashaMapTwo dm = new DashaMapTwo();
        dm.set("aaa", "5");
        dm.set("bbb", "15");
        dm.set("ccc", "20");
        String expected = "item not found";
        String actual = dm.delete("ddd");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        String expected = "5";
        String actual = dm.get("aaa");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void get2() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        dm.set("aba", "3");
        dm.set("aac", "1");
        String expected = "5";
        String actual = dm.get("aaa");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        DashaMapTwo dm = new DashaMapTwo();

        Boolean expected = false;

        dm.set("aaa", "5");

        Boolean actual = dm.isEmpty();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty2() {
        DashaMapTwo dm = new DashaMapTwo();

        Boolean expected = true;
        Boolean actual = dm.isEmpty();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        dm.set("ab", "5");
        Long expected = 2L;
        Long actual = dm.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bucketSize() {
        DashaMapTwo dm = new DashaMapTwo();

        dm.set("aaa", "5");
        dm.set("aab", "15");
        dm.set("aba", "25");
        dm.set("abb","10");
        Integer expected = 2;
        Integer actual = dm.bucketSize("a");
        Integer actualForb = dm.bucketSize("b");
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actualForb);
    }

    @Test
    public void testReadList() {
        DashaMapTwo dm = new DashaMapTwo();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "word-list.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ",2);
                dm.set(words[0], words[1]);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Long actual = dm.size();
        Long expected = 124L;
        Assert.assertEquals(expected, actual);
    }

}