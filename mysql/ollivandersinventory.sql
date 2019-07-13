SELECT
    w1.id, p.age, w1.coins_needed, w1.power
FROM
    WANDS w1 INNER JOIN WANDS_PROPERTY p USING(code) 
    INNER JOIN (
        SELECT MIN(coins_needed) coins_needed, power, code
        FROM WANDS
        GROUP BY power, code
    ) w2 ON w1.code = w2.code AND w1.coins_needed = w2.coins_needed AND w1.power = w2.power
WHERE
    p.is_evil = 0
ORDER BY
    w1.power DESC, p.age DESC
