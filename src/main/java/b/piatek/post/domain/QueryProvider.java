package b.piatek.post.domain;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.removeEnd;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
class QueryProvider {

    private QueryProvider() {
    }

    static String selectAll() {
        return  """
            SELECT
                id, author, message
            FROM
                post
            """;
    }

    static String insert() {
        return """
            INSERT INTO post (author, message)
            VALUES ($1, $2)
            RETURNING *
            """;
    }

    static String update(Post post) {
        var builder = new StringBuilder();
        builder.append("UPDATE post SET ");
        if (isNotBlank(post.getAuthor())) {
            builder.append("author = '")
                .append(post.getAuthor())
                .append("',");
        }

        if (isNotBlank(post.getMessage())) {
            builder.append("message = '")
                .append(post.getMessage())
                .append("',");
        }

        return builder.replace(builder.length() - 1, builder.length(), " ")
            .append("WHERE id = ")
            .append(post.getId())
            .append(" RETURNING *")
            .toString();
    }

}
