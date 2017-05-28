package test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJava {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(10));
        persons.add(new Person(11));
        persons.add(new Person(12));

        System.out.println("persons.size(): " + persons.size());
        System.out.println("persons.contains(new Person(10)): " + persons.contains(new Person(10)));
        System.out.println("persons.remove(new Person(10)): " + persons.remove(new Person(10)));
        System.out.println("persons.size(): " + persons.size());
    }

}
