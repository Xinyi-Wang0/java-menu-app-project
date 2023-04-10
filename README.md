# My Personal Project

An application for browsing the daily menu of the canteen. It allows
you to upload information about the dishes sold by the food court
each day. Possible features include viewing the different types of 
dishes offered each day; listing the raw materials for all dishes; 
the price of each dish.

The canteen manager can update the daily menu and students can view
the menu. The reason I'm interested in this is that lunchtime is short
every day during the school year, some people have a hard time making
a choice quickly, and people don't know much about what's in other
countries' dishes, they may have their own taboos. I wanted to use
this app to save people time and get some insight into the food.

## User Stories

A *story* list:
- As a user, I want to be able to add a dish to my menu.
- As a user, I want to be able to delete a dish from my menu.
- As a user, I want to be able to select a dish and view the
  recipe in detail.
- As a user, I want to be able to view a list of the names of the
  dishes in my menu.
- As a user, I would like to be able to see how many dishes are in
  my menu.
- As a user, I want to be able to save my menu to file
- As a user, I want to be able to be able to load my menu from file

# Instructions for Grader

- You can generate the first required action related to adding dish to 
  menu by click the button labelled "Add"
- You can generate the second required action related to delete dish 
  from menu by click the button labelled "delete"
- You can locate my visual component in ui->image package
- You can save the state of my application by click the button labelled 
  "save"
- You can reload the state of my application by click the button labelled
  "load"


## *Phase 4: Task 2*

Sun Apr 09 20:22:38 PDT 2023
Added dish: Burger

Sun Apr 09 20:22:40 PDT 2023
Viewed list of dishes:
List of Dishes:
Name:Burger

Sun Apr 09 20:22:45 PDT 2023
Removed dish: Burger

Sun Apr 09 20:22:49 PDT 2023
List of Dishes: empty 


## *Phase 4: Task 3*

I think in my demo, the hierarchy is not clear enough, for example, once 
I open it, there are only two buttons on it, but in a real window there 
might be a display of a form and then a selection of what functions are 
available to go to. Further, I may want to put save&load at one panel, and 
add&delete at another. Then in main, a full menu pops up every time a function 
is completed, and I might want to add a return command to avoid this.