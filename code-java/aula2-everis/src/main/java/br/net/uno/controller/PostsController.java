package br.net.uno.controller;

import br.net.uno.model.Posts;
import br.net.uno.repository.PostsRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@Controller("/posts")
public class PostsController {

    @Inject
    private PostsRepository postsRepository;

    @Post
    public HttpResponse<Posts> add(@Body @Valid Posts posts) {
        Posts save = postsRepository.save(posts);
        return HttpResponse.status(HttpStatus.CREATED).body(save);
    }

    @Get
    public HttpResponse<List<Posts>> get() {
        return HttpResponse.status(HttpStatus.OK).body(getPosts());
    }

    private List<Posts> getPosts() {
        Iterable<Posts> allPost = postsRepository.findAll();
        List<Posts> postsList = new ArrayList<>();
        allPost.iterator().forEachRemaining(postsList::add);
        return postsList;
    }



}
