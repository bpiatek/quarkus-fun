package b.piatek.post.domain;

import jakarta.enterprise.inject.Produces;

import javax.inject.Singleton;

@Singleton
class PostConfiguration {

  @Produces
  PostFacade postFacade(PostRepository repository,
                        PostEntityMapper mapper) {
    return new PostFacade(repository, mapper);
  }
}
