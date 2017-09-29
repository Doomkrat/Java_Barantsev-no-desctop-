package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    
    @Test
    public void testGroupDeletion() {

        app.getGroupHelper().groupSelection();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }


}
