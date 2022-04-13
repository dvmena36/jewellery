package jewellry.util;

import jewellry.model.Item;
import jewellry.model.User;
import org.springframework.stereotype.Component;
import jewellry.repo.ItemRepository;
import jewellry.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddItems {
    private static List<Item> itemList = new ArrayList<>();
    private static ItemRepository itemRepository = null;
    private static UserRepository userRepository = null;

    public AddItems(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public static void addItems() {
        itemList.add(new Item("Neckless Pearls", "A round ring with pearls and a gold plated ring on a neckless",
                119, "Neckless-Pearls.jpg", "gold"));
        itemList.add(new Item("Moon Earring", "Two moon shaped earrings", 100, "Moon-Earrings.jpg", "gold"));
        itemList.add(new Item("Ring", "Thick ring that is bigger on the top", 130, "Ring.jpg", "gold"));
        itemList.add(new Item("Face Earrings","Faced shaped earrings",120,"Face-Earrings.jpg","gold"));
        itemList.add(new Item("Decorated ring","A ring with a plate shape and stones",100,"Ring-decorated.jpg","gold"));
        itemList.add(new Item("Feather earrings","feather shaped earring with stones",80,"Feather-earrings.jpg","silver"));
        itemList.add(new Item("Large Feather Earrings","A larger feather pair of earrings",90,"Feather-Earrings-Large.jpg","silver"));
        itemList.add(new Item("Gold Neckless","A neckless with gold written on the medallion",110,"Neckless-Gold.jpg","gold"));
        itemList.add(new Item("Leaf-Neckless.jpg","A leaf shaped medallion on a neckless",100,"Leaf-Neckless.jpg","gold"));
        itemList.add(new Item("Crab Neckless","A crap shaped medallion on a neckless",110,"Crab-Neckless.jpg","gold"));
        itemList.add(new Item("Lock Neckless","A lock shaped medallion on a neckless",110,"Lock-Neckless.jpg","gold"));
        itemList.add(new Item("Neckless Face","A face printed on a medallion on a neckless",110,"Neckless-Face.jpg","gold"));
        itemList.add(new Item("Compass neckless","A compass printed on a medallion on a neckless",110,"Neckless-compass.jpg","gold"));
        itemList.add(new Item("Key Neckless","A key shaped medallion on a neckless",120,"Key-Neckless.jpg","gold"));
        itemList.add(new Item("Feather Earrings Blue Stone","Feather shaped earring with blue stones",80,"Feather-Earrings-Blue-Stone.jpg","silver"));
        itemList.add(new Item("Pearl Earrings","A pair of earrings with pearls",130,"Pearl-Earrings.jpg","gold"));
        itemList.add(new Item("Feather Earrings Gold","Feather shaped earrings",140,"Feather-Earrings-Gold.jpg","gold"));
        itemList.add(new Item("Neckless Royal","A royal face printed on a medallion on a neckless",140,"Neckless-Royal.jpg","gold"));
        itemList.add(new Item("Neckless Pesos","A pesos medallion on a neckless",120,"Neckless-Pesos.jpg","gold"));
        itemList.add(new Item("Medallion Neckless","A medallion neckless",120,"Medallion-Neckless.jpg","gold"));
        itemList.add(new Item("Locket Neckless","A locked shaped medallion on a neckless",120,"Locket-Neckless.jpg","gold"));
        List<Item> itemsList = AddItems.getItemList();
        for (Item item:
                itemsList) {
            itemRepository.save(item);
        }
        userRepository.save(new User("Guest","admin","1234"));
    }

    public static List<Item> getItemList() {
        return itemList;
    }
}

