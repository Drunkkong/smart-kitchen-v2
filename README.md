# Smart Kitchen

[toc]

## Phase 0

* External Database to store inventory
    * Fields: weight, count, name, description, expiration, units
* Code for recipe searching
    * Include using inventory to determine possible recipes based on favorite blogs

## Phase 1

* External database update
    * Store recipes, favorited, disliked, name, category, cook time
* Code updated to include filtering/sorting
    * Sorting to include meal type, cuisine, cook time
        * Meal Type: Breakfast, Lunch, Snack,...
        * Cuisine: French, Italian, ....
        * Cook Time: include ranges as well as set duration
* Save recipes as HTML or PDF to store and view in case pages go away

## Phase 2

* Code updated to include creating shopping list based off recipes selected
* Code updated to include common exchangeable things like lemon juice to vinegar

## Phase 3

* Add in external devices
    * RaspberryPi or Scanner
    * Potentially integrate with phones
    * Scanner for barcodes to allow more automated inventory control
    * Scale to weigh items
    * Scan receipts to allow more automated inventory control
* Update code to add in conversions and inventory management, volume or amount column to database
    * 2C of milk used to make X recipe, 1 gallon - 2C is Y gallons or Z cups or W oz
* Work with vendors/grocery stores to get access to database of barcodes?
    * Might be other solutions for this

## Phase 4

* Mobile app to show live grocery list, no need to print
* Database inventory update to include coupons and bargain shopping
    * Price matching or best deals
* Include pictures with barcodes early, 1 gallon of milk from Publix is the same as Walmart
* Utilize AI/ML to learn average usage for items
    * Help plan shopping trips
    * Often makes burgers during these months, so suggest burgers or suggest things other than burgers

## Future

* See if groceries want priority shopping
* Ads?
* Options for user to select milk is the same as milk from different stores
* Help with planning meals
* Display food/recipes for day/week/month
* Select/Integrate with preferred store API and generate grocery list/order for pickup
    * Utilize coupons