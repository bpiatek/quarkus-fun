package b.piatek.post.api;

import bpiatek.proto.PostApiGrpc;
import bpiatek.proto.PostCreateRequest;
import bpiatek.proto.PostResponse;
import bpiatek.proto.PostUpdateRequest;
import io.grpc.StatusRuntimeException;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import io.vertx.mutiny.pgclient.PgPool;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@QuarkusTest
class PostGrpcApiTest {

  public static final String SOME_AUTHOR = "Some name";
  public static final String NEW_AUTHOR = "New name";
  public static final String SOME_MESSAGE = "Some message";
  public static final String NEW_MESSAGE = "New message";

  @GrpcClient
  PostApiGrpc.PostApiBlockingStub client;

  @Inject
  PgPool pool;

  @AfterEach
  void destroy() {
    clearTable();
  }

  @Test
  void shouldSuccessfullyUpdatePostsAllFields() {
    // given
    var postFromDb = insertPost();
    var request = PostUpdateRequest.newBuilder()
        .setId(postFromDb.getId())
        .setAuthor(NEW_AUTHOR)
        .setMessage(NEW_MESSAGE)
        .build();

    // when
    var response = client.updatePost(request);

    // then
    assertSoftly(softly -> {
      softly.assertThat(response.getId()).isEqualTo(postFromDb.getId());
      softly.assertThat(response.getAuthor()).isEqualTo(NEW_AUTHOR);
      softly.assertThat(response.getMessage()).isEqualTo(NEW_MESSAGE);
    });
  }

  @Test
  void shouldSuccessfullyUpdatePostAuthor() {
    // given
    var postFromDb = insertPost();
    var request = PostUpdateRequest.newBuilder()
        .setId(postFromDb.getId())
        .setAuthor(NEW_AUTHOR)
        .build();

    // when
    var response = client.updatePost(request);

    // then
    assertSoftly(softly -> {
      softly.assertThat(response.getId()).isEqualTo(postFromDb.getId());
      softly.assertThat(response.getAuthor()).isEqualTo(NEW_AUTHOR);
      softly.assertThat(response.getMessage()).isEqualTo(postFromDb.getMessage());
    });
  }

  @Test
  void shouldSuccessfullyUpdatePostMessage() {
    // given
    var postFromDb = insertPost();
    var request = PostUpdateRequest.newBuilder()
        .setId(postFromDb.getId())
        .setMessage(NEW_MESSAGE)
        .build();

    // when
    var response = client.updatePost(request);

    // then
    assertSoftly(softly -> {
      softly.assertThat(response.getId()).isEqualTo(postFromDb.getId());
      softly.assertThat(response.getAuthor()).isEqualTo(postFromDb.getAuthor());
      softly.assertThat(response.getMessage()).isEqualTo(NEW_MESSAGE);
    });
  }

  @Test
  void shouldFailToUpdatePostWhenIdIsNotProvided() {
    // given
    var postFromDb = insertPost();
    var request = PostUpdateRequest.newBuilder()
        .setMessage(NEW_MESSAGE)
        .setAuthor(NEW_AUTHOR)
        .build();

    // then
    assertThatExceptionOfType(StatusRuntimeException.class)
        .isThrownBy(() -> client.updatePost(request))
        .withMessageContaining("Id must bo provided and can not be 0!");
  }

  @Test
  void shouldFailToUpdatePostWhenIdZero() {
    // given
    var postFromDb = insertPost();
    var request = PostUpdateRequest.newBuilder()
        .setId(0)
        .setMessage(NEW_MESSAGE)
        .setAuthor(NEW_AUTHOR)
        .build();

    // then
    assertThatExceptionOfType(StatusRuntimeException.class)
        .isThrownBy(() -> client.updatePost(request))
        .withMessageContaining("Id must bo provided and can not be 0!");
  }

  @Test
  void shouldSuccessfullySavePost() {
    // given
    var request = PostCreateRequest.newBuilder()
        .setAuthor(SOME_AUTHOR)
        .setMessage(SOME_MESSAGE)
        .build();

    // when
    var response = client.savePost(request);

    // then
    assertSoftly(softly -> {
      softly.assertThat(response.getId()).isGreaterThan(0);
      softly.assertThat(response.getAuthor()).isEqualTo(request.getAuthor());
      softly.assertThat(response.getMessage()).isEqualTo(request.getMessage());
    });
  }

  @Test
  void shouldFailToSavePostWhenAuthorNotProvided() {
    // given
    var request = PostCreateRequest.newBuilder()
        .setMessage(SOME_MESSAGE)
        .build();

    // then
    assertThatExceptionOfType(StatusRuntimeException.class)
        .isThrownBy(() -> client.savePost(request))
        .withMessageContaining("Both author and message must be provided!");
  }

  @Test
  void shouldFailToSavePostWhenMessageNotProvided() {
    // given
    var request = PostCreateRequest.newBuilder()
        .setAuthor(SOME_AUTHOR)
        .build();

    // then
    assertThatExceptionOfType(StatusRuntimeException.class)
        .isThrownBy(() -> client.savePost(request))
        .withMessageContaining("Both author and message must be provided!");
  }

  @Test
  void shouldSuccessfullyGetAllPosts() {
    // given
    insertPost();
    insertPost();

    // when
    var posts = client.getPosts(null);

    // then
    assertThat(posts.getPostsList()).hasSize(2);
  }

  private PostResponse insertPost() {
    var request = PostCreateRequest.newBuilder()
        .setAuthor(SOME_AUTHOR)
        .setMessage(SOME_MESSAGE)
        .build();

    return client.savePost(request);
  }

  private void clearTable() {
    pool.query("DELETE FROM post").execute()
        .await()
        .indefinitely();
  }
}