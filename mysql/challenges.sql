(SELECT 
    h1.hacker_id, h1.name, COUNT(*) AS num_submissions
FROM
    HACKERS h1 INNER JOIN CHALLENGES c USING(hacker_id) 
GROUP BY
    h1.hacker_id, h1.name
HAVING 
    num_submissions = 
    (   
        SELECT COUNT(hacker_id)
        FROM
            CHALLENGES
        GROUP BY
            hacker_id
        ORDER BY 
            COUNT(*) DESC
        LIMIT 1        
    )
    OR num_submissions NOT IN 
    (   
        SELECT DISTINCT COUNT(c1.hacker_id)
        FROM
            CHALLENGES c1
        GROUP BY
            c1.hacker_id
        HAVING
            c1.hacker_id <> h1.hacker_id
     )
ORDER BY
    COUNT(*) DESC, h1.hacker_id
);



-- faster with proper permissions to create a temp table
CREATE TEMPORARY TABLE unique_submission_counts 
    (submission_count INT(3));
    
INSERT INTO unique_submission_counts 
        (   
        SELECT DISTINCT COUNT(c1.hacker_id)
        FROM
            CHALLENGES c1
        GROUP BY
            c1.hacker_id
        HAVING
            c1.hacker_id <> h1.hacker_id
        );
     
     
(SELECT 
    h1.hacker_id, h1.name, COUNT(*) AS num_submissions
FROM
    HACKERS h1 INNER JOIN CHALLENGES c USING(hacker_id) 
GROUP BY
    h1.hacker_id, h1.name
HAVING 
    num_submissions = 
    (   
        SELECT COUNT(hacker_id)
        FROM
            CHALLENGES
        GROUP BY
            hacker_id
        ORDER BY 
            COUNT(*) DESC
        LIMIT 1        
    )
    OR num_submissions NOT IN unique_submission_counts
ORDER BY
    COUNT(*) DESC, h1.hacker_id
);
