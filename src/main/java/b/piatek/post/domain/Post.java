package b.piatek.post.domain;

/**
 * Created by Bartosz Piatek on 28/05/2023
 */

class Post {

    private Long id;
    private String author;
    private String message;

    public Post() {
    }

    Post(String author, String message) {
        this.author = author;
        this.message = message;
    }

    Post(Long id, String author, String message) {
        this.id = id;
        this.author = author;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
