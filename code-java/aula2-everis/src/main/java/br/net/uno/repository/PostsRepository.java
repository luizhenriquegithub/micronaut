package br.net.uno.repository;

import br.net.uno.model.Posts;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Long> {

}
