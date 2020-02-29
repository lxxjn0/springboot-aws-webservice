package com.lxxjn0.book.springboot.service.posts;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lxxjn0.book.springboot.domain.posts.PostsRepository;
import com.lxxjn0.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}

}
