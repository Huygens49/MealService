CREATE TABLE meals.meals
(
    meal_id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 ),
    meal_date date NOT NULL,
    meal_reaction boolean NOT NULL,
    recipe_id bigint NOT NULL,
    PRIMARY KEY (meal_id),
    CONSTRAINT recipes_meals FOREIGN KEY (recipe_id)
        REFERENCES meals.recipes (recipe_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE meals.meals
    OWNER to huygens;