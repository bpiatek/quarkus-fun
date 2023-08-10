package b.piatek.author.domain;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
class QueryProvider {

    private QueryProvider() {
    }

    static String insert() {
        return """
            INSERT INTO author (name, nationality)
            VALUES ($1, $2)
            RETURNING *
            """;
    }

    static String selectAll() {
        return  """
            SELECT
                id, name, nationality
            FROM
                author
            """;
    }

    static String getById(long id) {
        return selectAll() + " WHERE id = " + id;
    }
}
