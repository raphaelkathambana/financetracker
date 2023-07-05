package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.User;

/* this Test Class checks for all the ways one can validate an email
 ? some of the email addresses that will be valid via this email validation technique are:
testEmail * user.name@domain.com
 * user-name@domain.com
 * username@domain.co.in
 * user_name@domain.com
 ? Here's a shortlist of some email addresses that will be invalid via this email validation:

 ! username.@domain.com
 ! .user.name@domain.com
 ! user-name@domain.com.
 ! username@.com

 */
public class UserTest {

    String testEmail = "username@domain.com";
    @Test
    public void testUsingStrictRegex() {
        var emailAddress = testEmail;
        var regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        assertTrue(User.patternMatches(emailAddress, regexPattern));
    }

    @Test
    public void testUsingRFC5322Regex() {
        var emailAddress = testEmail;
        var regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        assertTrue(User.patternMatches(emailAddress, regexPattern));
    }

    @Test
    public void testTopLevelDomain() {
        var emailAddress = testEmail;
        var regexPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        assertTrue(User.patternMatches(emailAddress, regexPattern));
    }

    @Test
    public void testRestrictDots() {
        var emailAddress = testEmail;
        var regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@"
                + "[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        assertTrue(User.patternMatches(emailAddress, regexPattern));
    }

    @Test
    public void testGmailSpecialCase() {
        var emailAddress = "username+something@domain.com";
        var regexPattern = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
        assertTrue(User.patternMatches(emailAddress, regexPattern));
    }
}
