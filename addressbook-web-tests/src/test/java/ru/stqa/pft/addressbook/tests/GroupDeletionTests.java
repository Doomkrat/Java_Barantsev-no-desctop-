package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    
    @Test
    public void testGroupDeletion() {

        app.getGfroupHelper().groupSelection();
        app.getGfroupHelper().deleteGroup();
        app.getGfroupHelper().returnToGroupPage();
    }


}
