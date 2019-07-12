SELECT
    ci.NAME
FROM
    CITY ci, COUNTRY co
WHERE
    ci.COUNTRYCODE = co.CODE AND CONTINENT = 'Africa'
    
-- alternative query (inner join)

SELECT
    ci.NAME
FROM
    CITY ci INNER JOIN COUNTRY ON COUNTRY.CODE = ci.COUNTRYCODE
WHERE
    CONTINENT = 'Africa'
