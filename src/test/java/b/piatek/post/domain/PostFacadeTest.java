package b.piatek.post.domain;

import bpiatek.proto.PostDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.vertx.mutiny.pgclient.PgPool;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@QuarkusTest
@Transactional
class PostFacadeTest {

  public static final Long AUTHOR_ID = 1L;
  public static final Long NEW_AUTHOR_ID = 2L;
  public static final String SOME_MESSAGE = "Some post message";
  public static final String NEW_MESSAGE = "Some NEW message";

  @Inject
  PostFacade postFacade;

  @Inject
  PgPool pool;

  @AfterEach
  void destroy() {
    clearTable();
  }

  @Test
  void shouldSavePost() {
    // given
    var postDTO = PostDTO.newBuilder()
        .setAuthorId(AUTHOR_ID)
        .setMessage(SOME_MESSAGE)
        .build();

    // when
    var savedPost = postFacade.save(postDTO)
        .await()
        .indefinitely();

    // then
    assertSoftly(softly -> {
      softly.assertThat(savedPost.getId()).isGreaterThan(0L);
      softly.assertThat(savedPost.getAuthorId()).isEqualTo(AUTHOR_ID);
      softly.assertThat(savedPost.getMessage()).isEqualTo(SOME_MESSAGE);
    });
  }

  @Test
  void shouldGetAllPosts() {
    // given
    insertPost();
    insertPost();

    // when
    var postsFromDB = postFacade.getPosts(0, false)
        .await()
        .indefinitely();

    // then
    assertThat(postsFromDB).hasSize(2);
  }

  @Test
  void shouldUpdatePostAuthor() {
    // given
    var post = insertPost();
    var updateRequest = PostDTO.newBuilder()
        .setId(post.getId())
        .setAuthorId(NEW_AUTHOR_ID)
        .build();

    // when
    var updatedPost = postFacade.updatePost(updateRequest)
        .await()
        .indefinitely();

    // then
    assertSoftly(softly -> {
      softly.assertThat(updatedPost.getId()).isEqualTo(post.getId());
      softly.assertThat(updatedPost.getAuthorId()).isEqualTo(NEW_AUTHOR_ID);
      softly.assertThat(updatedPost.getMessage()).isEqualTo(post.getMessage());
    });
  }

  @Test
  void shouldUpdatePostMessage() {
    // given
    var post = insertPost();
    var updateRequest = PostDTO.newBuilder()
        .setId(post.getId())
        .setMessage(NEW_MESSAGE)
        .build();

    // when
    var updatedPost = postFacade.updatePost(updateRequest)
        .await()
        .indefinitely();

    // then
    assertSoftly(softly -> {
      softly.assertThat(updatedPost.getId()).isEqualTo(post.getId());
      softly.assertThat(updatedPost.getAuthorId()).isEqualTo(post.getAuthorId());
      softly.assertThat(updatedPost.getMessage()).isEqualTo(NEW_MESSAGE);
    });
  }

  @Test
  void shouldUpdatePostsAllFields() {
    // given
    var post = insertPost();
    var updateRequest = PostDTO.newBuilder()
        .setId(post.getId())
        .setAuthorId(NEW_AUTHOR_ID)
        .setMessage(NEW_MESSAGE)
        .build();

    // when
    var updatedPost = postFacade.updatePost(updateRequest)
        .await()
        .indefinitely();

    // then
    assertSoftly(softly -> {
      softly.assertThat(updatedPost.getId()).isEqualTo(post.getId());
      softly.assertThat(updatedPost.getAuthorId()).isEqualTo(NEW_AUTHOR_ID);
      softly.assertThat(updatedPost.getMessage()).isEqualTo(NEW_MESSAGE);
    });
  }


  private void clearTable() {
    pool.query("DELETE FROM post").execute()
        .await()
        .indefinitely();
  }


  private PostDTO insertPost() {
    PostDTO postDTO = PostDTO.newBuilder()
        .setAuthorId(AUTHOR_ID)
        .setMessage(SOME_MESSAGE)
        .build();
    return postFacade.save(postDTO)
        .await()
        .indefinitely();
  }

}
