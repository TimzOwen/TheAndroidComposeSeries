package com.example.happybirthdaycard

data class Recipe(
    val recipeDayResId: Int,
    val recipeImageRes: Int,
    val shortDescResId: Int,
    val longDescResId: Int
)

object RecipeData {
    val recipes = listOf(
        Recipe(
            recipeDayResId = R.string.day_1,
            recipeImageRes = R.drawable.image1,
            shortDescResId = R.string.recipe_1_short,
            longDescResId = R.string.recipe_1_long
        ),
        Recipe(
            recipeDayResId = R.string.day_2,
            recipeImageRes = R.drawable.image2,
            shortDescResId = R.string.recipe_2_short,
            longDescResId = R.string.recipe_2_long
        ),
        Recipe(
            recipeDayResId = R.string.day_3,
            recipeImageRes = R.drawable.image3,
            shortDescResId = R.string.recipe_3_short,
            longDescResId = R.string.recipe_3_long
        ),
        Recipe(
            recipeDayResId = R.string.day_4,
            recipeImageRes = R.drawable.image4,
            shortDescResId = R.string.recipe_4_short,
            longDescResId = R.string.recipe_4_long
        ),
        Recipe(
            recipeDayResId = R.string.day_5,
            recipeImageRes = R.drawable.image5,
            shortDescResId = R.string.recipe_5_short,
            longDescResId = R.string.recipe_5_long
        ),
        Recipe(
            recipeDayResId = R.string.day_6,
            recipeImageRes = R.drawable.image6,
            shortDescResId = R.string.recipe_6_short,
            longDescResId = R.string.recipe_6_long
        ),
        Recipe(
            recipeDayResId = R.string.day_7,
            recipeImageRes = R.drawable.image7,
            shortDescResId = R.string.recipe_7_short,
            longDescResId = R.string.recipe_7_long
        ),
        Recipe(
            recipeDayResId = R.string.day_8,
            recipeImageRes = R.drawable.image8,
            shortDescResId = R.string.recipe_8_short,
            longDescResId = R.string.recipe_8_long
        )
    )
}
