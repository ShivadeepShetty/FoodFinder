package com.app.foodfinder.data

import com.app.foodfinder.dto.Menu
import com.app.foodfinder.dto.MenuX
import com.app.foodfinder.dto.Restaurant
import com.app.foodfinder.dto.RestaurentResponse
import com.google.gson.Gson
import io.reactivex.Single


const val RESTAURANTS: String = "{\n" +
        "\"restaurants\":[\n" +
        "{\n" +
        "\"id\":1,\n" +
        "\"name\":\"Mission Chinese Food\",\n" +
        "\"neighborhood\":\"Manhattan\",\n" +
        "\"photograph\":\"1.jpg\",\n" +
        "\"address\":\"171 E Broadway, New York, NY 10002\",\n" +
        "\"latlng\":{\n" +
        "\"lat\":40.713829,\n" +
        "\"lng\":-73.989667\n" +
        "},\n" +
        "\"cuisine_type\":\"Asian, Chinese\",\n" +
        "\"operating_hours\":{\n" +
        "\"Monday\":\"5:30 pm - 11:00 pm\",\n" +
        "\"Tuesday\":\"5:30 pm - 12:00 am\",\n" +
        "\"Wednesday\":\"5:30 pm - 12:00 am\",\n" +
        "\"Thursday\":\"5:30 pm - 12:00 am\",\n" +
        "\"Friday\":\"5:30 pm - 12:00 am\",\n" +
        "\"Saturday\":\"12:00 pm - 4:00 pm, 5:30 pm - 12:00 am\",\n" +
        "\"Sunday\":\"12:00 pm - 4:00 pm, 5:30 pm - 11:00 pm\"\n" +
        "},\n" +
        "\"reviews\":[\n" +
        "{\n" +
        "\"name\":\"Steve\",\n" +
        "\"date\":\"October 26, 2020\",\n" +
        "\"rating\":4,\n" +
        "\"comments\":\"Mission Chinese Food has grown up from its scrappy\n" +
        "Orchard Street days into a big, two story restaurant equipped with a pizza\n" +
        "oven, a prime rib cart, and a much broader menu. Yes, it still has all the\n" +
        "hits — the kung pao pastrami, the thrice cooked bacon —but chef/proprietor\n" +
        "Danny Bowien and executive chef Angela Dimayuga have also added a raw bar, two\n" +
        "generous family-style set menus, and showstoppers like duck baked in clay. And\n" +
        "you can still get a lot of food without breaking the bank.\"\n" +
        "\n" +
        "},\n" +
        "{\n" +
        "\"name\":\"Morgan\",\n" +
        "\"date\":\"October 26, 2020\",\n" +
        "\"rating\":4,\n" +
        "\"comments\":\"This place is a blast. Must orders: GREEN TEA\n" +
        "NOODS, sounds gross (to me at least) but these were incredible!, Kung pao\n" +
        "pastrami (but you already knew that), beef tartare was a fun appetizer that we\n" +
        "decided to try, the spicy ma po tofu SUPER spicy but delicious, egg rolls and\n" +
        "scallion pancake i could have passed on... I wish we would have gone with a\n" +
        "larger group, so much more I would have liked to try!\"\n" +
        "\n" +
        "},\n" +
        "\n" +
        "{\n" +
        "\"name\":\"Jason\",\n" +
        "\"date\":\"October 26, 2020\",\n" +
        "\"rating\":3,\n" +
        "\"comments\":\"I was VERY excited to come here after seeing and\n" +
        "hearing so many good things about this place. Having read much, I knew going\n" +
        "into it that it was not going to be authentic Chinese. The place was edgy, had\n" +
        "a punk rock throwback attitude, and generally delivered the desired\n" +
        "atmosphere. Things went downhill from there though. The food was okay at best\n" +
        "and the best qualities were easily overshadowed by what I believe to be poor\n" +
        "decisions by the kitchen staff.\"\n" +
        "\n" +
        "}\n" +
        "]\n" +
        "},\n" +
        "{\n" +
        "\"id\":2,\n" +
        "\"name\":\"Emily\",\n" +
        "\"neighborhood\":\"Brooklyn\",\n" +
        "\"photograph\":\"2.jpg\",\n" +
        "\"address\":\"919 Fulton St, Brooklyn, NY 11238\",\n" +
        "\"latlng\":{\n" +
        "\"lat\":40.683555,\n" +
        "\"lng\":-73.966393\n" +
        "},\n" +
        "\"cuisine_type\":\"Pizza, American\",\n" +
        "\"operating_hours\":{\n" +
        "\"Monday\":\"5:30 pm - 11:00 pm\",\n" +
        "\"Tuesday\":\"5:30 pm - 11:00 pm\",\n" +
        "\"Wednesday\":\"5:30 pm - 11:00 pm\",\n" +
        "\"Thursday\":\"5:30 pm - 11:00 pm\",\n" +
        "\"Friday\":\"5:30 pm - 11:00 pm\",\n" +
        "\"Saturday\":\"5:00 pm - 11:30 pm\",\n" +
        "\"Sunday\":\"12:00 pm - 3:00 pm, 5:00 pm - 11:00 pm\"\n" +
        "},\n" +
        "\"reviews\":[\n" +
        "{\n" +
        "\"name\":\"Steph\",\n" +
        "\"date\":\"October 26, 2020\",\n" +
        "\"rating\":4,\n" +
        "\"comments\":\"Five star food, two star atmosphere. I would\n" +
        "definitely get takeout from this place - but dont think I have the energy to\n" +
        "deal with the hipster ridiculousness again. By the time we left the wait was\n" +
        "two hours long.\"\n" +
        "},\n" +
        "{\n" +
        "\"name\":\"Steve\",\n" +
        "\"date\":\"October 26, 2020\",\n" +
        "\"rating\":4,\n" +
        "\"comments\":\"This cozy Clinton Hill restaurant excels at both\n" +
        "straightforward and unusual wood-fired pizzas. If you want a taste of the\n" +
        "latter, consider ordering the Emily, which is topped with mozzarella,\n" +
        "pistachios, truffled sottocenere cheese, and honey. The menu includes salads\n" +
        "and a handful of starters, as well as a burger that some meat connoisseurs\n" +
        "consider to be among the best in the city.\"\n" +
        "\n" +
        "},\n" +
        "{\n" +
        "\n" +
        "\"name\":\"Sam\",\n" +
        "\"date\":\"October 26, 2020\",\n" +
        "\"rating\":5,\n" +
        "\"comments\":\"5 star atmosphere as it is very cozy with great\n" +
        "staff. 5 star food as their Emmy burger is outrageously good. and it's on a\n" +
        "pretzel bun.. Too juicy for its own good and downright addicting. Also try the\n" +
        "Colony pizza. Many others looked like worthy competitors, but the Colony\n" +
        "really found its way to my heart. When you start with a great crust, top it\n" +
        "with top notch cheese and sauce, you've got a winner. But, if you go a step\n" +
        "further and add the salty from the pepperoni, the sweet from the honey, and\n" +
        "the spicy from the chili oil.... your mouth is confused and happy at the same\n" +
        "time.\"\n" +
        "}\n" +
        "]\n" +
        "}\n" +
        "]\n" +
        "}"
const val MENU: String = "{\n" +
        "\t\"menus\": [{\n" +
        "\t\t\"restaurantId\": 1,\n" +
        "\t\t\"categories\": [{\n" +
        "\t\t\t\t\"id\": \"26576\",\n" +
        "\t\t\t\t\"name\": \"Appeteasers\",\n" +
        "\t\t\t\t\"menuitems\": [{\n" +
        "\t\t\t\t\t\t\"id\": \"94298\",\n" +
        "\t\t\t\t\t\t\"name\": \"3 Chicken Wings\",\n" +
        "\t\t\t\t\t\t\"description\": \"Tender, Spicy and Juicy. Original or Peri - Crusted \",\n" +
        "\t\t\t\t\t\t\"price\": \"250.00\",\n" +
        "\t\t\t\t\t\t\"images\": []\n" +
        "\t\t\t\t\t},\n" +
        "\t\t\t\t\t{\n" +
        "\t\t\t\t\t\t\"id\": \"94301\",\n" +
        "\t\t\t\t\t\t\"name\": \"Chicken Livers and Portuguese Roll\",\n" +
        "\t\t\t\t\t\t\"description\": \"Chicken Livers Topped with PERi-PERi Sauce, Served with A Roll To Soak Up The Sauce\",\n" +
        "\t\t\t\t\t\t\"price\": \"250.00\",\n" +
        "\t\t\t\t\t\t\"images\": []\n" +
        "\t\t\t\t\t}\n" +
        "\n" +
        "\t\t\t\t]\n" +
        "\t\t\t},\n" +
        "\n" +
        "\t\t\t{\n" +
        "\t\t\t\t\"id\": \"26588\",\n" +
        "\t\t\t\t\"name\": \"Peri-peri chicken\",\n" +
        "\t\t\t\t\"menuitems\": [{\n" +
        "\t\t\t\t\t\t\"id\": \"94349\",\n" +
        "\t\t\t\t\t\t\"name\": \"1/4 Chicken\",\n" +
        "\t\t\t\t\t\t\"description\": \"Quarter Chicken Marinated with PERi-PERi Sauce and Grilled\",\n" +
        "\t\t\t\t\t\t\"price\": \"385.00\",\n" +
        "\t\t\t\t\t\t\"images\": []\n" +
        "\t\t\t\t\t},\n" +
        "\t\t\t\t\t{\n" +
        "\t\t\t\t\t\t\"id\": \"94352\",\n" +
        "\t\t\t\t\t\t\"name\": \"1/2 Chicken\",\n" +
        "\t\t\t\t\t\t\"description\": \"Half Chicken Marinated with PERi-PERi Sauce and Grilled\",\n" +
        "\t\t\t\t\t\t\"price\": \"685.00\",\n" +
        "\t\t\t\t\t\t\"images\": []\n" +
        "\t\t\t\t\t}\n" +
        "\n" +
        "\n" +
        "\t\t\t\t]\n" +
        "\t\t\t}\n" +
        "\n" +
        "\n" +
        "\n" +
        "\t\t]\n" +
        "\t}]\n" +
        "}"

public class DataStore {

    companion object {
        public fun getRestaurants(): List<Restaurant> {
            return Gson().fromJson(RESTAURANTS, RestaurentResponse::class.java).restaurants
        }

        public fun getMenu(): List<MenuX> {

            return Gson().fromJson(MENU, Menu::class.java).menus
        }
    }


}