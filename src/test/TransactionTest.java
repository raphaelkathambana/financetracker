package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Category;
import util.Transaction;
import util.parentCategory;

public class TransactionTest {
    @Test
    public void testDateAndString() {
        String dateString = "2020-10-17";
        var t = new Transaction("", dateString, 20, new Category("", "", parentCategory.INCOME.getCategory()));
        assertEquals(t.getDate().toString(), dateString);
    }

    @Test
    public void testDifferentDateTypes() {
        var t = new Transaction("", "2020-10-17", 20, new Category("", "", parentCategory.EXPENSE.getCategory()));
        assertNotEquals(t.getDate(), t.getSqlDate());
    }
}
