package com.coneseod.book.springboot.service.posts;

import com.coneseod.book.springboot.domain.posts.PostsRepository;
import com.coneseod.book.springboot.web.dto.PostsSaveRequestDto;
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
}
