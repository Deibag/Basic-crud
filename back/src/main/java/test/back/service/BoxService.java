package test.back.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import test.back.domain.Box;
import test.back.model.BoxDTO;
import test.back.repos.BoxRepository;


@Service
public class BoxService {

    private final BoxRepository boxRepository;

    public BoxService(final BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    public List<BoxDTO> findAll() {
        return boxRepository.findAll()
                .stream()
                .map(box -> mapToDTO(box, new BoxDTO()))
                .collect(Collectors.toList());
    }

    public BoxDTO get(final Integer id) {
        return boxRepository.findById(id)
                .map(box -> mapToDTO(box, new BoxDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Integer create(final BoxDTO boxDTO) {
        final Box box = new Box();
        mapToEntity(boxDTO, box);
        return boxRepository.save(box).getId();
    }

    public void update(final Integer id, final BoxDTO boxDTO) {
        final Box box = boxRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(boxDTO, box);
        boxRepository.save(box);
    }

    public void delete(final Integer id) {
        boxRepository.deleteById(id);
    }

    private BoxDTO mapToDTO(final Box box, final BoxDTO boxDTO) {
        boxDTO.setId(box.getId());
        boxDTO.setName(box.getName());
        return boxDTO;
    }

    private Box mapToEntity(final BoxDTO boxDTO, final Box box) {
        box.setName(boxDTO.getName());
        return box;
    }

}
