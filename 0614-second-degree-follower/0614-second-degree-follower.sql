SELECT
    A.followee AS follower,      -- take the user (from subquery A) and rename as 'follower'
    A.followed_by AS num         -- take their follower count from subquery A, rename as 'num'
FROM (
        -- Subquery A: Count how many followers each user has
        SELECT followee, COUNT(*) AS followed_by
        FROM follow
        GROUP BY followee
     ) A                         -- alias this result as table 'A'

INNER JOIN (
        -- Subquery B: Count how many users each person follows
        SELECT follower, COUNT(*) AS follows
        FROM follow
        GROUP BY follower
     ) B                         -- alias this result as table 'B'

-- Join condition: keep only users who appear in BOTH subqueries
-- i.e. they are followed by someone (A) AND they follow someone (B)
ON A.followee = B.follower

-- Sort final output alphabetically by user (called 'follower' in SELECT)
ORDER BY follower;