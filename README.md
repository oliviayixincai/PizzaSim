The Pizza Simulation finished by Group 1.
=========================================

Group member: Yixin Cai, Anson Ho, Yuxin Li, Gloria Chan, Andy Li, Eric Zheng

Major Interactions
------------------

### People Superclass

All people subclasses interface with Utils class to determine locations coordinates. Superclass abstracts animation for all subclasses.

Chef Main Interactions

Pizza

*   Chef checks pizza methods to make sure that pizza is fully made and can be moved

Oven

*   Chef checks oven methods to make sure that a pizza can be moved to that oven
*   Chef checks oven methods to reserve oven to make sure only 1 chef can put a pizza in at a time

Cashier Main Interactions

Oven

*   Checks oven methods to check if pizza is cooked and can be picked up

Customer

*   When a cashier is at a cashier till, it allows a customer to place their order. Customer accesses methods in cashier

Customer Main Interactions

Door

*   Checks for doors as they walk down the middle path, ignores doors if there are a lot of customers already in the store

CashierCounter

*   Checks and moves towards an empty counter, waits at the door if both cashiers are occupied

WaitingBar

*   Once arrived at the counter, the patience bar appears and displays their current mood, it lowers as their wait time increases

Order

*   When there is a cashier in front of them and an available chef, the customer will randomize and place an order

MoneyInterface

*   After they place an order, the cost of the pizza is added to the store income, indicated by a sound then moves to an empty counter to wait

Pizza

*   Checks and picks up the pizza that corresponds to their order, then leaves the store

Robber Interactions

MoneyInterface

*   “Steals” a set amount of money from the store.

### Level Superclass

Constantly checks the money value of both stores to change level variables. MyWorld constantly checks level variable and changes functionality of game accordingly

Main Interactions

Utils

*   Changes the utils value of level for each store depending on conditional statements based on money value

### Effect Superclass

Creates in game effects that make the game look more visually appealing and clear

Clock Functionality

Is initialized if the pizza is sent to an oven. Display a sequence of countdown images to show the time left for pizza to be cooked. If the time runs out, the clock will shake and alarm.

WaitingBar Functionality

The current happiness for the Customer. Each segment has its own unique gif with a total of 6 segments. A sound is played to indicate when a customer has reached the lowest mood. Once they pick up their pizza, tips are paid based on the current mood and a sound is played.

Order Functionality

Spawned after a customer orders. Visually displays the customer’s order by drawing out the order above the customer, and initializes a pizza.

Known Bugs
----------

*   Volume label does not match setting world after worlds change
*   Customer leave move method sometimes does not follow specified path. Unknown reason due to rarity

\*

Credit:
-------

Background music: Run Amok by Kevin MacLeod | https://incompetech.com/ Music promoted by https://www.chosic.com/free-music/all/ Creative Commons CC BY 3.0 https://creativecommons.org/licenses/by/3.0/

Click music: Sound Effect by [SennaFoxy](https://pixabay.com/users/sennafoxy-177
62344/?utm_source=link-attribution&utm_medium=referral&ut
m_campaign=music&utm_content=14388) from [Pixabay](https://pixabay.com//?utm_source=link-attribution&utm_medium=
referral&utm_campaign=music&utm_content=14388)

Angry hmp sound clips: Sound Effect from [Pixabay](https://pixabay.com/
sound-effects/?utm_source=link-attribution&utm_medium=referral&utm
_campaign=music&utm_content=38556)

Clock tik sound clip: Sound Effect from [Pixabay](https://pixabay.com/sound
-effects/?utm_source=link-attribution&utm_medium=referral&utm_campaign
=music&utm_content=55420)

Other Sound clips: https://pixabay.com/music/

"Aloe Vera Plants" from Pinterest (https://www.pinterest.ca/pin/all-6-plants-pattern-aloe-vera-potted-plant-succulent-ivy-etsy-in-2022--88172105197560932/).

"Animal Crossing Stepping Stones" by Rose from Pinterest (https://www.pinterest.ca/pin/538672805434277806/).

"16x16 Fence and Well" by William.Thompsonj from OpenGameArt (https://opengameart.org/content/16x16-fence-and-well-tiny-16).

“Pixel Art of Book Shelf Stack” from FreePik (https://www.freepik.com/premium-vector/pixel-art-book-shelf-stack\_16557038.htm).

Credits for the Chef and Customers are in the folder "credits". @author Group1 - Yixin Cai, Anson Ho, Yuxin Li, Gloria Chan, Andy Li, Eric Zheng @version November 2022
