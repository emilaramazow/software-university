package course.springintro.restmvcdemo.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private String author;
    @NonNull
    @ElementCollection
    private Set<String> keywords = new HashSet<>();
    private Date created = new Date();
    private Date modified = new Date();


    public Post(@NonNull String title, @NonNull String content, @NonNull String author, @NonNull Set<String> keywords) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.keywords = keywords;
    }
}
