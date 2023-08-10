package b.piatek.post.domain;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */

class Post {

    private Long id;
    private Long authorId;
    private String message;

    public Post() {
    }

    Post(Long authorId, String message) {
        this.authorId = authorId;
        this.message = message;
    }

    Post(Long id, Long authorId, String message) {
        this.id = id;
        this.authorId = authorId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getMessage() {
        return message;
    }
}
