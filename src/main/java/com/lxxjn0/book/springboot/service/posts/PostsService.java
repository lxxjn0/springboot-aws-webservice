package com.lxxjn0.book.springboot.service.posts;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lxxjn0.book.springboot.domain.posts.Posts;
import com.lxxjn0.book.springboot.domain.posts.PostsRepository;
import com.lxxjn0.book.springboot.web.dto.PostsResponseDto;
import com.lxxjn0.book.springboot.web.dto.PostsSaveRequestDto;
import com.lxxjn0.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

		posts.update(requestDto.getTitle(), requestDto.getContent());

		return id;
	}

	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

		return new PostsResponseDto(entity);
	}

}
