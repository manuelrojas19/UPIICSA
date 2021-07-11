package mx.ipn.upiicsa.web.view;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.upiicsa.web.entity.Friend;

public class FriendsView {
	public static List<Friend> getAll() {
		List<Friend> friends = new ArrayList<Friend>();
		Friend f1 = new Friend();
		f1.setId(1);
		f1.setName("Manuel");
		f1.setLastName("Rojas");
		f1.setNickName("Manu");
		f1.setContactList(ContactsView.getContactsByFriend(f1));
		friends.add(f1);
		Friend f2 = new Friend();
		f2.setId(2);
		f2.setName("Charles");
		f2.setLastName("Ramos");
		f2.setNickName("Charles");
		f2.setContactList(ContactsView.getContactsByFriend(f2));
		friends.add(f2);
		Friend f3 = new Friend();
		f3.setId(3);
		f3.setName("Erick");
		f3.setLastName("Abelardo");
		f3.setNickName("El Erick");
		f3.setContactList(ContactsView.getContactsByFriend(f3));
		friends.add(f3);
		return friends;
	}
}
