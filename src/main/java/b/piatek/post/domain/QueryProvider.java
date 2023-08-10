package b.piatek.post.domain;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */
class QueryProvider {

    private QueryProvider() {
    }

    static String selectAll(long authorId) {
        var query =  """
            SELECT
                id, authorId, message
            FROM
                post
            """;
        if (authorId > 0) {
            query = query + " WHERE authorId = " + authorId;
        }

        return query;
    }

    static String insert() {
        return """
            INSERT INTO post (authorId, message)
            VALUES ($1, $2)
            RETURNING *
            """;
    }

    static String update(Post post) {
        var builder = new StringBuilder();
        builder.append("UPDATE post SET ");
        if (!isNull(post.getAuthorId())) {
            builder.append("authorId = '")
                .append(post.getAuthorId())
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
