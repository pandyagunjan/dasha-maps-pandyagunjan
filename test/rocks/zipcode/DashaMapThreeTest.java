package rocks.zipcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class DashaMapThreeTest {

    @Test
    public void set() {
        DashaMapThree dm = new DashaMapThree();

        dm.set("aaa", "5");
        Integer expected = 1;
        Integer actual = dm.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void set2() {
        DashaMapThree dm = new DashaMapThree();

        Integer expected = 0;
        Integer actual = dm.bucketSize("a");
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
    public void isEmpty2() {
        DashaMapThree dm = new DashaMapThree();

        Boolean expected = true;
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
        dm.set("ab", "5");
        Integer expected = 1;
        Integer actual = dm.bucketSize("a");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadList() {
        DashaMapThree dm = new DashaMapThree();

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