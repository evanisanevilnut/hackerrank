SELECT
    CONCAT(NAME,
            CASE 
                WHEN Occupation='Doctor' THEN '(D)'
                WHEN Occupation='Professor' THEN '(P)'
                WHEN Occupation='Singer' THEN '(S)'
                WHEN Occupation='Actor' THEN '(A)'
           END)
FROM
    OCCUPATIONS
ORDER BY
    NAME;

SELECT 
    CONCAT("There are a total of ", COUNT(OCCUPATION), " ", CONCAT(LOWER(OCCUPATION),"s.")) 
FROM 
    OCCUPATIONS 
GROUP BY 
    OCCUPATION 
ORDER BY 
    COUNT(OCCUPATION) ASC, OCCUPATION ASC
