package com.fsoft.z8.ip;

import com.fsoft.z8.ip.entity.ContentRatingEnum;
import com.fsoft.z8.ip.entity.ImdbPage;
import com.fsoft.z8.ip.entity.ImdbPerson;
import com.fsoft.z8.ip.entity.ImdbVideo;
import org.junit.Assert;

import java.util.List;

public final class TestHibernate extends TestUnit {

    @Override
    public void test() {

        // Create new person page
        ImdbPage personPage = new ImdbPage(1, "A person page", null, null);
        this.getPageDAO().saveOrUpdate(personPage);

        List<ImdbPage> pages = this.getPageDAO().getAll();
        Assert.assertFalse(pages.isEmpty());

        System.out.println("Created " + personPage.toString() + " from database.");

        for (ImdbPage page : pages) {
            ImdbPerson object = new ImdbPerson("A person name", null, null, page.getId());
            System.out.println("Intend to create " + object.toString() + " from database.");
            this.getPersonDAO().saveOrUpdate(object);
        }

        List<ImdbPerson> persons = this.getPersonDAO().getAll();
        Assert.assertFalse(persons.isEmpty());

        System.out.println("Created " + persons.get(0).toString() + " from database.");

        // Create new video page
        ImdbPage videoPage = new ImdbPage(2, "A video page", null, null);
        this.getPageDAO().saveOrUpdate(videoPage);

        pages = this.getPageDAO().getAll();
        Assert.assertTrue(pages.size() == 2);

        System.out.println("Created " + videoPage.toString() + " from database.");

        ImdbVideo video = new ImdbVideo("A video title", null, null, ContentRatingEnum.G.getCode(), videoPage.getId());
        this.getVideoDAO().saveOrUpdate(video);

        Assert.assertFalse(this.getVideoDAO().getAll().isEmpty());

        for (ImdbPerson person : persons) {
            System.out.println("Delete " + person.toString() + " from database.");
            this.getPersonDAO().delete(person);
        }

        for (ImdbVideo v : this.getVideoDAO().getAll()) {
            System.out.println("Delete " + v.toString() + " from database.");
            this.getVideoDAO().delete(v);
        }

        for (ImdbPage page : pages) {
            System.out.println("Delete " + page.toString() + " from database.");
            this.getPageDAO().delete(page);
        }
    }
}
