-- select hackers with max scores from submissions table
SELECT
    s.hacker_id, h.name
FROM
    submissions s
    INNER JOIN
    hackers h
    USING(hacker_id)
    INNER JOIN challenges c
    USING(challenge_id)
    INNER JOIN difficulty d
    USING(difficulty_level) 
WHERE
    s.score = d.score
GROUP BY
    s.hacker_id, h.name
HAVING
    COUNT(*) > 1
ORDER BY
    COUNT(*) DESC, s.hacker_id;
