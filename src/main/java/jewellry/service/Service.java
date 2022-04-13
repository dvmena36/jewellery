package jewellry.service;


import jewellry.model.User;
import jewellry.repo.ItemRepository;
import jewellry.model.Item;
import jewellry.repo.UserInfoRepository;
import jewellry.repo.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jewellry.util.Html;

import java.util.List;

@RestController
public class Service {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;

    public Service(ItemRepository itemRepository, UserRepository userRepository, UserInfoRepository userInfoRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @RequestMapping("/gold{title}{user}")
    public String buyGold(@RequestParam String title,long user) {
        List<Item> itemList = itemRepository.findAByCategory("gold");
        String html = Html.createHeaderHtml(user);
        html += Html.createItemsHtml(itemList,user,false);
        Item gold = itemRepository.findByTitle(title);
        User customer = userRepository.getById(user);
        customer.addItem(gold);
        userRepository.save(customer);
            return html;
    }

    @RequestMapping("/silver{title}{user}")
    public String buySilver(@RequestParam String title,long user) {
        List<Item> itemList = itemRepository.findAByCategory("silver");
        String html = Html.createHeaderHtml(user);
        html += Html.createItemsHtml(itemList,user,false);
        Item silver = itemRepository.findByTitle(title);
        User customer = userRepository.getById(user);
        customer.addItem(silver);
        userRepository.save(customer);
        return html;
    }

    @RequestMapping("/save_sign_in{name}{email}{password}{user}")
    public String saveUser(@RequestParam String name,@RequestParam String email,@RequestParam String password,@RequestParam long user){
        User registeredUser = userRepository.save(new User(name,email,password));
            user = registeredUser.getId();
        return Html.createHeaderHtml(user) + "<p>User saved</p></body></html>";
    }

    @RequestMapping("/shopping-cart{user}")
    public String getShoppingCart(@RequestParam long user){
        String html = Html.createHeaderHtml(user);
        User customer = userRepository.findById(user).orElse(null);
        if(customer!=null){
            List<Item> items = customer.getItems();
            html += Html.createItemsHtml(items,user,true);
        }
        return html;
    }

//    @RequestMapping("/checkout{user}{address}{city}{country}{phonenumber}")
//    public String checkout(@RequestParam long user,@RequestParam String address,@RequestParam String city,@RequestParam String country,@RequestParam String phonenumber) throws URISyntaxException {
//        User customer = userRepository.getById(user);
//        userInfoRepository.save(new UserInfo(customer,address,city,country,phonenumber));
//        UserInfo userInfo = userInfoRepository.findById(customer.getId()).orElse(null);
//        String emailTo = customer.getEmail();
//        String subject = "your order for dmenahem.com - simulator";
//        String body = "Dear " + customer.getName() + " Thank you for using dmenahem.com\n" +
//                "We have received your order and will send it to the follwoing address: \n" +
//                "Address: " + userInfo.getAddress() + "\n" +
//                "City: " + userInfo.getCity() + " \n" +
//                "Country: " + userInfo.getCountry() + "\n" +
//                "We also have your phone number: " + userInfo.getPhoneNumber() + " \n" +
//                "We will contact you if we need to. \n" +
//                "Please feel free to contact us at : 053-8285199";
//        email.send(emailTo,body,subject);
//        return "email sent";
//    }

}
