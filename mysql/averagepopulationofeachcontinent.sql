SELECT
    co.CONTINENT, FLOOR(SUM(ci.POPULATION) / COUNT(*))
FROM 
    COUNTRY co, CITY ci
WHERE
    ci.COUNTRYCODE = co.CODE
GROUP BY
    CONTINENT

-- alternative (inner join)
SELECT
    co.CONTINENT, FLOOR(SUM(ci.POPULATION) / COUNT(*))
FROM 
    COUNTRY co INNER JOIN CITY ci ON ci.COUNTRYCODE = co.CODE
GROUP BY
    CONTINENT
