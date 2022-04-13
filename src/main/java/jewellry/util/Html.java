package jewellry.util;

import jewellry.model.Item;

import java.util.List;

public class Html {
    public static String createItemsHtml(List<Item> itemList, long user,boolean isShoppingCart){
        StringBuilder html = new StringBuilder("<div id = \"container\">");
        double total = 0.0;
        for (Item item : itemList) {
            html.append("<div id =\"item\">\n");
            html.append("<h2 align = \"center\">").append(item.getTitle()).append("</h2>\n");
            if(!isShoppingCart) {
                html.append("<li><a href = \"/").append(item.getCategory()).append("?title=").append(item.getTitle()).append("&category=").append(item.getCategory()).append("&user=").append(user).append("\"").append(">Buy ").append(item.getTitle()).append("</a></li>").append("\n");
            }
            html.append("<a href = \"../items/").append(item.getImage()).append("\"><img src = \"../items/").append(item.getImage()).append("\" width = \"340px\" height = \"340px\" ").append("alt=\"").append(item.getTitle()).append("\" ></a>").append("\n");
            html.append("<div id = \"description\" \"width = \"23%\">").append(item.getDescription()).append("</div>").append("\n");
            html.append("<div id = \"price\">").append(item.getPrice()).append(" NIS</div></div>").append("\n");
            if(isShoppingCart){
                total += item.getPrice();
            }
        }
        html.append("</div>");
        if(isShoppingCart){
            html.append("<div> <form action = \"/checkout\" name=\"checkout\">" + "\n" +
                    "<input type = \"hidden\" name = \"user\" value=\"" + user + "\">" + "\n" +
                    "<label><b>Address:</b></label>" + "\n" +
                    "<input type = \"text\" name = \"address\" required>" + "\n" +
                    "<label><b>City:</b></label>" + "\n" +
                    "<input type = \"text\" name = \"city\" required>" + "\n" +
                    "<label><b>Country:</b></label>" + "\n" +
                    "<input type = \"text\" name = \"country\" required>" + "\n" +
                    "<label><b>Phone Number:</b></label>" + "\n" +
                    "<input type = \"text\" name = \"phonenumber\" required>" + "\n" +
                    "<input type=\"submit\">" + "\n" +
                    "</form></div>");
            html.append("Total:").append("<div id = \"total\">").append(total).append(" NIS</div>").append("\n");
        }
        html.append("</body></html>");
        return html.toString();
    }



    public static String createHeaderHtml(long user){
        String html = "<!DOCTYPE html>\n<head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "<Link rel = \"stylesheet\" href = \"../css/main.css\">\n";
        html +="<script src=\"main.js\"></script>" +
                "</head><body>\n";
        html += "<div w3-include-html = \"menu.html\"></div>\n";
        html += "<div id = \"header\">\n" +
                "    <h1 align=\"center\"> Jewelry </h1>\n" +
                "</div>\n" +
                "<ul id = \"menu\">\n" +
                "    <li><a href=\"index.html\">Home</a></li>\n" +
                "    <li><a>Category</a>\n" +
                "        <ul>\n" +
                "            <li><a href=\"/gold?title=&category=&user=" + user + "\">Gold</a></li>\n" +
                "            <li><a href=\"silver?title=&category=&user=" + user + "\">Silver</a></li>\n" +
                "        </ul>\n" +
                "    </li>\n" +
                "    <li><a href=\"about.html\">About</a></li>\n" +
                "    <li><a href=\"contact.html\">Contact</a></li>\n" +
                "    <li><a href=\"shopping-cart?user=" + user + "\">Shopping Cart</a></li>\n" +
                "    <li><a href=\"sign_in.html\">Sign in</a></li>\n" +
                "</ul>\n" +
                "</div>";
        return html;
    }
}
