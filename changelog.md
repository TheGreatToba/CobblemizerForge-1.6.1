## [1.0.0 (December 28th, 2023)](#1-0-0)
- Initial Release

## [2.0.0 (January 3rd, 2023)](#2-0-0)
### Additions:
  - **Gender Swapper Item:** Allows swapping the gender of a Pokémon.
  - **Shiny Swapper Item:** Enables swapping the shiny status of a Pokémon.
  - **Caught Ball Swapper Items:**  Introduces items for changing the caught ball of a Pokémon.
  - **Nature Changer Items:**  Introduces items for changing the nature of a Pokémon.
#### Tier items:
Tier/Rarity items, with values changeable in the config (cobblemizer/cobblemizer.json)
***Tiered items:***

  - **Friendship Increasing Items:**  Introduces items for increasing the friendship levels of a Pokémon.
  - **IV increasing Items:**  Introduces items for increasing the IV levels of a Pokémon.
  - **EV increasing Items:**  Introduces items for increasing the EV levels of a Pokémon.
  - **Level increasing Items:**  Introduces items for increasing the Levels of a Pokémon.

### Changes
- **Mod Renaming:** Renamed the mod to "Cobblemizer: Cobblemon Customizer".
- **README and Description Update:** Updated the README file and mod description to reflect the mod's new name and features.
- **Item Relocation:** All items were relocated from the "Cobblemon Consumables" Creative Mode tab to the newly introduced "Cobblemaxer" Creative Mode tab.
- **Icon Modification:** The mod icon has been slightly modified.
- **Functionality Addition:** Implemented functionality for items to check whether the relevant statistic (E.g. IVs) is already maximized to prevent unnecessary item usage or loss.
- **Cobblemon version:** Updated to work with Cobblemon version 1.4.1. (should still function with 1.4.0)
- **Code changes:** Reorganized and redid large portions of code to introduce new tier system

## [1.7.1 (February 28th, 2026)](#1-7-1)
### Compatibility:
- Updated for Cobblemon 1.7.1 and Minecraft 1.21.1.
- Migrated PokeBalls API: Changed from `INSTANCE.getXYZ()` to static getter methods.
- Updated `Pokemon.getDisplayName()` calls: Added boolean parameter for consistency.

### Fixes:
- Fixed initialization hang: CaughtBallChanger items are now lazily initialized to avoid blocking at startup.
- Fixed garbled Pokémon names in chat messages: Migrated all item feedback messages to use `Text.literal().append(pokemon.getDisplayName(false)).append()` pattern for proper UTF-8 rendering.
- Fixed stat operations: IVRandomItem and IVMaxerItem now iterate only over 6 permanent stats (HP, ATTACK, DEFENCE, SPECIAL_ATTACK, SPECIAL_DEFENCE, SPEED) instead of all stats, excluding invalid accuracy/evasion stats.

### Updated Items:
- EVAddItem, IVAddItem, FriendshipAddItem, NatureChangerItem, GenderSwapItem, ShinySwapItem, CaughtBallChangerItem: All now correctly display Pokémon names in player feedback.

## [1.6.1 (February 27th, 2026)](#1-6-1)
### Fixes:
- Prevented server crash caused by level-altering items (Level Randomizer and Level Add). After changing a Pokémon's level the evolution proxy is cleared to discard any queued evolutions, avoiding serialization errors with temporary stats (accuracy/evasion).
- Added try/catch around evolution clearing to ensure items still consume even if the API call fails.
- Fixed UTF-8 encoding issues in player feedback messages for level-altering items; accented characters (é) now display correctly.
- Enhanced player feedback messages to display the Pokémon's name instead of generic text (e.g., "Salamèche level randomized" instead of "Pokémon level randomized").

### Compatibility:
- Updated for Cobblemon 1.6.1 and Minecraft 1.21.1.

### Notes:
- Applied the same evolution-clear logic and message improvements to both LVLRandomItem and LVLAddItem.
- Used `pokemon.getDisplayName()` to retrieve and respect Pokémon nicknames in messages.
