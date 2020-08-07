package com.kjh.webservice.service;

import com.kjh.webservice.SongType;
import com.kjh.webservice.domain.songs.SongsRepository;
import com.kjh.webservice.dto.songs.SongsMainResponseDto;
import com.kjh.webservice.dto.songs.SongsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SongsService {
    private SongsRepository songsRepository;

    @Transactional
    public Long save(SongsSaveRequestDto dto) {
        return songsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<SongsMainResponseDto> findAllDesc() {
        return songsRepository.findAllDesc()
                .map(SongsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongsMainResponseDto> findByTitle(String title) {
        return songsRepository.findByTitle(title)
                .map(SongsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongsMainResponseDto> findByArtist(String artist) {
        return songsRepository.findByArtist(artist)
                .map(SongsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongsMainResponseDto> findByTypeDesc(String type) {
        return songsRepository.findByType(type)
                .map(SongsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
