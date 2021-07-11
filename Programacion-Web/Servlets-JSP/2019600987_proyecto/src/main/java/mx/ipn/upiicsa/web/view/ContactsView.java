package mx.ipn.upiicsa.web.view;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.upiicsa.web.entity.Contact;
import mx.ipn.upiicsa.web.entity.ContactType;
import mx.ipn.upiicsa.web.entity.Friend;

public class ContactsView {
	public static List<Contact> getContactsByFriend(Friend friend) {
		List<Contact> contacList = new ArrayList<Contact>();
		Contact c1 = new Contact();
		c1.setId(1);
		c1.setContactType(ContactType.PHONE);
		c1.setValue("+525584892004");
		contacList.add(c1);
		Contact c2 = new Contact();
		c2.setId(2);
		c2.setContactType(ContactType.FACEBOOK);
		c2.setValue("ManuelRojas99");
		contacList.add(c2);
		Contact c3 = new Contact();
		c3.setId(3);
		c3.setContactType(ContactType.TWITTER);
		c3.setValue("ManuelRojasRa");
		contacList.add(c3);
		Contact c4 = new Contact();
		c4.setId(4);
		c4.setContactType(ContactType.EMAIL);
		c4.setValue("manuelarr99@gmail.com");
		contacList.add(c4);
		return contacList;
	}
}
