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
-- CREATE TEMPORARY TABLE unique_submission_counts 
--     (submission_count INT(3));
    
-- INSERT INTO unique_submission_counts 
--         (   
--         SELECT DISTINCT COUNT(c1.hacker_id)
--         FROM
--             CHALLENGES c1
--         GROUP BY
--             c1.hacker_id
--         HAVING
--             c1.hacker_id <> h1.hacker_id
--         );
     
     
-- (SELECT 
--     h1.hacker_id, h1.name, COUNT(*) AS num_submissions
-- FROM
--     HACKERS h1 INNER JOIN CHALLENGES c USING(hacker_id) 
-- GROUP BY
--     h1.hacker_id, h1.name
-- HAVING 
--     num_submissions = 
--     (   
--         SELECT COUNT(hacker_id)
--         FROM
--             CHALLENGES
--         GROUP BY
--             hacker_id
--         ORDER BY 
--             COUNT(*) DESC
--         LIMIT 1        
--     )
--     OR num_submissions NOT IN unique_submission_counts
-- ORDER BY
--     COUNT(*) DESC, h1.hacker_id
-- );



-- hackerrank discussion alternative solution
-- /* these are the columns we want to output */
-- select c.hacker_id, h.name ,count(c.hacker_id) as c_count

-- /* this is the join we want to output them from */
-- from Hackers as h
--     inner join Challenges as c on c.hacker_id = h.hacker_id

-- /* after they have been grouped by hacker */
-- group by c.hacker_id

-- /* but we want to be selective about which hackers we output */
-- /* having is required (instead of where) for filtering on groups */
-- having 

--     /* output anyone with a count that is equal to... */
--     c_count = 
--         /* the max count that anyone has */
--         (SELECT MAX(temp1.cnt)
--         from (SELECT COUNT(hacker_id) as cnt
--              from Challenges
--              group by hacker_id
--              order by hacker_id) temp1)

--     /* or anyone who's count is in... */
--     or c_count in 
--         /* the set of counts... */
--         (select t.cnt
--          from (select count(*) as cnt 
--                from challenges
--                group by hacker_id) t
--          /* who's group of counts... */
--          group by t.cnt
--          /* has only one element */
--          having count(t.cnt) = 1)

-- /* finally, the order the rows should be output */
-- order by c_count DESC, c.hacker_id

-- /* ;) */
-- ;
