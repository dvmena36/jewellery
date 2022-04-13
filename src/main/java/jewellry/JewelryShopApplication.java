package jewellry;

import jewellry.util.AddItems;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class JewelryShopApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JewelryShopApplication.class, args);
		//AddItems.addItems();
	}
}
