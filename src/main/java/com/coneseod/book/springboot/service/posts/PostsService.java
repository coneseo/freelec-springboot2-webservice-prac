package com.coneseod.book.springboot.service.posts;

import com.coneseod.book.springboot.domain.posts.Posts;
import com.coneseod.book.springboot.domain.posts.PostsRepository;
import com.coneseod.book.springboot.web.dto.PostsResponseDto;
import com.coneseod.book.springboot.web.dto.PostsSaveRequestDto;
import com.coneseod.book.springboot.web.dto.PostsUpdateRequestDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto postsSaveRequestDto){
    return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto){
    Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
    posts.update(requestDto.getTitle(), requestDto.getContent());
    return id;
  }

  public PostsResponseDto findById(Long id){
    Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
    return new PostsResponseDto(entity);
  }
}
