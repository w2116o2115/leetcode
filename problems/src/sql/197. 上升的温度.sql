-- 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
--
-- +---------+------------------+------------------+
-- | Id(INT) | RecordDate(DATE) | Temperature(INT) |
-- +---------+------------------+------------------+
-- |       1 |       2015-01-01 |               10 |
-- |       2 |       2015-01-02 |               25 |
-- |       3 |       2015-01-03 |               20 |
-- |       4 |       2015-01-04 |               30 |
-- +---------+------------------+------------------+
-- 例如，根据上述给定的 Weather 表格，返回如下 Id:
--
-- +----+
-- | Id |
-- +----+
-- |  2 |
-- |  4

-- MySQL 使用 DATEDIFF 来比较两个日期类型的值。
-- 因此，我们可以通过将 weather 与自身相结合，并使用 DATEDIFF() 函数。


SELECT
    weather.id AS 'Id'
FROM
    weather
        JOIN
    weather w ON DATEDIFF(weather.date, w.date) = 1
        AND weather.Temperature > w.Temperature
;