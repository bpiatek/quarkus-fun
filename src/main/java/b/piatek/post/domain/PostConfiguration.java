package b.piatek.post.domain;

import b.piatek.author.domain.AuthorFacade;
import jakarta.enterprise.inject.Produces;

import javax.inject.Singleton;

@Singleton
class PostConfiguration {

  @Produces
  PostFacade postFacade(
      AuthorFacade authorFacade,
      PostRepository repository,
      PostEntityMapper mapper) {
    return new PostFacade(authorFacade, repository, mapper);
  }
}
