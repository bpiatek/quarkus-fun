package b.piatek.author.domain;

/**
 * Created by Bartosz Piatek on 04/06/2023
 */
class Author {

    private Long id;
    private String name;
    private String nationality;

    public Author() {
    }

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Author(Long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
}
