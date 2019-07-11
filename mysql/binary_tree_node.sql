SELECT
    N,
    CASE
        WHEN ISNULL(P) THEN 'Root'
        WHEN N IN (SELECT P FROM BST) THEN 'Inner'
        ELSE 'Leaf'
    END
FROM
    BST
ORDER BY
    N
