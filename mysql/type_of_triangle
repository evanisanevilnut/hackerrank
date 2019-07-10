SELECT
    CASE 
        WHEN A = B AND B = C THEN 'Equilateral'
        WHEN A = B AND A < C THEN IF(A + B > C, 'Isosceles', 'Not A Triangle')
        WHEN B = C AND B < A THEN IF(B + C > A, 'Isosceles', 'Not A Triangle')
        WHEN A = C AND A < B THEN IF(B + C > A, 'Isosceles', 'Not A Triangle')
        WHEN A < B AND B < C THEN IF(A+B > C, 'Scalene', 'Not A Triangle') -- A is the smallest
        WHEN A < C AND C < B THEN IF(A+C > B, 'Scalene', 'Not A Triangle') -- A is the smallest
        WHEN B < C AND C < A THEN IF(B+C > A, 'Scalene', 'Not A Triangle') -- B is the smallest
        WHEN B < A AND A < C THEN IF(B+A > C, 'Scalene', 'Not A Triangle') -- B is the smallest
        WHEN C < A AND A < C THEN IF(C+A > B, 'Scalene', 'Not A Triangle') -- C is the smallest
        WHEN C < B AND B < A THEN IF(C+B > A, 'Scalene', 'Not A Triangle') -- C is the smallest
    END
FROM 
    TRIANGLES
