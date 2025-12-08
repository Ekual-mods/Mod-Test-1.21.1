**Ancient City Update (ACU)**

The Ancient City Update (ACU) is a Minecraft Forge 1.21.1 mod created for my COSC 111 final project. 
The goal is to expand and enhance the Deep Dark and Ancient City by adding new items, materials, and mechanics

**Current Features:**
- Echovium, a new material crafted from other resources from the Ancient City
- Custom tools and armor (sword, pickaxe, axe, shovel, hoe, full armor set)
- Custom armor material with unique values
- Smithing upgrade template for Echovium gear
- Extra damage mechanic: Echovium tools do bonus damage to the Warden and eventually custom mobs
- Data generation for recipes, tags, and models

**Main Java Files:**
- ACU.java – Main mod class
- ModItems.java – Registers all custom items
- ModArmorMaterials.java – Defines Echovium armor stats
- ModArmorItem.java – Custom armor behavior
- EchoviumBonusDamageHandler.java – Adds bonus damage to the Warden
- DataGenerators.java – Generates JSON data (recipes, tags, etc.)

**How to Run the Mod:**
- Clone the repository
- Open it in IntelliJ IDEA
- Let Gradle finish loading
- Run gradlew genIntellijRuns
- Launch the runClient configuration
- Items will be found in the creative mode inventory in the custom tabs on the next page!
